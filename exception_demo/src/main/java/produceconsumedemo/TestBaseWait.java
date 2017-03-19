package produceconsumedemo;
/**
**  author:jack 2017年03月2017/3/19日
*/
public class TestBaseWait {

    public static void main(String[] args) throws InterruptedException {
        Waiter waiter = new Waiter();
        new Thread(waiter).start();
        //暂停5秒
        Thread.sleep(5000);
        synchronized (waiter){
            System.out.println("等了5秒了，主线程去唤醒...");
            waiter.notify();
        }
    }
}

class Waiter implements Runnable{

    Object object = new Object();

    public void doSomeThingWithOutSyn(){
        try {
            wait();//错误的方法调用,不再同步块中
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try{
            //只有在syn(this)的时候才能使用wait
            synchronized (this){
//            synchronized (Waiter.class){
//            synchronized (object){
                System.out.println("wait....");
                wait();
            }
            System.out.println("被唤醒，方法结束了");
        }catch (InterruptedException e){
            System.out.println("中断退出");
        }

    }
}
