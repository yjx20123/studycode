package 文件上传;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo {
    public static void main(String[] args) throws Exception {
        //创建一个Socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        //创建一个输出流
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("1.png"));
        //写出文件
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }
        fis.close();
        os.close();
        socket.close();
    }
}
