package URL;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlDown {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/yjx/1.txt");
        //连接到这个资源HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("SecurityFile.txt");
        byte[] buffer = new byte[1024]; //存储池
        int len ;
        while ((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);//写出这个数据

        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();//断开连接


    }
}
