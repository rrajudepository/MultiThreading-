package Practice32;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5, 1, 
            TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            poolExecutor.allowCoreThreadTimeOut(true);

            Future<?> poolObj1 = poolExecutor.submit(()->{
                 try{
                    //Thread.sleep(5000);
                    System.out.println("Thread name: "+ Thread.currentThread().getName());
                 }catch(Exception e){
                    //handle exception here
                 }
            });
            // String output = "Rajkishor";
             List<Integer> value = new ArrayList<>();
            Future<List<Integer>> poolObj2 = poolExecutor.submit(()->{
                value.add(100);
                value.add(200);

            }, value);
            
            Future<List<Integer>> poolObj3 = poolExecutor.submit(()->{
                Thread.sleep(500);
                value.add(300);
                value.add(400);
                return value;
            });
            

            try{
                if(poolObj1.get()==null){
                    System.out.println("PoolObj1 return null");
                }else{
                    System.out.println("PoolObj1 does not return null");
                }
            }catch(Exception e){
                //handle exception here
            }

            try{
                List<Integer> value2 = poolObj2.get();
                System.out.println("PoolObj2 return: "+ value2);
            }catch(Exception e){

            }
            
            
            try{
                List<Integer> value3 = poolObj3.get();
                System.out.println("PoolObj3 return: "+ value3);
            }catch(Exception e){

            }
            

            poolExecutor.shutdown();
    }
}
