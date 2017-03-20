package produceconsumedemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * *  author:jack 2017年03月2017/3/20日
 */
class LiftOffRunner implements Runnable {
    //只有这块内存是共享的，使用的是队列来模拟
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }

    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
                //这里取完数据，该线程sleep的时候，另一个线程明明应该是可以put对象进去的才对啊?
//                Thread.sleep(2000);
                //take完之后也不能马上放入队列中,放入的队列应该阻塞了才对，但是take完应该释放锁了把，另一个线程应该是可以得到锁的才对啊?
                for(int i = 0;i < 10000;i++){
                    ;
                }
                System.out.println("sleeping is over");
            }
        } catch (InterruptedException e) {
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }

}

public class TestBlockingQueues {
    static void getkey() {
        try {
            // Compensate for Windows/Linux difference in the
            // length of the result produced by the Enter key:
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getkey(String message) {
        System.out.println(message);
        getkey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        //主线程生产LiftOff对象，并将对象放入到队列中----->Lift off(升空对象)由rocket(火箭)倒计时
        for (int i = 0; i < 6; i++) {
//            runner.add(new LiftOff(5));
            try {
                System.out.println("begin putting " + i + " LiftOff Object");
                queue.put(new LiftOff(5));
                System.out.println("have already put " + i + " LiftOff Object");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        getkey("Press'Enter'(" + msg + ")");
        t.interrupt();
        System.out.println("Finished " + msg + " test");
    }

    public static void main(String[] args) {
        // 基于链表实现的阻塞队列
//        test("LinkedBlockingQueue", new LinkedBlockingDeque<LiftOff>());
        // 基于数组实现的阻塞队列
        //这个大小是从0开始的??
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(1));
        //同步的队列?有什么区别啊?
//        test("SynchronousQueue", new SynchronousQueue<LiftOff>());
        //new LiftOff(5).run();
    }

}


class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!")
                + ")";
    }

    /**
     * run的意义在于每一次都打印出来
     */
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();//线程的礼让
        }
    }

}