package testio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by jack on 2018/3/16.
 */
public class Client {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 2; i++) {
                Socket socket = new Socket("127.0.0.1", 8080);
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.write("the first line");
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}