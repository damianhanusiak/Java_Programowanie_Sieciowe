package Lab_4.TikTak;

public class StartTikTak implements Runnable {

    Thread th;
    TikTak ttObj;

    public StartTikTak(String name, TikTak tObj) {
        th = new Thread(this, name);
        ttObj = tObj;
        th.start();
    }

    // @Override
    // public void run() {
    // if (th.getName().compareTo("tik") == 0) {
    // for (int i = 0; i < 6; i++) {
    // ttObj.tik(true);
    // }
    // ttObj.tik(false);
    // } else {
    // for (int i = 0; i < 6; i++) {
    // ttObj.tak(true);
    // }
    // ttObj.tak(false);
    // }
    // }
    @Override
    public void run() {
        if (th.getName().compareTo("tik") == 0) {
            for (int i = 0; i < 6; i++) {
                ttObj.tik(true);
            }
            ttObj.tik(false);
        } else if (th.getName().compareTo("tak") == 0) {
            for (int i = 0; i < 6; i++) {
                ttObj.tak(true);
            }
            ttObj.tak(false);
        } else {
            for (int i = 0; i < 6; i++) {
                ttObj.tok(true);
            }
            ttObj.tok(false);
        }
    }
}