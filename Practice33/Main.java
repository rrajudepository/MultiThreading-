package Practice33;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 3, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(5),
    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    poolExecutor.allowCoreThreadTimeOut(false);

    CompletableFuture<String> poolObj1 = CompletableFuture.supplyAsync(()->{
        System.out.println("Thread name: "+ Thread.currentThread().getName());
        String firstName = "Rajkishor";
        return firstName;
    }, poolExecutor);
    String name = new String();
    try{
        name = poolObj1.get();
    }catch(Exception e){
        //hanlde exception here
    }
    System.out.println("Pool Object return value: "+name);

    CompletableFuture<String> poolObj2 = CompletableFuture.supplyAsync(()->{
        System.out.println("Thread name: "+ Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }catch(Exception e){

        }
        String firstName = "Rajkishor";
        return firstName;
    }, poolExecutor).thenApplyAsync((String firstName)->{

        System.out.println("Thread name: "+ Thread.currentThread().getName());
        String secondName = " Ranjan Kumar";
        return firstName+secondName;
    });

    try{
        String personName = poolObj2.get();
        System.out.println("Name of the person is: "+ personName);
    }catch(Exception e){
        System.out.println("Exception occurs");
    }

    CompletableFuture<String> poolObj3 = CompletableFuture.supplyAsync(()->{
        System.out.println("Thread name: "+ Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }catch(Exception e){

        }
        String firstName = "I am learning multiThreading and";
        return firstName;
    }, poolExecutor).thenApply((String firstName)->{

        System.out.println("Thread name: "+ Thread.currentThread().getName());
        String secondName = " MultiThreading is awesome.";
        return firstName+secondName;
    });

    try{
        String personName = poolObj3.get();
        System.out.println("Name of the person is: "+ personName);
    }catch(Exception e){
        System.out.println("Exception occurs");
    }


    poolExecutor.shutdown();
    }

    
}
