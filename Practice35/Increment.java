package Practice35;

import java.util.concurrent.locks.ReentrantLock;

public class Increment {
    int count;
    ReentrantLock lock = new ReentrantLock();
    
    public Increment(){
        count =0;
    }

    public  void increment(){
        try{
            lock.lock();
            count++;
            lock.unlock();
        }catch(Exception e){
            //handle exception here
        }
        //count++;
    }

    public int getCount(){
        return count;
    }
}
