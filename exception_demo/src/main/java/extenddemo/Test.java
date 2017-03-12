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

    }
}
