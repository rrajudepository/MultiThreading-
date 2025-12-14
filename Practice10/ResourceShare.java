package Practice10;

import java.util.concurrent.locks.ReadWriteLock;

public class ResourceShare {
    int resourceValue = 0;

    public void produceResource(ReadWriteLock lock){
        try{
            System.out.println("Producing resource by: "+ Thread.currentThread().getName());
            resourceValue++;
            System.out.println("Resource value after production: "+ resourceValue);
            System.out.println("Trying to acquire read lock by: "+ Thread.currentThread().getName());
            lock.readLock().lock();

        }catch(Exception e){
            //handle exception here
        }finally{
            System.out.println("Read lock released by: "+ Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }

    public void consumerResource(ReadWriteLock lock){
        while(resourceValue ==  0){
            //waiting for resource to be available
            try{
                wait();
            }catch(Exception e){
                //handle exception here
            }finally{
                System.out.println("Consumer thread waiting for the resource: "+ Thread.currentThread().getName());
            }
        }

        if(resourceValue > 0){
            try{
                System.out.println("Consuming resource by: "+ Thread.currentThread().getName());
                lock.writeLock().lock();
                resourceValue--;
                System.out.println("Resource value after consumption: "+ resourceValue);
            }catch(Exception e){
                //handle exception here
            }finally{
                System.out.println("Write lock released by: "+ Thread.currentThread().getName());
                lock.writeLock().unlock();
            }
        }
    }
}
