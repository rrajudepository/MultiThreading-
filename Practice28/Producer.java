package Practice28;

public class Producer implements Runnable{
    ShareResource shareResource;
    int value = 1;

    public Producer(ShareResource shareResource){
        this.shareResource = shareResource;
    }

    @Override
    public void run(){
        System.out.println("Name of produder thread is: "+ Thread.currentThread().getName());
        try{
            while(value<20){
                shareResource.producer(value);
               // Thread.sleep( 2000);
                value++;
            }
        }catch(Exception e){

        }
    }


}
