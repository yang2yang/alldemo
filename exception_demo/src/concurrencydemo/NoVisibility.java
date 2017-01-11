package concurrencydemo;
/**
**  author:jack 2016年12月2016/12/19日
*/
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run(){
            while(!ready){
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
//        Thread.sleep(1000);
        number = 42;
        ready = true;
    }

}
