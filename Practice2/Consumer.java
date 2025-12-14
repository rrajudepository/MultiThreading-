package Practice2;

public class Consumer implements Runnable {
    
    private SharedRResource sharedRResource;

    public Consumer(SharedRResource sharedRResource){
        this.sharedRResource = sharedRResource;
    }

    public void run(){
        for(int i=0;i<2;i++){
            System.out.println("Consumer Thread: "+ Thread.currentThread().getName());
            sharedRResource.consumeItem();
        }
    }
}
