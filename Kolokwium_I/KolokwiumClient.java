package Kolokwium_I;

import java.io.*;
import java.net.*;

public class KolokwiumClient {
    private Socket socket;
    private String host;
    private int port;

    public KolokwiumClient(String h, int p) {
        this.host = h;
        this.port = p;
    }

    public void connect() {
        try {
            InetAddress address = InetAddress.getByName(host);
            this.socket = new Socket(address, this.port);
            if (!socket.isClosed()) {
                System.out.println("Udało się nawiązać połączenie ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        if (!socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
