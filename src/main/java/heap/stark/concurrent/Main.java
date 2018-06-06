package heap.stark.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import heap.stark.concurrent.callable.Call;
import heap.stark.concurrent.forkJoin.SumTask;
import heap.stark.concurrent.threadLocal.SafeCounter;
import heap.stark.utils.MultiThreadTestUtil;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;

/**
 *blogcode
 * Created by wangzhilei3 on 2017/12/29.
 */
public class Main {
    /**
     * ThreadLocal,CountDownLatch,Semaphore,CyclicBarrier
     *
     * @throws Exception
     */
    @Test
    public void safeCounterTest() throws Exception {

        SafeCounter counter = new SafeCounter();
        //启动五个线程开始计数
        //CountDownLatch countDownLatch = new CountDownLatch(5);
        Semaphore semaphore = new Semaphore(1);
        semaphore.acquire();
        //semaphore.acquire();
        boolean b = semaphore.tryAcquire();
        assert (!b);
        //semaphore.release();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6,
                () -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException ignored) {

                    }
                    System.out.println(Thread.currentThread().getName() + ": " + "action");
                });
        MultiThreadTestUtil.multiThreadRun(() -> {
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + "before");
                try {
                    counter.counter();
                    cyclicBarrier.await();
                } catch (Exception ignored) {

                }
                System.out.println(Thread.currentThread().getName() + ": " + "after");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException ignored) {

                }
            }
        }, 5);
        cyclicBarrier.await();

        MultiThreadTestUtil.multiThreadRun(() -> {
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + "reuse before");
                try {
                    cyclicBarrier.await();
                } catch (Exception ignored) {

                }
                System.out.println(Thread.currentThread().getName() + ": " + "reuse after");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException ignored) {

                }
            }
        }, 5);


        cyclicBarrier.await();
    }

    /**
     * fork join Test
     */
    @Test
    public void forkJoinTest() {
        ForkJoinPool pool = new ForkJoinPool();
        SumTask sumTask = new SumTask(1, 10);
        Future<Integer> future = pool.submit(sumTask);
        if (sumTask.isCompletedAbnormally()){
            System.out.println();sumTask.getException();
        }
        try {
            assert (future.get() == 55);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void callableTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        assert (!executorService.isShutdown());
        assert (!executorService.isTerminated());
        Future<List<String>> future = executorService.submit(new Call());
        try {
            assert (!future.isDone() );
            List<String> result = (List) future.get();
            //executorService.shutdownNow();//调用future.get()抛出异常
            //future.cancel(false);
            assert (result.equals(Arrays.asList("hello", "world")));

        } catch (InterruptedException e) {
            assert false;
        } catch (Exception e) {
            assert false;
        }
        if (executorService.isShutdown()) throw new AssertionError();
        assert (!executorService.isTerminated() );

    }

    /**
     * Guava ThreadFactoryBuilder test
     */
    @Test
    public void threadFactoryTest() {

        final ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("Orders-%d")
                .setDaemon(true)
                .build();

        final ExecutorService executorService = Executors.newFixedThreadPool(10, threadFactory);
        for (int i = 0; i < 10; i++) {
            int a = i;
            executorService.execute(() -> {
                //thread name :Orders-9
                assert (Thread.currentThread().getName().equals("Orders-" + a));
            });
        }
    }

    /**
     * ScheduledExecutorServiceTest
     * 支持延时，支持周期任务
     */
    @Test
    public void ScheduledExecutorServiceTest() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(13);
        Future singleFuture = executorService.schedule(() -> "hello", 3, TimeUnit.SECONDS);
        Date date = new Date();
        Future callFuture = executorService.schedule(() -> new Date().getTime() - date.getTime(),
                10,
                TimeUnit.MILLISECONDS);
        try {

            assert (singleFuture.get() == "hello");
            assert ((Long) callFuture.get() <= 20 && (Long) callFuture.get() >= 9);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        Map<String, Long> map = new HashMap<>();
        map.put("key", new Date().getTime());
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ScheduledFuture future = executorService.scheduleAtFixedRate(() -> {
            countDownLatch.countDown();
            System.out.println(new Date().getTime());
            assert (new Date().getTime() - map.get("key") <= 1020 && new Date().getTime() - map.get("key") >= 1000);
            map.put("key", new Date().getTime());
        }, 1000, 1000, TimeUnit.MILLISECONDS);

        assert (!future.isDone());

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
