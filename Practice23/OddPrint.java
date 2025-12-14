package Practice23;

public class OddPrint implements Runnable{
    PrintNumber source;
    
    public OddPrint(PrintNumber source){
        this.source = source;
    }

    @Override
    public void run(){
        System.out.println("Thread name which print odd number: "+ Thread.currentThread().getName());
        source.oddNumber();
    }


}
