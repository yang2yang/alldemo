package instanceofdemo;

/**
 * Created by ding on 2017/4/27.
 */
public class TestObject {
    public static void main(String[] args) {
        printString("abc");
        printString(111);
        printString(0.111);
        printString(new Student(1,"aaa", 20));
    }

    private static void printString(Object object) {
        if (object instanceof String) {
            System.out.println("It is a string which is " + object);
        } else if (object instanceof Number) {
            System.out.println("It is a number which is " + object);
        } else if (object instanceof Student) {
            System.out.println("It is a student which is " + object);
            //这里调用子类的方法时，需要进行强制类型转换
            System.out.println(((Student)object).SelfIntroduction());
        }
    }
}

class Student {

    private Integer id;

    private String name;

    private Integer age;

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String SelfIntroduction() {
        return "id = " + this.id;
    }


    @Override
    public String toString() {
        return "name = " + this.name + " age = " + this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
