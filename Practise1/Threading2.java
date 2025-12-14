package Practise1;

public class Threading2 implements Runnable{
    Counting2 count = new Counting2();
    public void run(){
        System.out.println("Current thread is running: "+ Thread.currentThread().getName());
        count.printNum();
    }
}
