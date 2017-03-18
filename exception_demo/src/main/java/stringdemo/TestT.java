package stringdemo;
/**
**  author:jack 2017年03月2017/3/18日
*/
public class TestT {

    String s;

    public static void main(String[] args) {
        TestT t = new TestT();
        //这里把nul强制类型转化，之后就能使用了，还是不太懂引用啊，强制类型转化之类的东西
        System.out.println((Object) null);
        System.out.println((TestT) null);
        //System.out.println(null);
    }

    public void print(){
        String a;
    }
}
