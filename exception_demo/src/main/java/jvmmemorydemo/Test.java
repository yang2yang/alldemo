package jvmmemorydemo;
/**
**  author:jack 2017年03月2017/3/15日
*/
public class Test {

    private int a = 5;

    public static void main(String[] args) {
        aaa();
    }

    public static void aaa(){
        int a = 1;
        bbb();
    }

    public static void bbb(){
        Test ttt = new Test();
        int b = 2;
    }
}
