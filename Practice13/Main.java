package Practice13;

public class Main {
    public static void main(String[] args) {
        Increament inc = new Increament();

        Runnable task1 = ()->{
            for(int i=0;i<200;i++){
                inc.increment();
            }
        };

        Runnable task2 = ()->{
            for(int i=0;i<200;i++){
                inc.increment();
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            //Handle exception here
        }

        System.out.println("Increment value is: "+inc.get());
    }
}
