package Practice2;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nProducer Consumer Problem Sotution using wait() and notify()\n");
        System.out.println("Starting main thread: "+ Thread.currentThread().getName());
        SharedRResource sharedRResource = new SharedRResource();

        Runnable producer = new Producer(sharedRResource);
        Runnable consumer = new Consumer(sharedRResource);

        Thread produceThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        //consumerThread.setDaemon(true);

        produceThread.start();
        consumerThread.start();
        /* try {
            produceThread.join(); // Main thread will finish after produceThread finishes not necessarily after consumerThread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            */

        System.out.println("\n\nEnding main thread: "+ Thread.currentThread().getName());
        System.out.println("\n\n");
    }
}
