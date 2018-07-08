package heap.stark.concurrent;

import java.util.concurrent.TimeUnit;

public class DaemonTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(false);
        thread.start();
        System.out.println("------end------");
        //十秒后程序方可退出
    }
}
