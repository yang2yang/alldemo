package extenddemo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
**  author:jack 2017年03月2017/3/9日
*/
public class Test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Father obj = new Child();
        Method[] methods = obj.getClass().getMethods();
        Field[] fields = obj.getClass().getFields();
        methods[1].invoke(obj);
        System.out.println(obj.value);
        obj.printFather();

        //检测子类能否继承父类方法
        //这个静态变量的东西还是很有问题的，到底引用是怎么实现的呢?
        Child child = new Child();
        Father a = new Child();
        System.out.println(a.i);
        System.out.println(child.i);
    }
}
