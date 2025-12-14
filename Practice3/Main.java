package Practice3;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n Main Thread started: "+ Thread.currentThread().getName());
        Increament increament = new Increament();
        Runnable task1 =()->{
            System.out.println("Task 1 executed by: "+Thread.currentThread().getName());
            for(int i=0;i<200;i++){
                increament.increment();
            }
        };
        Runnable task2 =()->{
            System.out.println("Task 2 executed by: "+Thread.currentThread().getName());
            for(int i=0;i<200;i++){
                increament.increment();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            e.addSuppressed(e);
        }
        increament.printCount();

        System.out.println(" Main thread ended: "+ Thread.currentThread().getName());
    }
}
