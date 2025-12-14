package Practice2;

public class SharedRResource {
    boolean itemAvailable = false;
    int consumedItemCount = 0;
    int producedItemCount = 0;

    public void produceItem(){
        synchronized(this){
            try {
                while(itemAvailable){
                    System.out.println("Item is already available, producer is waiting....");
                    wait();
                }
                    itemAvailable = true;
                    producedItemCount++;
                    System.out.println("Number of items produce till now: "+ producedItemCount);
                    System.out.println("Item produced by "+ Thread.currentThread().getName());
                    System.out.println("Item is available for consumtion and notifying the consumer\n\n");
                    notifyAll();
                
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void consumeItem(){
        synchronized(this){
            try {
                while(!itemAvailable){
                    System.out.println("Item is not available for consumption, consumer is waiting....");
                    wait();
                }
                    itemAvailable = false;
                    consumedItemCount++;
                    System.out.println("Number of items consumed till now: "+ consumedItemCount);
                    System.out.println("Item consumed by "+ Thread.currentThread().getName());
                    System.out.println("Item is consumed and notifying the producer\n\n");
                    notifyAll();
                
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
