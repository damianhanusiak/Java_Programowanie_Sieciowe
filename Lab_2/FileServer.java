package Lab_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class FileServer {

    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private String defaultLocation;

    public FileServer(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            this.defaultLocation = "Lab_2\\pliki_server\\";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverConnection() {
        while (true) {
            System.out.println("Oczekuje na klienta");
            try {
                this.socket = serverSocket.accept();
                this.dataInputStream = new DataInputStream(socket.getInputStream());
                this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("Połączenie nawiązane");
                getFileFromClient();
                clientClose();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendFileToClient() throws IOException {
        File file = new File(defaultLocation + "");
        System.out.println("Przygotowania do wysłania pliku");
        byte[] fileNameBytes = file.getName().getBytes(StandardCharsets.UTF_8);
        int fileNameLength = file.getName().length();
        try {
            FileInputStream fileIn = new FileInputStream(file);
            byte[] fileContentBytes = new byte[(int) file.length()];
            fileIn.read(fileContentBytes);
            fileIn.close();
            // wysyłamy nazwę pliku
            dataOutputStream.writeInt(fileNameLength);
            dataOutputStream.write(fileNameBytes, 0, fileNameLength);
            // wysyłanie zawartości
            dataOutputStream.writeLong(file.length());
            dataOutputStream.write(fileContentBytes);
            dataOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    };

    public void getFileFromClient() {
        try {
            int fileNameLength = dataInputStream.readInt();
            if (fileNameLength > 0) {
                byte[] fileNameBytes = new byte[fileNameLength];
                dataInputStream.readFully(fileNameBytes);
                String fileName = new String(fileNameBytes, 0, fileNameLength, StandardCharsets.UTF_8);
                long fileContentLength = dataInputStream.readLong();
                // Sprawdzam czy plik ma jakąś zawartość
                if (fileContentLength > 0) {
                    byte[] fileContentBytes = new byte[(int) fileContentLength];
                    dataInputStream.readFully(fileContentBytes);
                    FileOutputStream fileOut = new FileOutputStream(new File(defaultLocation + fileName));
                    fileOut.write(fileContentBytes);
                    fileOut.flush();
                    fileOut.close();
                    System.out.println("Zapisano nowy plik o nazwie " + fileName);

                } else {
                    System.out.println("Utworzę pusty plik!");
                }
            } else {
                System.out.println("Nie przekazano pliku!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clientClose() {
        if (!this.socket.isClosed()) {
            try {
                this.dataInputStream.close();
                this.dataOutputStream.close();
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
