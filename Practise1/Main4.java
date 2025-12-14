package Practise1;

public class Main4 {
    public static void main(String[] args) {
        Runnable threading = new Threading2();
        Thread thread1 = new Thread(threading);
        Thread thread2 = new Thread(threading);
        thread1.start();
        thread2.start();
    }
}
