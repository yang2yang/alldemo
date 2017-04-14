package classdemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by ding on 2017/4/14.
 */
public class testMethodInvoke {
    public static void main(String[] args) throws Exception {
        //测试一下method的反射的调用
        //这个问号的是泛型?到底是什么作用呢?
        Class<?> clazz = Class.forName("classdemo.A");

        A aa = (A) clazz.newInstance();

        Method[] method = clazz.getDeclaredMethods();
        method[0].invoke(aa,"aaa","bbbb",1);
        System.out.println(method[0].getParameters());

        for(Parameter parameter : method[0].getParameters()){
            System.out.println("parameterName = " + parameter.getName());
        }

        //对Field的操作
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println("fieldName = " + field.getName());
            System.out.println("Modifier = " + field.getModifiers());
            System.out.println("Type = " + field.getType());
            //只有在setAccessible之后才能对private的field的对象进行操作
            field.setAccessible(true);
            System.out.println("Value = " + field.get(aa));
            if(field.getName().equals("name")){
                field.set(aa,"change name value");
                System.out.println("Value = " + field.get(aa));
            }
        }
    }
}
