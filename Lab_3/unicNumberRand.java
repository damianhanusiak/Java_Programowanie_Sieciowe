package Lab_3;

import java.util.Random;
import java.util.concurrent.Callable;

public class unicNumberRand implements Callable<Void> {
    private int nrThread;

    public unicNumberRand(int th) {
        this.nrThread = th;
    }

    @Override
    public Void call() throws Exception {
        Random rand = new Random();
        System.out.println("Rozpoczęcie pracy " + nrThread);

        int id = rand.nextInt(200);
        packageMain.tabInt[id] = nrThread;

        System.out.println("Zakończenie pracy " + nrThread);

        return null;
    }
}
