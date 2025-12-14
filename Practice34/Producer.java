package Practice34;

public class Producer implements Runnable{
    ShareResource shareResource;

    public Producer(ShareResource shareResource){
        this.shareResource = shareResource;
    }
    
    public void run(){
        System.out.println("Producer thread name: "+ Thread.currentThread().getName());
        for(int i=1;i<=5;i++){
            shareResource.produceItem(i);
        }
    }
    

}
