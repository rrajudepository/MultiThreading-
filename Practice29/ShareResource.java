package Practice29;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ShareResource {
    private Queue<Integer> buffer;
    private int bufferSize;
    private int currentSize;
    private ReentrantLock lock = new ReentrantLock();
    private Condition produce = lock.newCondition();
    private Condition consume = lock.newCondition();

    public ShareResource(int bufferSize){
        buffer = new LinkedList<>();
        this.bufferSize = bufferSize;
        currentSize = 0;
    }

    public void produceItem(int value){
        try{
            lock.lock();
            while(currentSize>=bufferSize){
                System.out.println("Buffer is full and Producer "+ Thread.currentThread().getName()+ " is waiting for consumer.");
               produce.await();
            }

            System.out.println("Producer "+ Thread.currentThread().getName()+" is adding item value "+value);
            buffer.add(value);
            currentSize++;
            System.out.println("Buffer size is: "+ currentSize);
            consume.signal();
            Thread.sleep(500);


        }catch(Exception e){
            //handle exception here
        }finally{
            lock.unlock();
        }
    }


    public void consumeItem(){
        try{
            lock.lock();
            while(currentSize==0 || buffer.isEmpty()){
                System.out.println("Buffer is empty. Consumer "+ Thread.currentThread().getName()+ " is waiting for producer.");
                consume.await();
            }
            int item = buffer.poll();
            System.out.println("Consumer "+ Thread.currentThread().getName()+ " is consuming the item: "+item);
            currentSize--;
            System.out.println("Buffer size is "+ currentSize);
            produce.signal();
            Thread.sleep(700);
            

        }catch(Exception e){
            //handle exception here
        }finally{
            lock.unlock();
        }
    }



}
