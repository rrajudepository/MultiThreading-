package Practice34;

public class Consumer implements Runnable{
    ShareResource shareResource;

    public Consumer(ShareResource shareResource){
        this.shareResource = shareResource;
    }

    @Override
    public void run(){
        System.out.println("Consumer Thread name: "+ Thread.curr);
    }    
}
