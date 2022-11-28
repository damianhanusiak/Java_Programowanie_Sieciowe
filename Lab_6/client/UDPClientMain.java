public class UDPClientMain {
    public static void main(String[] args) {

        UDPClient udpClient = new UDPClient();

        for (int i = 0; i < 15; i++) {
            udpClient.sendMessage(i + "");
        }

        udpClient.close();
    }
}
