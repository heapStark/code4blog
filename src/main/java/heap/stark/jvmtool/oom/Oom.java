package heap.stark.jvmtool.oom;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * Exception in thread "Thread-0" java.lang.OutOfMemoryError: Java heap space
 * 抛出OOM之前一定会触发GC
 */
public class Oom {
    public static void main(String[] args) {
         new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1222222222);
                    while (true){
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
                ByteBuffer byteBuffer = ByteBuffer.allocate(111111111);
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("123");
    }
}
