package Practise30;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.Queue;

public class Resource {
    Queue<Integer> buffer;
    Semaphore lock = new Semaphore(2);

    public Resource(){
        buffer = new LinkedList<>();
    }

    public void produce(int value){
         try{
            lock.acquire();
            System.out.println("Producer "+ Thread.currentThread().getName()+" is adding item "+ value);
            buffer.add(value);
            System.out.println("Buffer size is "+ buffer.size());
            Thread.sleep(500);
         }catch(Exception e){
            //handle exception here
         }finally{
            lock.release();
            System.out.println("Lock released by thread "+ Thread.currentThread().getName());
         }
    }
}
