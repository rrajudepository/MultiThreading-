package Practice20;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main3 {
    public static void main(String[] args) {
        try{
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 3, 1, TimeUnit.HOURS,
         new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
           
         CompletableFuture<String> futureObj1 = CompletableFuture.supplyAsync(()->{
            System.out.println("Thread name which run supply async: "+ Thread.currentThread().getName());
            String name = "Rajkishor";
            return name;
         }, poolExecutor).thenApplyAsync((String name1)->{
             System.out.println("Thread name which run then Apply async: "+ Thread.currentThread().getName());
             return name1+" Ranjan";
         }).thenApplyAsync((String name2)->{
            System.out.println("Thread name which run second Then apply async: "+ Thread.currentThread().getName());
            return name2+" Kumar";
         }).thenApplyAsync((String name)->{
            System.out.println("Thread name which run the last then apply async: "+ Thread.currentThread().getName());
            return name+" is learning MultiThreading";
         });

         System.out.println(futureObj1.get());

         CompletableFuture<String> futureObj2 = CompletableFuture.supplyAsync(()->{
            System.out.println("Thread name which run supply async: "+ Thread.currentThread().getName());
            String name = "Rajkishor";
            return name;
         }, poolExecutor).thenCompose((String val)->{
            return CompletableFuture.supplyAsync(()->{
                System.out.println("Thread name which run thenCompose: "+ Thread.currentThread().getName());
                return val+" Ranjan";
            });
         });

         System.out.println(futureObj2.get());

         CompletableFuture<Void> futureObj3 = CompletableFuture.supplyAsync(()->{
            System.out.println("Thread name which run supplyAsync: "+ Thread.currentThread().getName());
            return "Programing is very conceptual";
         }, poolExecutor).thenAcceptAsync((String val)->{
            System.out.println(val);
            System.out.println("Running final stage");
         });



         System.out.println(futureObj3.get()); //print null

         poolExecutor.shutdown();


        }catch(Exception e){
            //handle exception here
        }
        

    }
}
