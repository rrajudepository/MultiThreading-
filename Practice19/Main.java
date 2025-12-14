package Practice19;

import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS,
            new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    //case 1
    Future<?> futureObj1 = poolExecutor.submit(()->{
        System.out.println("Task1 with Runnable and null return object");
    });

    try{
        Object object = futureObj1.get();
        if(object==null)
        System.out.println("Task1 with Runnable return null");
        
    }catch(Exception e){
        //
    }

    //case 2 
    List<Integer> output = new ArrayList<>();

    Future<List<Integer>> futureObj2 = poolExecutor.submit(()->{
        output.add(100);
        output.add(200);
        System.out.println("Task2 with Runnable and return object");

    }, output);

    try{
        List<Integer> case2 = futureObj2.get();
        System.out.println("Task2 with Runnable object: "+ case2);
    }catch(Exception e){
        //
    }

    //case 3
    Future<List<Integer>> futureobj3 = poolExecutor.submit(()->{
        output.add(300);
        output.add(400);
        System.out.println("Task3 with collable");
        List<Integer> listObj = new ArrayList<>();
        Collections.addAll(listObj, 100,200,300,400);
        return listObj;
    });

    try{
        List<Integer> case3 = futureobj3.get();
        System.out.println("Task3 with collable object: "+ case3);
    }catch(Exception e){
        //
    }
    poolExecutor.shutdown();

}
}
