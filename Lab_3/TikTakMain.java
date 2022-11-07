package Lab_3;

public class TikTakMain {
    public static void main(String[] args) {
        TikTak tiktak = new TikTak();

        Thread tik = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    tiktak.tik(true);
                }
            }
        });
        tik.start();

        Thread tak = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    tiktak.tak(true);
                }
            }
        });
        tak.start();
    }
}
