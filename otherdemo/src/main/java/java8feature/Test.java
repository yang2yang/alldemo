package java8feature;

/**
 * Created by qingli.ding on 2018/6/29.
 */
public class Test {

    public static void main(String[] args) {
        test(() -> {
            System.out.println("abc123");
            System.out.println(123);
        });
    }

    public static void test(Test2Interface test2Interface) {
        test2Interface.test();
    }
}
