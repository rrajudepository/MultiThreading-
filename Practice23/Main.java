package Practice23;

public class Main {
    public static void main(String[] args) {
        PrintNumber source = new PrintNumber();
        Runnable evenprint1 = new EvenPrint(source);
        Runnable evenprint2 = new EvenPrint(source);
        Runnable oddprint1 = new OddPrint(source);
        Runnable oddprint2 = new OddPrint(source);

        Thread th1 = new Thread(evenprint1);
        Thread th2 = new Thread(evenprint2);
        Thread th3 = new Thread(oddprint1);
        Thread th4 = new Thread(oddprint2);

        th1.start();
        th2.start();
        th3.start();
        th4.start();

    }
}
