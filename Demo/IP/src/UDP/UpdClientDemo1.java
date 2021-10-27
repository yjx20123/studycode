package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//客户端
public class UpdClientDemo1 {
    public static void main(String[] args) throws Exception{
        //1、建立Socket
        DatagramSocket socket   = new DatagramSocket();

        //2、建个包
        String msg="你好啊，服务器";

        //3、发送包
        InetAddress localhost = InetAddress.getByName("localhost");
        int port=9090;
        //数据，数据的长度起始，要发送给谁
        DatagramPacket packet = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localhost,port);
        socket.send(packet);
        socket.close();

    }
}
