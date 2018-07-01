package heap.stark.jvmtool;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class StackTraces {
    @Test
    public void t(){
        Map<Thread,StackTraceElement []> map= Thread.currentThread().getAllStackTraces();
        System.out.println(map);
        for (Map.Entry entry : map.entrySet()){
            if (entry.getKey().equals(Thread.currentThread())){
                System.out.println(entry.getKey());
            }
            System.out.println(entry.getKey());
            System.out.println( Arrays.asList(entry.getValue().toString()));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true){
            Thread.sleep(100);
            Thread.sleep(100);
        }
    }

}
