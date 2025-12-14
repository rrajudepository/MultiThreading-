package Practice22;

public class Main {
    public static void main(String[] args) {
        PrintNumber source = new PrintNumber();
        Runnable evenprint1 = new Evenprint(source);
        Runnable oddPrint1 = new OddPrint(source);
        Runnable evenprint2 = new Evenprint(source);
        Runnable oddPrint2 = new OddPrint(source);

        Thread t1 = new Thread(evenprint1);
        Thread t2 = new Thread(oddPrint1);
        Thread t3 = new Thread(evenprint2);
        Thread t4 = new Thread(oddPrint2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}
