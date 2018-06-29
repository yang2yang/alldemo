package jvmmemorydemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jack on 2018/4/20.
 */
public class TestForVMOptions {
    public static void main(String[] args) throws InterruptedException {

        fun2();

        fun1();
    }


    public static void fun1() {
        while (true) {

        }
    }


    public static void fun2() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("fun2");
            Thread.sleep(5000L);
        }
    }


}
