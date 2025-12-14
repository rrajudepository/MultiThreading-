package Practice6;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread th1 = new Thread(()->{
            shareResource.producer(lock);
        });
        Thread th2 = new Thread(()->{
            shareResource.consumer(lock);
        });
        Thread th3 = new Thread(()->{
            shareResource.producer(lock);
        });

        th1.start();
        th2.start();
        th3.start();


    }
}
