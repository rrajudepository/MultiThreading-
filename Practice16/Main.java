package Practice16;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import Practice15.CustomThreadFactor;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        try (ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5, 1,
         TimeUnit.HOURS, new ArrayBlockingQueue<>(10), new CustomThreadFactor(), new CustomeRejectedHandler())) {
            ShareResource resource = new ShareResource();

            poolExecutor.allowCoreThreadTimeOut(false);

            for(int i=0; i<30; i++){
                poolExecutor.submit(()->{
                    try{
                        Thread.sleep(5000);
                        //resource.produce();

                        System.out.println("Thread name: "+ Thread.currentThread().getName());
                    }catch(Exception e){
                        //Handle exception here
                    }
                });
            }
            poolExecutor.shutdown();
            poolExecutor.awaitTermination(1, TimeUnit.HOURS);
            System.out.println("Value of counter: "+ resource.getCounter());
        }
    }
}
