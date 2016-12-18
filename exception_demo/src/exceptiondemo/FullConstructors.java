package exceptiondemo;

/**
**  author:jack 2016年12月2016/12/3日
*/
public class FullConstructors {

    private int a = 5;
    private int b;

    public static void f() throws MyException{
        System.out.println("Throwing exceptiondemo.MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException{
        System.out.println("Throwing exceptiondemo.MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void m(){
        try {
            throw new MyException("Throwing exceptiondemo.MyException from m()");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public void n() throws MyException {
        a = 6;
        throw new MyException("Throwing exceptiondemo.MyException from n");
    }

    public static void main(String[] args) {

        FullConstructors fullConstructors = new FullConstructors();

        System.out.println("a=" + fullConstructors.a);

        FullConstructors fullConstructors1 = null;

        try{
            System.out.println(fullConstructors1.getB());
        }catch (Exception e){

        }


        System.out.println("after NullPointerException");

        try {
            fullConstructors.n();
        } catch (MyException e) {
            e.printStackTrace();
        }

        System.out.println("after throwing exceptiondemo.MyException a="+fullConstructors.a);

        try{
            f();
            System.out.println("print after f()");
        }catch (MyException e){
            System.out.println("nothing");
//            e.printStackTrace(System.out);
        }

        try{
            System.out.println("print before g()");
            g();
            System.out.println("print after g()");
        } catch (MyException e){
            System.out.println("nothing");
//            e.printStackTrace(System.out);
        }
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
