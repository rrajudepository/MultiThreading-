package Practice22;

public class Evenprint implements Runnable{
    PrintNumber source;
    public Evenprint(PrintNumber source){
        this.source = source;
    }

    @Override
    public void run(){
        System.out.println("Thread name which print even number: "+Thread.currentThread().getName());
        source.evenPrint();
    }


}
