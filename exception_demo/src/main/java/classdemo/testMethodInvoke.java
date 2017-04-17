package classdemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;

/**
 * Created by ding on 2017/4/14.
 */
public class testMethodInvoke {
    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("classdemo.B");

        B aa = (B) clazz.newInstance();

        Method[] method = clazz.getDeclaredMethods();
        method[0].invoke(aa,"aaa","bbbb",1);
//        System.out.println(method[0].getParameters());

//        for(Parameter parameter : method[0].getParameters()){
//            System.out.println("parameterName = " + parameter.getName());
//        }


        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println("fieldName = " + field.getName());
            System.out.println("Modifier = " + field.getModifiers());
            System.out.println("Type = " + field.getType());

            field.setAccessible(true);
            System.out.println("Value = " + field.get(aa));
            if(field.getName().equals("name")){
                field.set(aa,"change name value");
                System.out.println("Value = " + field.get(aa));
            }
        }
    }
}

class B {
    private int a;

    private Long b;

    private String name;

    private String password;

    public void printprint(String first,String mid,Integer last){
        System.out.println("first = " + first + " mid = " +mid + " last = " + last);
    }
}
