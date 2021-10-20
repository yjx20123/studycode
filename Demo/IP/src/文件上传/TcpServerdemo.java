package 文件上传;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServerdemo {
    public static void main(String[] args) throws Exception {
        //创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //监听客户端的连接
        Socket socket = serverSocket.accept();//阻塞式监听，会一直等待客户端裂解
        Scanner scanner = new Scanner(System.in);
        //获取输入流
        InputStream is = socket.getInputStream();
        //4、文件输出
        FileOutputStream fileOutputStream = new FileOutputStream(new File("re.png"));
        byte[] bytes = new byte[1024];
        int len ;
        while ((len=is.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
