package Practice10;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        ResourceShare resource = new ResourceShare();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        /*
        Runnable producerTask1 = ()->{
            resource.produceResource(lock);
        };

        Runnable producerTask2 = ()->{
            resource.produceResource(lock);
        };

        Runnable consumerTask1 = ()->{
            resource.consumerResource(lock);
        };

        Thread t1 = new Thread(producerTask1);
        Thread t2 = new Thread(producerTask2);
        Thread t3 = new Thread(consumerTask1);
        */

        Thread t1 = new Thread(()->{
         resource.produceResource(lock);
        });

        Thread t2 = new Thread(()->{
         resource.produceResource(lock);
        });

        Thread t3 = new Thread(()->{
            resource.consumerResource(lock);
        });


        t1.start();
        t2.start();
        t3.start();


        
    }
}
