package heap.stark.designPattern;

import heap.stark.designPattern.singleton.Singleton;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * blogcode
 * Created by wangzhilei3 on 2017/12/30.
 */
public class Main {
    @Test
    public void singletonEqualTest(){
        for (int i =1;i<200;i++){
            Thread thread = new Thread(()->{
               if (Singleton.getInstance()!=Singleton.getInstance()){
                   System.out.println("error");
               }
            });

        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
