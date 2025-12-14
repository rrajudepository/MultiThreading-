package Practice29;

public class Consumer implements Runnable {
    ShareResource shareResource;

    public Consumer(ShareResource shareResource){
        this.shareResource = shareResource;
    }

    @Override
    public void run(){
        System.out.println("Name of the consumer thread is "+ Thread.currentThread().getName());
        int value =1;
        while(value<20){
            shareResource.consumeItem();
            value++;
        }
    }


}
