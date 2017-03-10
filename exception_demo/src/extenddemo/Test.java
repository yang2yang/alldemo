package extenddemo;
/**
**  author:jack 2017年03月2017/3/9日
*/
public class Test {
    public static void main(String[] args) {
        Father obj = new Child();
        System.out.println(obj.value);
        obj.printFather();

        Child child = new Child();
        System.out.println(child.value);
        child.printFather();
    }
}
