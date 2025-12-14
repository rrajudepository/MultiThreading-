package Practice20;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
         new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
       
       
         CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(()->{
        //Task need to completed by thread
        System.out.println("TASK NEED TO COMPLETED BY THREAD");
        return "task completed";
    }, poolExecutor);
    
    try{
        System.out.println(asyncTask1.get());
    }catch(Exception e){
        //handle exception here
    }

    poolExecutor.shutdown();
    }
}
