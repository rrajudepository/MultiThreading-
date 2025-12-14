package Practice9;

public class Main {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();

        Thread t1 = new Thread(()->{
            resource.producer();
        });

        Thread t2 = new Thread(()->{
            resource.producer();
        });

        Thread t3 = new Thread(()->{
            resource.consumer();
        });

        t3.start();

        t1.start();
        t2.start();
    }
}
