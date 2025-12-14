package Practice18;

import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, 
        new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureObj = poolExecutor.submit(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("This is the task which thread will execute");
            } catch (Exception e) {
                //
            }
        });

        System.out.println("is Done: " + futureObj.isDone());
        try {
            futureObj.get(2, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("Timeout exception happened");
        }catch(Exception e){
            //
        }

        try{
            futureObj.get();
        }catch(Exception e){
            //handle exception here
        }

        System.out.println("Is done: "+ futureObj.isDone());
        System.out.println("is Cancelled: "+ futureObj.isCancelled());

        poolExecutor.shutdown();
    }
}

