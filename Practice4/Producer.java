package Practice4;

public class Producer implements Runnable{
    ResourceBuffer resourceBuffer;
    public Producer(ResourceBuffer resourceBuffer){
        this.resourceBuffer = resourceBuffer;
    }

    @Override
    public void run(){
        System.out.println("Producer Thread started: "+ Thread.currentThread().getName());
        for(int i=0;i<5;i++){
            resourceBuffer.produce(i);
        }
    }

    
}
