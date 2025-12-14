package Practice2;

public class Producer implements Runnable {

    private SharedRResource sharedRResource;

    public Producer(SharedRResource sharedRResource){
        this.sharedRResource = sharedRResource;
    }

    @Override
    public void run(){
        for(int i=0;i<2;i++){
            System.out.println("Producer Thread: " + Thread.currentThread().getName());
            sharedRResource.produceItem();
        }
    }
    
}
