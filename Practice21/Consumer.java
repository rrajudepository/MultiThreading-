package Practice21;


public class Consumer extends Thread {
    ResourceShare shareResource;
    public Consumer(ResourceShare shareResource){
        this.shareResource = shareResource;
    }

    @Override
    public void run(){
        System.out.println("Consumer thread is working: "+ Thread.currentThread().getName());
        shareResource.consumer();
    }
    
}
