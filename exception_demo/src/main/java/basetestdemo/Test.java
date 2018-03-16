package basetestdemo;

/**
 * *  author:jack 2017年03月2017/3/22日
 */
public class Test {
    public static void main(String[] args) {
        String a = null;
        System.out.println(a);

        int b = 20;
        int c = b++ % 5;
        System.out.println("b=" + b + " " + "c=" + c);

        Object d = null;
        String e = (String) d;
        System.out.println(e == null);
    }
}
