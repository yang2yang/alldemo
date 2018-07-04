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

        int result = test2((int param) -> param, 7);
        System.out.println(result);
    }

    public static void test(Test2Interface test2Interface) {
        test2Interface.test();
    }

    public static int test2(Test3Interface test3Interface, int param) {
        return test3Interface.test(param);
    }
}
