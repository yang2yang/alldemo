/**
**  author:jack 2016年12月2016/12/4日
*/
public class TTestException {

    public void a() throws MyException {
        throw new MyException();
    }

    public void b(){
        try {
            throw new MyException();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public void c() throws NullPointerException{
        String s = null;
        System.out.println(s.length());
    }

    public static void main(String[] args) {
        TTestException tTestException = new TTestException();
        try {
            tTestException.a();
        } catch (MyException e) {
            e.printStackTrace();
        }

        tTestException.b();

        System.out.println("After b() before c()");

        tTestException.c();

        System.out.println("After c()");
    }

}
