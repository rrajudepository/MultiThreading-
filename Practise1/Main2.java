package Practise1;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Main2 thread us running: "+Thread.currentThread().getName());

        Runnable threading = () ->{
            System.out.println("Current thread is running: "+ Thread.currentThread().getName());
            System.out.println("Thread Priority: "+Thread.currentThread().getPriority());

            //Printing multiple of 5
            for(int i=1;i<=10;i++){
                System.out.print(i*5 + ", ");
            }
            System.out.println("__________________");
        };
        Thread thread1 = new Thread(threading);
        Thread thread2 = new Thread(threading);
        thread1.start();
        thread2.start();
        System.out.println("End of main2 thread: "+Thread.currentThread().getName());
    }
}
