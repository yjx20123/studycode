package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServerDemo {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer = new byte[1024];
        DatagramPacket datagramSocket = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(datagramSocket);//阻塞接收
        socket.close();

    }
}
