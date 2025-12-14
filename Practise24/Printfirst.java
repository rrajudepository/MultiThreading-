package Practise24;

public class Printfirst implements Runnable{
    Resource resource;
    public Printfirst(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run(){
        System.out.println("Thread name which print 3k form number: "+ Thread.currentThread().getName());
        resource.printFirst();
    }

}
