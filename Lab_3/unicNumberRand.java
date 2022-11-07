package Lab_3;

import java.util.Random;
import java.util.concurrent.Callable;

public class unicNumberRand implements Callable<Integer> {
    private int nrThread;

    public unicNumberRand(int th) {
        this.nrThread = th;
    }

    @Override
    public Integer call() throws Exception {
        return randNumber();
    }

    private synchronized int randNumber() {
        Random rand = new Random();
        System.out.println("Rozpoczęcie pracy " + nrThread);
        int number = rand.nextInt(400);
        boolean find = false;

        while (true) {
            for (int i = 0; i < 200; i++) {
                if (packageMain.tabInt[i] == number) {
                    find = true;
                }
            }

            if (!find) {
                packageMain.tabInt[nrThread] = number;
                break;
            }
        }

        // System.out.println("Zakończenie pracy " + nrThread);

        return number;
    }
}
