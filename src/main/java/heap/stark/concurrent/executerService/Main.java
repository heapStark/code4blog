package heap.stark.concurrent.executerService;

import heap.stark.concurrent.blockingQueue.AbstractRun;
import heap.stark.concurrent.blockingQueue.TimeQueue;
import heap.stark.utils.MultiThreadTestUtil;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhilei3 on 2017/12/29.
 */
public class Main {

    @Test
    public void voidTest() {

    }

    public static void main(String... args) {

    }

    /**
     * 只有一个线程
     */
    @Test
    public void queueTest() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                1,
                10L,
                TimeUnit.SECONDS,
                new TimeQueue(10, 1000),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        for (int i = 0; i < 10; i++) {
            final int x = i;
            Future future = threadPoolExecutor.submit(new AbstractRun(new Date().getTime()) {
                @Override
                public void run() {
                    try {
                        System.out.println(x);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * threadPoolExecutor
     */
    @Test
    public void threadPoolExecutorTest() {
        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(4);
                System.out.println(new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                2,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
                new ThreadPoolExecutor.DiscardPolicy()
        ) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("ActiveCount before" + this.getActiveCount());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("ActiveCount after" + this.getActiveCount());
            }
        };//最多同时执行两个任务，接受三个任务
        //threadPoolExecutor.prestartAllCoreThreads();
        threadPoolExecutor.submit(runnable);
        assert (threadPoolExecutor.getPoolSize() == 1);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);//任务提交失败
        System.out.println(threadPoolExecutor.getTaskCount());
        assert (threadPoolExecutor.getTaskCount() == 3);
        assert (threadPoolExecutor.getCompletedTaskCount() == 0);
        assert (threadPoolExecutor.getLargestPoolSize() == 2);
        assert (threadPoolExecutor.getPoolSize() == 2);
        assert (threadPoolExecutor.getActiveCount() == 2);
        try {
            TimeUnit.SECONDS.sleep(5);
            assert (threadPoolExecutor.getActiveCount() == 1);
            TimeUnit.SECONDS.sleep(5);
            assert (threadPoolExecutor.getActiveCount() == 0);
            assert (threadPoolExecutor.getTaskCount() == 3);
            threadPoolExecutor.shutdown();
            TimeUnit.SECONDS.sleep(1);
            assert (threadPoolExecutor.isTerminated());
            threadPoolExecutor.submit(runnable);
            System.out.println(threadPoolExecutor.getActiveCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static volatile int a = 0;
    static int b = 0;

    @Test
    public void volatileTest() {
        try {
            MultiThreadTestUtil.multiThreadRun(() -> {
                for (int i = 0; i < 100; i++) {
                    a++;
                    b++;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
        System.out.println(b);
        //都会存在并发问题
        assert (a == 500);
        assert (b != 500);
    }
}
