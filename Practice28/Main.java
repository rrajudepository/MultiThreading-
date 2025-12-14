package Practice28;

public class Main {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource(5);

        Runnable producer = new Producer(shareResource);
        //Runnable producer2 = new Producer(shareResource);
        Runnable consumer = new Consumer(shareResource);

        Thread th1 = new Thread(producer);
        Thread th2 = new Thread(consumer);
        //Thread th3 = new Thread(producer2);

        th1.start();
        th2.start();
      //  th3.start();
    }
}
