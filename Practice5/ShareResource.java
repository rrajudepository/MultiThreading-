package Practice5;

import java.util.concurrent.locks.ReentrantLock;

public class ShareResource{
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();

    public void producer(){
        try{
            lock.lock();
            System.out.println("Lock acquaired by producer: "+ Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        }catch(Exception e){
            //handle exception here
        }finally{
            lock.unlock();
            System.out.println("Lock released by producer: "+ Thread.currentThread().getName());
        }
    }
    
}
