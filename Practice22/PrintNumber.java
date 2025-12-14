package Practice22;

public class PrintNumber {
    int counter;
    public PrintNumber(){
        counter =0;
    }
    
    public synchronized void oddPrint(){
        System.out.println("Name of thread entering into oddPrint method: "+Thread.currentThread().getName());
        while(counter<=999){
            try{
                while(counter%2==0){
                    wait();
                }
                System.out.print(counter+" ");
                counter++;
                notifyAll();
            }catch(Exception e){
                //handle exception here
            }
        }
    }

    public synchronized void evenPrint(){
        System.out.println("Name of thread entering into evenPrint method: "+Thread.currentThread().getName());
        while(counter<=999){
            try{
                while(counter%2!=0){
                    wait();
                }
                System.out.println(counter+" : "+Thread.currentThread().getName());
                counter++;
                notifyAll();
            }catch(Exception e){
                //handle exception here
            }
        }
    }
}
