package Practice8;

import java.util.concurrent.Semaphore;

public class SharedResource {
    boolean isAvailable = false;
    Semaphore lock = new Semaphore(2);

    public void producer(){
        try{
            lock.acquire();
            System.out.println("Semaphore Lock is acquired by producer thread: "+ Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(5000);
        }catch(Exception e){
            //handle exception here
        }finally{
            lock.release();;
            System.out.println("Lock released by producer thread: "+Thread.currentThread().getName());
        }
    }
}
