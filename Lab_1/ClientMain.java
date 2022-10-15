package Lab_1;

public class ClientMain {

    public static void main(String[] args) {
        Client c = new Client("localhost", 5501);
        c.connect();
        c.sendMessage();
        c.disconnect();
    }
}
