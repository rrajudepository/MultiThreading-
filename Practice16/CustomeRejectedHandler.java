package Practice16;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.RejectedExecutionHandler;

public class CustomeRejectedHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor){
        //Logging
        System.out.println("Task denied: "+ r.toString());

    }
}
