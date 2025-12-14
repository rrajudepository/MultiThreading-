package Practice7;

import java.util.concurrent.locks.StampedLock;

public class ShareResource {
    int a = 10;
    StampedLock lock = new StampedLock();
    public void produce(){
        long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("Taken optimistic lock by: "+ Thread.currentThread().getName());
            a=11;
            Thread.sleep(5000);
            if(lock.validate(stamp)){
                System.out.println("Updated value of a successfully by: "+ Thread.currentThread().getName());
                System.out.println("Value of a: "+ a);

            }else{
                System.out.println("rollback of work by: "+ Thread.currentThread().getName());
                a=10;
            }
        }catch(Exception e){
            //handle exception here
        }
    }
    public void consumer(){
        long stamp = lock.writeLock();
        System.out.println("Write lock acquired by: "+ Thread.currentThread().getName());
        try{
            System.out.println("performing work");
            a=9;
        }catch(Exception e){
            //handle exception here
        }finally{
            lock.unlockWrite(stamp);
            System.out.println("Write lock released by: "+ Thread.currentThread().getName());
        }
    }
}
