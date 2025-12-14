package Practice34;

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

    public synchronized void produceItem(int value){
         try{
            lock.lock();
            while(currentSize>=bufferSize){
                System.out.println("Buffer size is full. Producer is waiting for consumer");
                produce.await();
            }
            System.out.println("Producer "+ Thread.currentThread().getName+" is producing item: "+ value);
            buffer.add(value);
            consume.signalAll();
         }catch(Exception e){

         }
    }

    public synchronized void consumeItem(){
        try{
            lock.lock();

            while(currentSize ==  0){
                System.out.println("Buffer is empty. Consumer is waiting for producer.");
                consume.await();
            }
            int value = buffer.poll();
            System.out.println("Consumer "+ Thread.currentThread().getName()+ " is consuming item: "+value);
        }catch(Exception e){

        }
    }
}
