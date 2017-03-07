package executordemo;

import java.util.concurrent.*;

/**
 * *  author:jack 2017年03月2017/3/3日
 */
public class ExecutorCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for(int i = 0;i < 10000;i++){
            Future<String> future = executorService.submit(new Hello(i));
            //这里因为get是一个阻塞的方法，所以这里会阻塞知道打印出来结果，多线程变成了串行执行了
            //这里到底是怎么做到的呢?
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}


class Hello implements Callable<String>{

    public int i;

    public Hello(int i){
        this.i = i;
    }

    @Override
    public String call() throws Exception {
        return "i = " + i;
    }
}
