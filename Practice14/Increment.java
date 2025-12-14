package Practice14;

public class Increment {
    int counter =0;

    public synchronized void increse(){
        counter++;
    }

    public int getValue(){
        return counter;
    }
}
