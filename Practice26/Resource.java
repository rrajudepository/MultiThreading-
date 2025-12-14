package Practice26;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    /*
     *3️⃣ Print A B C A B C… using 3 threads
     * form1 = 3k form number
     * form2 = 3k+1 form number
     * form3 = 3k+2 form number
     */
    private int counter;
    private ReentrantLock lock = new ReentrantLock();
    private Condition form1 = lock.newCondition();
    private Condition form2 = lock.newCondition();
    private Condition form3 = lock.newCondition();

    public Resource(){
        counter = 0;
    }
    //print 3k form number
    public void printFirst(){
        try{
            lock.lock();
            while(counter<100){
                while(counter%3!=0){
                  form1.await();
                }
                if(counter>=100) break;
                //System.out.println("A Printed by thread: "+ Thread.currentThread().getName());
                System.out.print("A");
                counter++;
                form2.signal();
            }
            form2.signal();
            form3.signal();
        }catch(Exception e){
            //handle exception here
        }finally{
            lock.unlock();
        }
    }

    //print 3k+1 form number
    public void printSecond(){
        try{
            lock.lock();
            while(counter<100){
                 while(counter%3 != 1){
                    form2.await();
                 }
                 if(counter>100) break;
                // System.out.println("B Printed by thread: "+ Thread.currentThread().getName());
                System.out.print("B"); 
                counter++;
                 form3.signal();
            }
            form1.signal();
            form3.signal();
        }catch(Exception e){
            //handle exception here
        }finally{
            lock.unlock();
        }

    }

    //print 3k+2 form number
    public void printThird(){
        try{
            lock.lock();
            while(counter<100){
                while(counter % 3 != 2) {
                    form3.await();
                }
                if(counter>=100) break;
                //System.out.println("C Printed by thread: "+ Thread.currentThread().getName());
                System.out.print("C");
                counter++;
                form1.signal();
            }
            form1.signal();
            form2.signal();
        }catch(Exception e){
            //handle exception here
        }finally{
            lock.unlock();
        }
    }

}
