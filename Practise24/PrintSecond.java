package Practise24;

public class PrintSecond implements Runnable{
    Resource resource;

    public PrintSecond(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run(){
        System.out.println("Thread name which print 3k+1 number: "+Thread.currentThread().getName());
        resource.printSecond();
    }
}
