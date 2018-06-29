package testio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author jack
 * @date 2018/3/16
 */
public class TestOldIO {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            while (true) {
                //阻塞
                Socket socket = serverSocket.accept();
                System.out.println("有一个连接建立");

                ExecutorService executorService = Executors.newFixedThreadPool(3);
                executorService.submit(new Task(socket));
            }

        } catch (IOException e) {

        }

    }
}

/**
 * 任务类
 */
class Task implements Runnable {

    private Socket socket;

    public Task(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = in.readLine();

            while (!"end!".equals(line)) {
                for(int i = 0;i < 1000000000000L;i++){
                    System.out.println(Thread.currentThread().getName());
                }
                line = in.readLine();
            }

            System.out.println("有一个连接关闭");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
