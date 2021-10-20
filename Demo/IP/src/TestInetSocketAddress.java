import java.net.InetSocketAddress;

public class TestInetSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8080);
        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getHostName ());
        System.out.println(inetSocketAddress.getPort ());
        System.out.println(inetSocketAddress.getClass ());

    }
}
