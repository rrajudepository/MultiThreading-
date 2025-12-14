package Practice17;

import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
        new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new AbortPolicy());

        Future<?> futureObj = poolExecutor.submit(()->{
            try{
                Thread.sleep(7000);
                System.out.println("This is the task, which thread will execute");
            }catch(Exception e){
                //handle exception here
            }
        });

        System.out.println("is Done: "+ futureObj.isDone());

        try{
            futureObj.get(2, TimeUnit.SECONDS); //main thread wait for 2 sec to finish this thread. if it is not finished then return exception

        }catch(TimeoutException e){
            System.out.println("TimeoutException happened");

        }catch(InterruptedException e){
            System.out.println("InterruptedException happened");

        }catch(Exception e){
            System.out.println("ExecutionException happened");

        }

        try{
            futureObj.get(); //main thread wait for completion of the thread
        }catch(Exception e){
            //handle exception here
        }

        System.out.println("is Done: "+ futureObj.isDone());
        System.out.println("is Cancelled: "+ futureObj.isCancelled());
        
    }
}
