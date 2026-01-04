package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ConnectTimeoutMain1 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {
            // 연결 자체가 문제가 있음
            Socket socket = new Socket("192.169.1.250", 45678);
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            long end = System.currentTimeMillis();
            System.out.println("end = " + (end - start));
        }
    }
}
