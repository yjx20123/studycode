package UDP.UDP聊天;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSenderDemo {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);
        //准备数据，控制台读取system.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = reader.readLine();
        byte[] datas = data.getBytes();
        DatagramPacket packet = new DatagramPacket(datas,0, data.length(), new InetSocketAddress("localhost", 6666));
        socket.send(packet);
        socket.close();
    }
}
