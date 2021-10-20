import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress1 = InetAddress.getLocalHost();
            System.out.println(inetAddress1);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
