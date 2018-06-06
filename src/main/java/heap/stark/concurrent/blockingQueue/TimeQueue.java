package heap.stark.concurrent.blockingQueue;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 支持任务超时设置
 */
public class TimeQueue<E extends AbstractRun> extends LinkedBlockingQueue<Runnable> {
    private long timeOut;

    public TimeQueue(int c, long timeOut) {
        super(c);
        this.timeOut = timeOut;
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E abstractRun = (E) super.poll(timeout, unit);
        System.out.println(abstractRun);
        if (abstractRun.getTimeStamp() + this.timeOut > new Date().getTime()) {
            return null;
        }
        return abstractRun;
    }

    @Override
    public E poll() {
        E abstractRun = (E) super.poll();
        System.out.println(abstractRun);
        if (abstractRun.getTimeStamp() + timeOut > new Date().getTime()) {
            return null;
        }
        return abstractRun;
    }

    @Override
    public E take() throws InterruptedException {
        E abstractRun = (E) super.take();
        //System.out.println(abstractRun);
        if (abstractRun != null && abstractRun.getTimeStamp() + timeOut > new Date().getTime()) {
            super.take();
            //super.remove();
            return null;
        }
        return abstractRun;
    }
}
