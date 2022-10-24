package Kolokwium_I;

public class KolokwiumMain {
    public static void main(String[] args) {
        KolokwiumClient c = new KolokwiumClient("example.com", 4567);
        c.connect();
        c.disconnect();
    }
}
