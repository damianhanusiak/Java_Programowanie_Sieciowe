package Lab_3;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class packageMain {
    public static int[] tabInt;

    public static void main(String[] args) {
        tabInt = new int[200];
        for (int i = 0; i < 200; i++) {
            tabInt[i] = -1;
        }

        packageZIP pz = new packageZIP();
        File[] files = Paths.get("Lab_3\\pliki").toFile().listFiles();

        pz.packageArchieve(files, "Lab_3\\pliki\\plik.zip");
        pz.unpackageArchive(Path.of("Lab_3\\pliki_out"), "Lab_3\\pliki\\plik.zip");

        // Lab 4 - obsługa wielowątkowości
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 40; i++) {
                    System.out.println("Wartość " + i);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // th.start();
        // try {
        // th.join();
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // TestRunnable tr = new TestRunnable();
        // tr.startThread(10);
        testCallable tc = new testCallable();
        tc.startThread(10);

        System.out.println("Zakończenie wątka głównego");
    }
}
