package Practice29;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nMain thread "+ Thread.currentThread().getName()+ " is started.\n\n");
        ShareResource shareResource = new ShareResource(5);
        Runnable producer = new Producer(shareResource);
        Runnable consumer = new Consumer(shareResource);

        Thread th1 = new Thread(producer);
        Thread th2 = new Thread(consumer);
        th1.start();
        th2.start();

        try{
            th1.join();
            th2.join();
        }catch(Exception e){
            //handle exception here
        }


        System.out.println("\n\nMain thread "+ Thread.currentThread().getName()+ " end");
    }
}
