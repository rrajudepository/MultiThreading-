package Practise30;


public class Main {
    public static void main(String[] args) {

        Resource resource = new Resource();
    Runnable produce = ()->{
        System.out.println("Name of producer is "+ Thread.currentThread().getName());
        int value = 1;
        while(value<5){
            resource.produce(value);
            value++;
        }
    };

    Thread th1 = new Thread(produce);
    Thread th2 = new Thread(produce);
    Thread th3 = new Thread(produce);
    Thread th4 = new Thread(produce);
    
    th1.start();
    th2.start();
    th3.start();
    th4.start();
    
    }
    

}
