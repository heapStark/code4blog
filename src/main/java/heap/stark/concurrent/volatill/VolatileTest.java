package heap.stark.concurrent.volatill;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VolatileTest {
     volatile List<String> list = Arrays.asList("11", "11");

    @Test
    public void t() {
        Executor executor = Executors.newFixedThreadPool(10);
        final VolatileTest volatileTest = new VolatileTest();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (new Random().nextBoolean()) {
                        volatileTest.list = Arrays.asList("222", "222");
                    } else {
                        volatileTest.list = Arrays.asList("111", "111");
                    }
                }
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    /**foreach可以保证迭代同一个List*/
                    for (String s : volatileTest.list){
                        System.out.print(s);
                    }
                    System.out.println();
                    /*System.out.print(volatileTest.list.get(0));
                    System.out.println(volatileTest.list.get(1));*/
                }
            }
        });

        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
      volatile int i = new Integer(0);
    @Test
    public void tt() {
        Executor executor = Executors.newFixedThreadPool(10);
        final VolatileTest volatileTest = new VolatileTest();
        executor.execute(() -> {
            for (int i=0;i<100000;i++){
                volatileTest.i +=1;
            }
        });
        executor.execute(() -> {
            for (int i=0;i<100000;i++){
                volatileTest.i+=1;
            }
        });

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(volatileTest.i);
        //Assert.assertNotEquals(volatileTest.i,new Integer(20000));
    }

    public static void main(String[] args) {

    }
}
