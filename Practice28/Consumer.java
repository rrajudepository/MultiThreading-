package Practice28;

public class Consumer implements Runnable{
    ShareResource shareResource;
    public Consumer(ShareResource shareResource){
        this.shareResource = shareResource;
    }

    @Override
    public void run(){
        System.out.println("Name of consumer thread is: "+ Thread.currentThread().getName());
        int value = 1;
        try{
            while(value<20){
            shareResource.consumer();
            //Thread.sleep(500);
            value++;
            }
        }catch(Exception e){

        }
    }
}
