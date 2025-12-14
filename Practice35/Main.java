package Practice35;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread started: "+ Thread.currentThread().getName());

        Increment increment = new Increment();
        Runnable runObj1 = new First(increment);
        Runnable runObj2 = new Second(increment);

        Thread th1 = new Thread(runObj1);
        Thread th2 = new Thread(runObj2);
        th1.start();
        th2.start();
        try{
            th1.join();
            th2.join();
        }catch(Exception e){
            //handle exception here
        }

        System.out.println("Increment value is: "+ increment.getCount());
        System.out.println("Main thread ended: "+ Thread.currentThread().getName());

    }
}
