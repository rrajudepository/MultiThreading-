package Practice23;

public class EvenPrint implements Runnable{
    PrintNumber source;
    public EvenPrint(PrintNumber source){
        this.source = source;
    }

    @Override
    public void run(){
        System.out.println("Thread name which print even numbers: "+ Thread.currentThread().getName());
        source.evenNumber();
    }


}
