package Practice34;

public class CountNumber {
    private int counter;

    public CountNumber(){
        counter = 0;
    }

    public synchronized void increament(){
        counter++;
    }

    public int getCounter(){
        return counter;
    }
}
