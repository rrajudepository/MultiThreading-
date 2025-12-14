package Practice6;

import java.util.concurrent.locks.ReadWriteLock;

public class ShareResource {
    boolean isAvailable = false;

    public void producer(ReadWriteLock lock){
        try{
            lock.readLock().lock();
            System.out.println("Read lock acquired by: "+ Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(10000);
        }catch(Exception e){
            //handle exception here
        }finally{
            lock.readLock().unlock();
            System.out.println("Read lock released by: "+ Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock lock){
        try{
            lock.writeLock().lock();
            System.out.println("Write lock is acquired by: "+ Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(10000);
        }catch(Exception e){
            //handle exception here
        }finally{
            lock.writeLock().unlock();
            System.out.println("Write loc is released by: "+ Thread.currentThread().getName());
        }
    }
    
}
