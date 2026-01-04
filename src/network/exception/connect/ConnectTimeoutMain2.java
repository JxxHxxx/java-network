package network.exception.connect;

import util.Logger;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ConnectTimeoutMain2 {

    public static void main(String[] args) throws IOException {

        try {
            Socket socket = new Socket();
            // 타임아웃 설정
            // 타임 아웃이 2개임
            // 1. 연결 타임아웃 - TCP 연결 자체가 문제가 있는거
            // 2. 소켓 타임아웃(read timeout) - TCP 연결은 잘됨, 클라이언트가 요청 시 서버의 응답이 없을 때
            Logger.log("클라이언트 접속 시도");
            socket.connect(new InetSocketAddress("192.169.1.250", 45678), 3000);
        } catch (SocketTimeoutException e) {
            Logger.log("서버로부터 응답이 없습니다.");
            e.printStackTrace();
        }
    }
}
