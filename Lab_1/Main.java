package Lab_1;

public class Main {

    public static void main(String[] args) {
        // Server s = new Server(5501);
        // s.serverConnection();

        Client c = new Client("localhost", 5501);
        c.connect();
        c.sendMessage();
        c.disconnect();
    }
}
