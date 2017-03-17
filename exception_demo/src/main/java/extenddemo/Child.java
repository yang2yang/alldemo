package extenddemo;
/**
**  author:jack 2017年03月2017/3/9日
*/
public class Child extends Father {

    public static int i = 1;

    public String value = "childvalue";

    public void printFather(){
        System.out.println("Child");
    }

    public void sayHello(){
        System.out.println("hello,child");
    }
}
