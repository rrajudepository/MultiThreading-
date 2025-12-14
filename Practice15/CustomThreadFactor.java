package Practice15;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactor implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r){

        System.out.println("Creating new thread: ");
        Thread th = new Thread(r);
        return th;
    }
}
