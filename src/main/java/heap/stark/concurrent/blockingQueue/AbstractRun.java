package heap.stark.concurrent.blockingQueue;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public abstract class AbstractRun extends FutureTask {
    private static final Callable CALLABLE = new Callable() {
        @Override
        public Object call() throws Exception {
            return null;
        }
    };
    private long timeStamp;

    public AbstractRun(long timeStamp) {
        super(CALLABLE);
        this.timeStamp = timeStamp;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public abstract void run();
}
