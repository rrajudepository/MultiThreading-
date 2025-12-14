package Practice15;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        try(ThreadPoolExecutor poolexecutor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.HOURS, 
          new ArrayBlockingQueue<>(10), new CustomThreadFactor(), new CustomRejectedHandler())) {

            poolexecutor.allowCoreThreadTimeOut(true);

            for(int i=0;i<25;i++){
                poolexecutor.submit(()->{
                    try{
                        Thread.sleep(1000);
                        System.out.println("Thread Name: "+ Thread.currentThread().getName());
                    }catch(Exception e){
                        //handle exception here
                    }
                });
            }

            poolexecutor.shutdown();
        }
    }
}
