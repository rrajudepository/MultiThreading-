package Practice28;

import java.util.LinkedList;
import java.util.Queue;
public class ShareResource {
    private Queue<Integer> buffer;
    private int bufferSize = 0;
    private int currentSize;

    public ShareResource(int bufferSize){
        this.bufferSize = bufferSize;
        buffer = new LinkedList<>();
    }

    public synchronized void producer(int value){
        try{
            while(currentSize>= bufferSize){
                System.out.println("Buffer is full. Producer "+Thread.currentThread().getName()+" is waiting for consumer. ");
                wait();
            }
            System.out.println("Producer "+ Thread.currentThread().getName() +" is adding value: "+ value);
            buffer.add(value);
            currentSize++;
            System.out.println("Current size of buffer is: "+ currentSize);
            notifyAll();
            Thread.sleep(1000);
        }catch(Exception e){
           //handle exception here
        }
        
    }

    public synchronized void consumer(){
        try{
             while(currentSize == 0){
                System.out.println("Buffer is empty. Consumer "+ Thread.currentThread().getName()+" is waiting for producer. ");
                wait();
             }
             int consumeItem = buffer.poll();
             System.out.println("Consumer is consuming item: "+consumeItem);
             currentSize--;
             System.out.println("Current size of buffer is: "+ currentSize);
             notifyAll();
             Thread.sleep(500);
        }catch(Exception e){
            //handle exception here

        }
    }

}
