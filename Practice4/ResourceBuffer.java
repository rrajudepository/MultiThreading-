package Practice4;

import java.util.LinkedList;
import java.util.Queue;

public class ResourceBuffer {
    Queue<Integer> buffer;
    int capacity;
    int front = 0;
    public ResourceBuffer(int capacity){
        this.capacity = capacity;
        buffer = new LinkedList<>();
    }

    public void produce(int value){
        try{
            while(buffer.size()==capacity){
                    System.out.println("Buffer is full. Produer is waiting...\n\n");
                    wait();
                    System.out.println("Producer "+ Thread.currentThread().getName()+ " resumed.....");
            }
                   System.out.println("Item added to buffer by thread: "+Thread.currentThread().getName());
                    buffer.add(value);
                    System.out.println("Current Buffer Size: "+ buffer.size());
                    System.out.println("Notifying the consumer....\n\n");
                    notifyAll();
        
        }catch(Exception e){
            //handle exception here
        }
    }

    public void consumer(){
        try{
            while(buffer.size()==0){
                    System.out.println("Buffer is empty. Waiting fot producer to produce....\n\n");
                    wait();
                    System.out.println("Consumer "+Thread.currentThread().getName()+" resumed.....");
            }
                
                    int value = buffer.poll();
                    System.out.println("Item "+value +" consumed from buffer by thread: "+Thread.currentThread().getName());
                    System.out.println("Current Buffer Size: "+ buffer.size());
                    System.out.println("Notifying the producer....\n\n");
                    notifyAll();
                
            
        }catch(Exception e){
            //handle exception here
        }
    }
}
