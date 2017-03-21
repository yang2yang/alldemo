package produceconsumedemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
**  author:jack 2017年03月2017/3/17日
*/
public class Test {

    public static void main(String[] args) {
        Resource resource = new Resource();
//        Thread thread1 = new Thread(new Producer(resource));
//        Thread thread2 = new Thread(new Consumer(resource));
//        thread2.start();
//        thread1.start();
        //尝试使用之前刚学过的Executors.newCachedThreadPool
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Producer(resource));
        executorService.execute(new Consumer(resource));
        executorService.shutdown();
    }

}

/**
 * 生产者
 */
class Producer implements Runnable{

    public Resource resource;

    public Producer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0;i < 20;i++){
            resource.increase();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable{

    public Resource resource;

    public Consumer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0;i < 20;i++){
                resource.decrease();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Resource{
    //初始资源i是5,最小值为0，最大值为10.也就是说缓冲区的总大小为10.
    public int i = 5;

    //增加操作是线程安全的，是加了锁的
    public synchronized void increase(){
        //这里使用while的意义在于可能会有多个线程同时等待，而有可能不是wait()的条件改变的另一个线程进行了notifyAll()
        //而进行的唤醒，所以这里是需要使用while的，这里while就可以确保是wait()的条件进行了改变，而被唤醒而导致的
        //那么这个线程就可以进行到下面一步了
        while(i == 10){
            try {
                //wait会将当前的线程挂起，并且释放锁，因为可以wait的意义在于，当前线程的事情能做的已经
                //做完了，需要等待其他线程做一些事情，让自身满足某一个条件，而被唤醒继续做某些事情
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i++;
        System.out.println("增加一个,i = " + i);
        //每一次运行完，都要尝试唤醒其他可能在睡眠中的线程
        //这里使用notifyAll比较好一些
        notifyAll();
    }

    //删除操作是线程安全的，是加了锁的
    public synchronized void decrease(){
        while(i == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i--;
        System.out.println("减少一个,i = " + i);
        //唤醒其他线程
        notify();
    }
}


class ResourceCAS{

    AtomicInteger atomicInteger = new AtomicInteger(10);

    public void increase(){

    }

    public void decrease(){

    }
}
