package Practice25;

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource();

        Runnable runObj1 = ()->{
           System.out.println("Thread name which print 3k form number: "+ Thread.currentThread().getName());
           resource.printFirst();
        };

        Runnable runObj2 = ()->{
           System.out.println("Thread name which print 3k+1 form number: "+ Thread.currentThread().getName());
           resource.printSecond();
        };

        Runnable runObj3 = ()->{
           System.out.println("Thread name which print 3k+2 form number: "+ Thread.currentThread().getName());
           resource.printThird();
        };

        Thread th1 = new Thread(runObj1);
        Thread th2 = new Thread(runObj2);
        Thread th3 = new Thread(runObj3);
        th1.start();
        th2.start();
        th3.start();
    }
}
