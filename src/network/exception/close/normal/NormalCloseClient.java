package network.exception.close.normal;

import util.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class NormalCloseClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        Logger.log("소캣 연결" + socket);
        InputStream input = socket.getInputStream();

        readByinputStream(input, socket);

    }

    private static void readByinputStream(InputStream input, Socket socket) throws IOException {
        int read = input.read();
        Logger.log("read = " + read);

        if (read == -1) {
            input.close();
            socket.close();
        }
    }
}
