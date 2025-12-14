package Practice34;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        CountNumber counter = new CountNumber();
        ThreadPoolExecutor poolObj = new ThreadPoolExecutor(1, 2, 1, TimeUnit.HOURS,
             new ArrayBlockingQueue<>(0));
        for(int i=0;i<4;i++){
            poolObj.submit(()->{
                System.out.println("Name of thread: "+ Thread.currentThread().getName());
               for(int j=0;j<200;j++){
                counter.increament();
               }
            });
        }
        System.out.println();
             
    }
}
