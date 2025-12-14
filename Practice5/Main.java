package Practice5;

public class Main {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        Thread th1 = new Thread(()->{
            shareResource.producer();
        });

        Thread th2 = new Thread(()->{
            shareResource.producer();
        });

        th1.start();
        th2.start();
    }
}
