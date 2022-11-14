package Lab_4.TikTak;

public class TikTakMain {
    public static int number;

    public static void main(String[] args) {
        TikTak tiktak = new TikTak();
        StartTikTak t1 = new StartTikTak("tik", tiktak);
        StartTikTak t2 = new StartTikTak("tak", tiktak);
        StartTikTak t3 = new StartTikTak("tok", tiktak);
        number = 0;

        try {
            t1.th.join();
            t2.th.join();
            t3.th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Wątek główny kończy pracę!");
    }
}
