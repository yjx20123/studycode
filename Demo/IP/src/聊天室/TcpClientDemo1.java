package 聊天室;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientDemo1 {
    public static void main(String[] args) {
        Socket socket =null;
        OutputStream os =null;
        //客户端
        try {
            //要知道服务器的地址
            InetAddress byName = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //创建一个socket连接
             socket = new Socket(byName, port);
            //发送消息IO流
             os = socket.getOutputStream();
            os.write("你好".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
