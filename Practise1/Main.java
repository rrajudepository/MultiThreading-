package Practise1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread is running:" + Thread.currentThread().getName());
        Runnable threading = new Threading();
        Thread thread1 = new Thread(threading);
        Thread thread2 = new Thread(threading);
        //thread2.start();
        thread1.start();
        thread2.start();
        System.out.println("End of main thread: " + Thread.currentThread().getName());
    }
}
