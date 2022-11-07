package Lab_3;

public class TikTak {
    public synchronized void tik(boolean work) {
        if (!work) {
            notify();
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
}
