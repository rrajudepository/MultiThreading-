package Practice21;

public class ResourceShare {
    boolean isAvailable=false;

    public void produce(){
        try{
            System.out.println("Producer thread name: "+Thread.currentThread().getName());
            while(isAvailable){
                try{
                    System.out.println("Producer waiting for consumer to consume items");
                    wait();
                }catch(Exception e){

                }
            }
            isAvailable = true;
            System.out.println("Producer produce the item");
            notify();

        }catch(Exception e){

            }
        }

        public void consumer(){

            try{
                System.out.println("Consumer thread name: "+ Thread.currentThread().getName());
                while(!isAvailable){
                    try{
                        System.out.println("Consumer is waiting for producer to produce items");
                        wait();
                    }catch(Exception e){
                        
                    }
                }
                isAvailable = false;
                System.out.println("Consumer consume the item");
                notify();
            }catch(Exception e){
            
            }
        }
    }

