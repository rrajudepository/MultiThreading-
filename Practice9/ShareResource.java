package Practice9;

import java.util.concurrent.locks.ReentrantLock;

public class ShareResource {
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();

    public void producer(){
        try{
            lock.lock();
            System.out.println("Lock acquaired by producer thread: "+ Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(10000);

        }catch(Exception e){
            //handle exception here
        }finally{
            System.out.println(("Lock released by: "+ Thread.currentThread().getName()));
            lock.unlock();
        }
    }

    public void consumer(){
        while(!isAvailable){
            //waiting for resource to be available
            try{
                System.out.println("Consumer thread waiting for the resource: "+ Thread.currentThread().getName());
                wait();
            }catch(Exception e){
                //handle exception here
            }
        }
        try{
            lock.lock();

            System.out.println("Lock acquaired by consumer thread: "+ Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(10000);
        }catch(Exception e){
            //handle exception here
        }finally{
            System.out.println("Lock released by: "+ Thread.currentThread().getName());
        }
    }
}
