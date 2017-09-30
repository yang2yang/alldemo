package reflectdemo;

/**
 * Created by jack on 2017/9/30.
 */

import java.lang.reflect.Field;

/**
 * 测试Java的反射的API
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        person.setName("person1");
        person.setAge(15);

        for(Field field : person.getClass().getDeclaredFields()){
            System.out.println(field.getName());
            field.setAccessible(true);
            System.out.println(field.get(person));
        }
    }

}
