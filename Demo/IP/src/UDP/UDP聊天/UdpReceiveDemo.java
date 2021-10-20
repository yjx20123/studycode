package UDP.UDP聊天;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveDemo {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);
        while (true) {
            //准备接收包裹
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet);//阻塞式接收包裹
            //断开连接 bye
            byte[] data = packet.getData();
            String datas = new String(data, 0, data.length);
            System.out.println(datas);
            if (datas.equals("bye")) {
                break;
            }


        }
        socket.close();
    }
}
