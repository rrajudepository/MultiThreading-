package Practise1;

public class Threading implements Runnable{

    public void run(){
        System.out.println("Current thread is running: " + Thread.currentThread().getName());
        System.out.println("Thread ID: "+ Thread.currentThread().getClass());

        // Printing multiple of 4
        for(int i=1; i<=10; i++){
            System.out.print(i*4+ ", ");
        }
        System.out.println();
    }
    
}
