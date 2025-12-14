package Practise1;

public class Main3 {
    public static void main(String[] args) {
        Counting counting = new Counting();

        Runnable threading = () ->{
            System.out.println("Current thread is running: " + Thread.currentThread().getName());
            counting.increment();
        };

        Thread thread1 = new Thread(threading);
        Thread thread2 = new Thread(threading);
        thread1.start();
        thread2.start();

        int count = counting.getCount();
        System.out.println("Final count is: " + count);
    }
}
