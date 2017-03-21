package produceconsumedemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
**  author:jack 2017年03月2017/3/21日
*/
public class CountDownLatchTest {

    static class Worker implements Runnable {
        private final CountDownLatch doneSignal;
        private final int i;

        public Worker(CountDownLatch doneSignal, int i) {
            this.doneSignal = doneSignal;
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("now is " + i);
            doneSignal.countDown();
            System.out.println("After countDown count = " + doneSignal.getCount());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        int N = 10;
        CountDownLatch countDownLatch = new CountDownLatch(N);
        ExecutorService executor = Executors.newFixedThreadPool(N);
        for (int i = 0; i < N; i++)
            //多个线程共享一个countDownLatch,countDownLatch需要一个初始化参数
            executor.execute(new Worker(countDownLatch, i));
        //countDownLatch需要等待里面的count = 0，才会继续执行本线程
        countDownLatch.await();
        System.out.println("over");
    }
}
