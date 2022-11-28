import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class UDPServer {

    private DatagramPacket packet;
    private DatagramSocket socket;
    private byte[] buff;

    public UDPServer() {
        try {
            socket = new DatagramSocket(5501);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void udpConnect() {
        buff = new byte[512];
        System.out.println("Oczekuje na połączenie.");
        while (true) {
            try {
                packet = new DatagramPacket(buff, buff.length);
                socket.receive(packet);
                String msg = new String(packet.getData(), StandardCharsets.UTF_8);
                System.out.println(msg);
                LocalDateTime time = LocalDateTime.now().plusSeconds(5);

                String msgOut = "Wiadomość zwrotna " + msg;
                packet.setData(msgOut.getBytes(StandardCharsets.UTF_8));
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
