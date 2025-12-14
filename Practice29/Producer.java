package Practice29;

public class Producer implements Runnable {
    ShareResource shareResource;

    public Producer(ShareResource shareResource){
        this.shareResource = shareResource;
    }



    @Override
    public void run(){
        System.out.println("Name of the producer thread is "+ Thread.currentThread().getName());
        int value = 1;
        while(value<20){
            shareResource.produceItem(value);
            value++;
        }
    }
}
