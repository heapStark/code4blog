package heap.stark.jvmtool.oom;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * -Xms1600m -Xss12m
 * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 */
public class OomNative {
    public static void main(String[] args) {
         try {
             while (true){
                 new Thread(new Runnable() {
                     @Override
                     public void run() {
                         try {
                             TimeUnit.SECONDS.sleep(10);
                             ByteBuffer byteBuffer = ByteBuffer.allocate(122);

                         } catch (Exception e){
                             e.printStackTrace();
                         }
                     }
                 }).start();
             }
         }catch (Exception e){

         }

        System.out.println("--------end");
    }
}
