package Practice21;

public class Producer extends Thread{
    ResourceShare shareResource;

    public Producer(ResourceShare shareResource){
        this.shareResource = shareResource;
    }
    @Override
    public void run(){
      System.out.println("Producer thread is working: "+Thread.currentThread().getName());
      shareResource.produce();
    }
    
}
