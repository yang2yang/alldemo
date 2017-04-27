package instanceofdemo;

/**
 * Created by ding on 2017/4/26.
 */
public class Test {
    public static void main(String[] args) {
        Father father = new Father();
        Child child = new Child();
        Grandson grandson = new Grandson();

        System.out.println("child instanceof Father is " + (child instanceof Father));
        System.out.println("child instanceof IFather is " + (child instanceof IFather));
        System.out.println("child instanceof Grandson is " + (child instanceof Grandson));
    }
}
