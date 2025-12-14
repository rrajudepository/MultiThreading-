package Practice12;

import java.util.concurrent.Semaphore;

public class ShareResource {
    boolean isAvailable = false;
    Semaphore lock = new Semaphore(2);
     public void producer(){
        try{
            lock.acquire();
            System.out.println("Lock acquired by: "+ Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(5000);
        }catch(Exception e){
            //handle exception here
            System.out.println("Waiting for producer to release the lock");
        }finally{
            System.out.println("Lock released by: "+ Thread.currentThread().getName());
            lock.release();
        }
     }
}
