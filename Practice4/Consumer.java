package Practice4;

public class Consumer implements Runnable {
    ResourceBuffer resourceBuffer;

    public Consumer(ResourceBuffer resourceBuffer){
        this.resourceBuffer = resourceBuffer;
    }
    
    @Override
    public void run(){
        System.out.println("Consumer Thread started: "+ Thread.currentThread().getName());
        for(int i=0;i<5;i++){
            resourceBuffer.consumer();
        }
    }
}
