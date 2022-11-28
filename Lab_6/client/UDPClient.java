import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class UDPClient implements Runnable {

    DatagramSocket socket;
    DatagramPacket pack;
    byte[] buff;

    public UDPClient() {
        buff = new byte[512];
        try {
            socket = new DatagramSocket();
            // pack = new DatagramPacket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public String sendMessage(String msg) {
        try {
            buff = msg.getBytes(StandardCharsets.UTF_8);
            InetAddress address = InetAddress.getByName("localhost");
            pack = new DatagramPacket(buff, buff.length, address, 5501);
            socket.send(pack);
            byte[] byteIn = new byte[512];
            DatagramPacket packIn = new DatagramPacket(byteIn, byteIn.length);
            socket.receive(packIn);
            // String recr = new String(pack.getData(), 0, pack.getLength());
            String recr = new String(packIn.getData(), StandardCharsets.UTF_8);
            System.out.println("Wiadomość " + recr);

            return recr;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void close() {
        socket.close();
    }

    @Override
    public void run() {
        
    }
}