package Lab_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    // połączenia z klientem
    private ServerSocket serverSocket;
    // konkretne połączenie z klientem
    private Socket socket;

    public Server(int port) {
        try {
            // ustawiam port na który chce nasłuchiwać
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverConnection() {
        while (true) {
            System.out.println("Oczekuje na klienta");
            try {
                this.socket = serverSocket.accept();
                System.out.println("Połączenie nawiązane");
                serverMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void serverMessage() {
        try {
            // wysyłanie wiadomości
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            // odbieranie wiadomości
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream(), StandardCharsets.UTF_8));

            String tekst;
            writer.println("Witaj przedstaw się: ");
            while (true) {
                tekst = reader.readLine();
                if (tekst.equals("e")) {
                    System.out.println("klient kończy połączenie");
                    writer.close();
                    reader.close();
                    break;
                }
                System.out.println(tekst);
                writer.println("Re: " + tekst);
            }
            clientClose();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clientClose() {
        if (!this.socket.isClosed()) {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}