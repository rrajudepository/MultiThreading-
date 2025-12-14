package Practice31;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.HOURS, 
            new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        poolExecutor.allowCoreThreadTimeOut(true);
        for(int i=1;i<=25;i++){
            poolExecutor.submit(()->{
               try{
                    Thread.sleep(5000);
                   System.out.println("Working thread name: "+ Thread.currentThread().getName());
               }catch(Exception e){

               }
            });
        }
        
       try{
          poolExecutor.shutdown();
          poolExecutor.awaitTermination(1, TimeUnit.HOURS);
       }catch(Exception e){

       }
       
    }
}
