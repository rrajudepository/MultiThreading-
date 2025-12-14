package Practice14;

public class Main {
    public static void main(String[] args) {
        Increment resource = new Increment();

        Runnable task1 = ()->{
            System.out.println("Thread name: "+Thread.currentThread().getName());
            for(int i=0;i<200;i++){
                resource.increse();
            }
        };
        Thread t1 = new Thread(task1);

        Thread t2 = new Thread(()->{
            System.out.println("Thread name: "+ Thread.currentThread().getName());
            for(int i=0;i<200;i++){
                resource.increse();
            }
        });

        t2.start();
        t1.start();

        try{
            t1.join();
            //t2.join();
        }catch(Exception e){
            //handle exception here
        }
        System.out.println("Increase value is: "+ resource.getValue());
    }
}
