package Practice16;

public class ShareResource {
    int counter;
    public ShareResource(){
        counter =0;
    }
    public synchronized void produce(){
        System.out.println("Thread: "+ Thread.currentThread().getName()+" incresing the value = "+counter);
        counter++;
    }

    public int getCounter(){
        return counter;
    }
}
