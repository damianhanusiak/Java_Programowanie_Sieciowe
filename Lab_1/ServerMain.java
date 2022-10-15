package Lab_1;

public class ServerMain {

    public static void main(String[] args) {
        Server s = new Server(5501);
        s.serverConnection();
    }
}
