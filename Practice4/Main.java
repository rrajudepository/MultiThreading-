package Practice4;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n Main Thread started: "+ Thread.currentThread().getName());

        ResourceBuffer resourceBuffer = new ResourceBuffer(5);
        Runnable producer = new Producer(resourceBuffer);
        Runnable consumer = new Consumer(resourceBuffer);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
        
        System.out.println("Main thread ended: "+ Thread.currentThread().getName());
    }
}
