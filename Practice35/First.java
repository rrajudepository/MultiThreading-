package Practice35;

public class First implements Runnable{
    private Increment increment;

    public First(Increment increment){
        this.increment = increment;
    }

    @Override
    public void run(){
        System.out.println("Thread name: "+ Thread.currentThread().getName());
        for(int i=0;i<200000;i++){
            increment.increment();
        }
    }
}
