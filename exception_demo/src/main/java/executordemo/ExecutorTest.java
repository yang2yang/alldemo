package executordemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
**  author:jack 2017年03月2017/3/3日
*/
public class ExecutorTest {

    public static void main(String[] args) {
        //使用单线程的ExecutorService
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //使用固定线程池的ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //使用带有缓存会动态变化的线程池的ExecutorService
//        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0;i < 1000;i++){
            executorService.execute(new ABC(i));
        }
        System.out.println(Thread.currentThread().getName());
        executorService.shutdown();
    }

}

class ABC implements Runnable{

    public int i;

    public ABC(int i){
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "i = " + i);
    }
}
