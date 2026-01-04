package network.exception.connect;

import util.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SoTimeoutClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        Logger.log("연결 완료 " + socket);

        InputStream input = socket.getInputStream();

        try {
            socket.setSoTimeout(3000); // 클라이언트 측의 소켓 타임아웃 시간 설정
            int read = input.read();
            System.out.println("read = " + read);
        } catch (Exception e) {
            Logger.log("서버로부터 응답이 없습니다.");
            e.printStackTrace();
        }

        socket.close();

    }
}
