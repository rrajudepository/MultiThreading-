package Practice25;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    /*
     * 2️⃣ Print numbers from 1 to N with 3 threads in sequence
       Thread T1 prints numbers divisible by 3,
       T2 prints numbers divisible by 5,
       T3 prints all others (or in strict sequence T1→T2→T3→T1…)
     */
    private int counter;
    private ReentrantLock lock = new ReentrantLock();
    private Condition form1 = lock.newCondition();
    private Condition form2 = lock.newCondition();
    private Condition form3 = lock.newCondition();


    public Resource(){
        counter = 1;
    }

    public void printFirst(){
        try{
            lock.lock();
            while(counter<=100){
                while(counter%3!=0){
                    form1.await();
                }
                if(counter>100){
                    form2.signal();
                    form3.signal();
                    form1.signal();
                    break;
                }
                System.out.println(counter + " printed by thread: "+ Thread.currentThread().getName());
                counter++;
                if(counter%5==0) form2.signal();
                else form3.signal();

            }
        }catch(Exception e){
            //handle exception here
        }finally{
            lock.unlock();
        }

    }

    public void printSecond(){
        try{
            lock.lock();
            while(counter<=100){
                while(counter%5!=0){
                    form2.await();
                }
                if(counter>100){
                    form1.signal();
                    form3.signal();
                    form2.signal();
                    break;
                }
                System.out.println(counter + " printed by thread: "+ Thread.currentThread().getName());
                counter++;
                if(counter%3==0) form1.signal();
                else form3.signal();

            }
        }catch(Exception e){
            //handle exception here
        }finally{
            lock.unlock();
        }

    }

    public void printThird(){
        try{
            lock.lock();
            while(counter<=100){
                while(counter%3==0 || counter%5 ==0){
                    form3.await();
                }
                if(counter>100){
                    form2.signal();
                    form1.signal();
                    form3.signal();
                    break;
                }
                System.out.println(counter + " printed by thread: "+ Thread.currentThread().getName());
                counter++;
                if(counter%5 == 0) form2.signal();
                if(counter%3 == 0) form1.signal();

            }
        }catch(Exception e){
            //handle exception here
        }finally{
            lock.unlock();
        }

    }
}
