package synchronizeddemo;

/**
 *
 * @author jack
 * @date 2018/4/2
 */
public class synIntergerI {

    public static Integer i = 0;

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread2 myThread2 = new MyThread2();
        myThread.start();
        myThread2.start();
    }

}


class MyThread2 extends Thread {

    @Override
    public void run() {
        synchronized (synIntergerI.i) {
            while (true) {
                if (synIntergerI.i==2){
                    synIntergerI.i.notify();
                }
            }
        }
    }
}


class MyThread extends Thread {

    @Override
    public void run() {
        synchronized (synIntergerI.i) {
            while (true) {
                synIntergerI.i = synIntergerI.i + 1;
                if (synIntergerI.i == 2) {
                    try {
                        synIntergerI.i.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}