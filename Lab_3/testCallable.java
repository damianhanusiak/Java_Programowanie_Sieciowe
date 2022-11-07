package Lab_3;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class testCallable {
    public void startThread(int numberThread) {
        ExecutorService service = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) service;
        ArrayList<Future<Integer>> templist = new ArrayList<>();

        int number = 0;
        while (number <= 200) {
            if (threadPool.getActiveCount() <= numberThread) {
                try {
                    unicNumberRand un = new unicNumberRand(number);
                    templist.add(service.submit(un));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                number++;
            }
        }

        for (int i = 0; i < 200; i++) {
            Future<Integer> f = templist.get(i);
            try {
                int numbers = f.get(2, TimeUnit.SECONDS);
                System.out.println("Wątek zapisał do " + numbers + " elementu tablicy");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }

        showTable();
    }

    public void showTable() {
        for (int i = 0; i < 200; i++) {
            if ((i / 10) == 0) {
                System.out.println(packageMain.tabInt[i]);
                // System.out.println();
            } else {
                System.out.println(packageMain.tabInt[i] + " ");
            }
        }
    }
}
