package network.tcp.v10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.Logger.log;

public class ClientV10 {
    private static final int PORT =12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        // 소켓 연결이 되면 자동으로 클라이언트 포트가 할당된다.
        Socket socket = new Socket("localhost", PORT);
        socket.setSoTimeout(3000);

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        log("소캣 연결: " + socket);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("전송 문자: ");
            String toSend = scanner.next();

            // 서버에게 문자 보내기
            output.writeUTF(toSend);
            log("client -> server: " + toSend);

            if (toSend.equals("exit")) {
                break;
            }
            // 서버로부터 문자 받기
            String received = input.readUTF();
            log("client <- server: " + received);
        }


        // 자원 정리
        input.close();
        output.close();
        socket.close();
    }
}
