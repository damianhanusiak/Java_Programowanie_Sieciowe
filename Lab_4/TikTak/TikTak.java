package Lab_4.TikTak;

public class TikTak {
    public synchronized void tik(boolean work) {
        if (!work) {
            // zwalnia wątki
            notify();
            System.out.println(String.format("Wątek %s kończy pracę.", Thread.currentThread().getName()));
            return;
        }
        System.out.println("Wyświetlam tik");
        notify();
        System.out.println("tik zwalania wątki");
        try {
            System.out.println("tik czeka");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void tak(boolean work) {
        if (!work) {
            notify();
            return;
        }
        System.out.println("Wyświetlam tak");
        notify();
        System.out.println("tak zwalania wątki");
        try {
            System.out.println("tak czeka");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void tok(boolean work) {
        if (!work) {
            notify();
            return;
        }
        System.out.println("Wyświetlam tok");
        notify();
        System.out.println("tok zwalania wątki");
        try {
            System.out.println("tok czeka");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
