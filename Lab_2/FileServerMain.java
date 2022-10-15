package Lab_2;

public class FileServerMain {
    public static void main(String[] args) {
        FileServer fs = new FileServer(5501);
        fs.serverConnection();
    }
}
