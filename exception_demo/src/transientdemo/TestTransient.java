package transientdemo;

import java.io.*;

/**
**  author:jack 2017年03月2017/3/11日
*/
public class TestTransient {

    /**
     * @param args
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        A a = new A(25,"张三");
        System.out.println(a);
        //打开一个流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d://mm.txt"));
        //在流里面写入一个对象,此对象必须是实现Serializable接口的
        oos.writeObject(a);
        //关闭一个流
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d://mm.txt"));
        //从流中反序列化一个对象
        a = (A)ois.readObject();
        //发现transient修饰的String b没有出现,也就是说
        System.out.println(a);

    }

}

class A implements Serializable {
    int a;
    transient String b;
    public A(int a,String b){
        this.a = a;
        this.b = b;
    }
    public String toString(){
        return "a = "+a+",b = "+b;
    }
}