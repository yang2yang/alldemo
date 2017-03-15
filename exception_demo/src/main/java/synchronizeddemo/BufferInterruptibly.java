package synchronizeddemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * *  author:jack 2017年03月2017/3/15日
 */
public class BufferInterruptibly extends ReentrantLock {

//    private ReentrantLock lock = new ReentrantLock();

    public void write() throws InterruptedException {
        lockInterruptibly();
        try {
//            long startTime = System.currentTimeMillis();
//            System.out.println("开始往这个buff写入数据…");
//            for (;;)// 模拟要处理很长时间
//            {
//                if (System.currentTimeMillis()
//                        - startTime > Integer.MAX_VALUE) {
//                    break;
//                }
//            }
            System.out.println("终于写完了");
        } finally {
            unlock();
        }
    }

    public void read() throws InterruptedException {
        lockInterruptibly();// 注意这里，可以响应中断
        try {
            System.out.println("从这个buff读数据....");
            long startTime = System.currentTimeMillis();
            for (; ; ) {
                if (System.currentTimeMillis() - startTime > 60000) {
                    break;
                }
            }
            System.out.println("从这个buff读数据");
        } finally {
            unlock();
        }
    }

    public static void main(String args[]) {
        BufferInterruptibly buff = new BufferInterruptibly();
        BufferInterruptibly buff2 = new BufferInterruptibly();

        final Writer2 writer = new Writer2(buff);
        final Reader2 reader = new Reader2(buff);

        reader.start();
        writer.start();


        long start = System.currentTimeMillis();
        for (; ; ) {
            if (System.currentTimeMillis()
                    - start > 5000) {
                System.out.println("不等了，尝试中断");
                //Thread.currentThread().interrupt();
                //所以中断，是指对应的线程的中断，如果调用中断函数的线程中，有一个方法因为一直拿不到锁
                //而导致一直地等待，那么就中断这个方法，前提是这个锁，需要支持可中断锁
                writer.interrupt();
                break;
            }
        }

    }
}

class Reader2 extends Thread {

    private BufferInterruptibly buff;

    public Reader2(BufferInterruptibly buff) {
        this.buff = buff;
    }

    @Override
    public void run() {

        try {
            buff.read();//可以收到中断的异常，从而有效退出
        } catch (InterruptedException e) {
            System.out.println("我不读了");
        }

        System.out.println("读结束");

    }
}

class Writer2 extends Thread {

    private BufferInterruptibly buff;

    public Writer2(BufferInterruptibly buff) {
        this.buff = buff;
    }

    @Override
    public void run() {
        try {
            buff.write();
        } catch (InterruptedException e) {
            System.out.println("我收到中断，不等你了，大不了我不写了!");
        }
    }

}
