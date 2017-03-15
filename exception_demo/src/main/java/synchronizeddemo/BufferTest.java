package synchronizeddemo;

/**
 * *  author:jack 2017年03月2017/3/15日
 */
public class BufferTest {

    private Person person = new Person();

    public synchronized void write() {
        synchronized (person) {
            long startTime = System.currentTimeMillis();
            System.out.println("开始往这个buff写入数据…");
            for (; ; )// 模拟要处理很长时间
            {
                if (System.currentTimeMillis()
                        - startTime > Integer.MAX_VALUE) {
                    break;
                }
            }
            System.out.println("终于写完了");
        }
    }

    public synchronized void read() {
        System.out.println("从这个buff读数据");
    }

    public void readSyn() {
        synchronized (person) {
            System.out.println("从这个buff中读数据，使用的是方法内部的syn块...");
        }
    }

    public void readNoSyn() {
        System.out.println("从这个buff中读数据，但是方法没有syn的限制");
    }

    public static void main(String[] args) {
        BufferTest buff = new BufferTest();

        final Writer3 writer = new Writer3(buff);
        final Reader3 reader = new Reader3(buff);

        writer.start();
        reader.start();

        long start = System.currentTimeMillis();
        for (; ; ) {
            //等5秒钟去中断读
            if (System.currentTimeMillis()
                    - start > 5000) {
                System.out.println("不等了，尝试中断");
                reader.interrupt();
                break;
            }

        }

        // 我们期待“读”这个线程能退出等待锁，可是事与愿违，一旦读这个线程发现自己得不到锁，
        // 就一直开始等待了，就算它等死，也得不到锁，因为写线程要21亿秒才能完成 T_T ，即使我们中断它，
        // 它都不来响应下，看来真的要等死了。这个时候，ReentrantLock给了一种机制让我们来响应中断，
        // 让“读”能伸能屈，勇敢放弃对这个锁的等待。我们来改写Buffer这个类，就叫BufferInterruptibly吧，可中断缓存。
    }
}

class Writer3 extends Thread {

    private BufferTest buff;

    public Writer3(BufferTest buff) {
        this.buff = buff;
    }

    @Override
    public void run() {
        buff.write();
    }
}

class Reader3 extends Thread {

    private BufferTest buff;

    public Reader3(BufferTest buff) {
        this.buff = buff;
    }

    @Override
    public void run() {

        buff.readSyn();//这里估计会一直阻塞

        System.out.println("读结束");

    }
}


class Person {
}

