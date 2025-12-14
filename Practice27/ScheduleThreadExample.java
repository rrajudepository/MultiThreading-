package Practice27;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadExample {
    public static void main(String[] args) {
        ScheduledExecutorService poolObj = Executors.newScheduledThreadPool(5);

        poolObj.schedule(()->{
            System.out.println("This is Rajkishor");
            System.out.println("I am learnig schedule thread");
        }, 5, TimeUnit.SECONDS);

        Future<String> futureObj = poolObj.schedule(()->{
            String s1 = "This is Gunjan Yadav";
            String s2 = "I am learning Law Book";
            return s1+". "+s2;
        }, 5, TimeUnit.SECONDS);

        try{
            String s3 = futureObj.get();
            System.out.println(s3);
        }catch(Exception e){
          //handle exceotion here
        }
        

        poolObj.shutdown();
    }
}
