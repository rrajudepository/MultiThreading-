package Practise24;

public class PrintThird implements Runnable{
    Resource resource;
    public PrintThird(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run(){
        System.out.println("Thread name which run 3k+2 number: "+Thread.currentThread().getName());
        resource.printThird();
    }
}
