package Lab_2;

import java.io.IOException;

public class FileClientMain {
    public static void main(String[] args) throws IOException {
        FileClient fc = new FileClient("localhost", 5501, "Lab_2\\pliki");
        fc.connect();
        fc.sendFileToServer();
        fc.disconnect();
    }
}
