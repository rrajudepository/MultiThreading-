package Practice23;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumber {
    private int counter;
    private ReentrantLock lock = new ReentrantLock();
    private Condition evenTurn = lock.newCondition();
    private Condition oddTurn = lock.newCondition();
    public PrintNumber(){
        counter = 0;
    }

    public void evenNumber(){
        try{
            lock.lock();
            System.out.println("Thread name in method evenNumber: "+ Thread.currentThread().getName());
            while(counter<100){
                while(counter%2!=0){
                    evenTurn.await();
                }
                if(counter>100){
                    oddTurn.signalAll();
                    break;
                }
                System.out.println(counter + " printed by thread: "+ Thread.currentThread().getName());
                counter++;
                oddTurn.signalAll();
            }
        }catch(Exception e){
            //
        }finally{
            lock.unlock();
        }
    }
    
    public void oddNumber(){
        try{
            lock.lock();
            System.out.println("Thread name in method oddNumber: "+ Thread.currentThread().getName());
            while(counter<100){
                while(counter%2 == 0){
                    oddTurn.await();
                }
                if(counter>100){
                    evenTurn.signalAll();
                    break;
                }
                System.out.println(counter+ " printed by thread: "+ Thread.currentThread().getName());
                counter++;
                evenTurn.signalAll();
            }
        }catch(Exception e){
            //
        }finally{
            lock.unlock();
        }

    }
    
}
