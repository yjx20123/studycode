package 聊天室;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo1 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream boas = null;
        try {
            //服务端，首先建立一个地址
            serverSocket = new ServerSocket(9999);
            //等待客户端连接过来
            accept = serverSocket.accept();

            //读取客户端的消息
            is = accept.getInputStream();
            //管道流
            boas = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                boas.write(buffer, 0, len);

            }
            System.out.println(boas.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (boas != null) {
                try {
                    boas.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
