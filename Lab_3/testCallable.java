package Lab_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class testCallable {
    public void startThread(int numberThread) {
        ExecutorService service = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) service;

        int number = 0;
        while (number <= 200) {
            if (threadPool.getActiveCount() <= 0) {
                unicNumberRand un = new unicNumberRand(number);
                try {
                    service.submit(un);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                number++;
            }
        }
    }
}
