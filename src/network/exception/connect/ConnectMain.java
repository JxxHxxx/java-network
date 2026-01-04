package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectMain {

    public static void main(String[] args) throws IOException {
        unknownHostEx1();
        unknownHostEx2();

        connectionRefused();
    }

    private static void connectionRefused() throws IOException {
        // 안쓰는 포트
        try {
            Socket socket = new Socket("localhost", 45678);

        } catch (ConnectException e) { // 대상이 연결이 거절한 경우 RST 패킷을 받은거임
            // 다시 말해 해당 IP 서버에 접속은 했으나 거절을 받은 경우
            e.printStackTrace();
        }
    }

    private static void unknownHostEx1() throws IOException {
        try {
            Socket socket = new Socket("999.999.999.999", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();

        }
    }

    private static void unknownHostEx2() throws IOException {
        try {
            Socket socket = new Socket("google.gogo", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();

        }
    }
}
