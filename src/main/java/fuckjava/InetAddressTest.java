package fuckjava;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println( localHost.getHostAddress() );
        System.out.println( localHost.getHostName() );
    }
}
