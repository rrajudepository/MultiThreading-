package Practice20;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main2 {
    public static void main(String[] args) {
        try{
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 3, 1, TimeUnit.HOURS,
            new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
             
            CompletableFuture<String> futureObj = CompletableFuture.supplyAsync(()->{
                //Task to complete
                System.out.println("Thread name which run async method: "+ Thread.currentThread().getName());
                return "Rajkishor";
            }, poolExecutor).thenApplyAsync((String val)->{
                //More functionality
                System.out.println("Thread name which runs then apply async: "+ Thread.currentThread().getName());
                return val+" Ranjan Kumar";
            });
            
            String result = futureObj.get();
            System.out.println(result);


            CompletableFuture<String> futureObj2 = CompletableFuture.supplyAsync(()->{
                System.out.println("Thread name which run async method: "+ Thread.currentThread().getName());
                return "I am learning";
            }, poolExecutor).thenApply((String val)->{
                System.out.println("Thread name which run then apply: "+ Thread.currentThread().getName()); //Main thread
                return val+" Multithreading";
            });

            try{
                String result2 = futureObj2.get();
                System.out.println(result2);
            }catch(Exception e){
                //handle exception here....
            }


            CompletableFuture<String> futureObj3 = CompletableFuture.supplyAsync(()->{
                System.out.println("Thread name which run async method: "+ Thread.currentThread().getName());
                return "I am learning";
            }).thenApplyAsync((String val)->{
                System.out.println("Thread name which run then apply: "+ Thread.currentThread().getName());
                return val+" Multithreading";
            }, poolExecutor);

            try{
                String result3 = futureObj3.get();
                System.out.println(result3);
            }catch(Exception e){
                //handle exception here....
            }

            poolExecutor.shutdown();

        }catch(Exception e){

        }
    }
}
