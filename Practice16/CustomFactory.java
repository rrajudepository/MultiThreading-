package Practice16;

import java.util.concurrent.ThreadFactory;

public class CustomFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r){
        Thread th = new Thread(r);
        return th;
    }
    
}
