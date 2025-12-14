package Practice22;

public class OddPrint implements Runnable{
    PrintNumber source;
    public OddPrint(PrintNumber source){
        this.source = source;
    }

    @Override
    public void run(){
        System.out.println("Thread name which print odd numbers: "+Thread.currentThread().getName());
        source.oddPrint();
    }
}
