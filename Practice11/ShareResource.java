package Practice11;

import java.util.concurrent.locks.StampedLock;

public class ShareResource {
    boolean isAvailable = false;
    StampedLock lock = new StampedLock();

    public void producer(){
        long stamp = lock.readLock();

        try{
            System.out.println("Producing item by thread: "+ Thread.currentThread().getName());
            System.out.println("Read lock is acquired by thread: "+ Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(5000);
        }catch(Exception e){
            //handler exception here
        }finally{
            System.out.println("Lock is released by thread: "+ Thread.currentThread().getName());
            lock.unlock(stamp);
        }
    }

    public void consumer(){
        long stamp = lock.writeLock();
        try{
            System.out.println("Item consumed by thread: "+ Thread.currentThread().getName());
            System.out.println("write Lock acquired by thread: "+ Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(5000);
        }catch(Exception e){
            //handle exception here
        }finally{
            System.out.println("Lock is released by thread: "+ Thread.currentThread().getName());
            lock.unlock(stamp);
        }
    }
}

