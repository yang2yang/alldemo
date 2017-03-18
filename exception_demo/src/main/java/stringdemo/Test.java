package stringdemo;

/**
**  author:jack 2017年03月2017/3/18日
*/
public class Test {
    public static void main(String[] args) {
        String s1 = "abc" + "def";
        //如果使用new出来的东西，和直接通过字面量进行赋值
        //new出来的时候会在堆内存中，重新开辟一个内存对象，但是如果使用字面量去赋值，那么会直接找到相同字符串常量之前创建的对象的引用
        String s2 = new String(s1);
        String s3 = "abcdef";
        String s4 = "abc";

        if(s1 == s2){
            System.out.println("succeed");
        }

        if(s1 == s3){
            System.out.println("没有使用new的话，看一下等号是否会相等");
        }

        if(s1 == s4){
            System.out.println("看一下拼接的时候，会不会在常量池中出现");
        }

        if(s1.equals(s2)){
            System.out.println("equals() succeed");
        }

        String s5 = "ABC";
        String s6 = new String("BCD");
        //还是不太清楚这个intern是干什么用的
        System.out.println(s5.intern());
        System.out.println(s6.intern());
    }
}
