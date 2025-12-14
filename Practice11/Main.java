package Practice11;

public class Main {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();

        Runnable produce = ()->{
            resource.producer();
        };
        Runnable consumer = ()->{
            resource.consumer();
        };

        Thread th1 = new Thread(produce);
        Thread th2 = new Thread(consumer);

        th1.start();
        th2.start();


    }
}
