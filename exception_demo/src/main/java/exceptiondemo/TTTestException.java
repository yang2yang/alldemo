package exceptiondemo;
/**
**  author:jack 2017年03月2017/3/18日
*/
public class TTTestException {
    public static void main(String[] args) {
        try{
            throw new Exception();
        } catch (Exception e) {
            System.out.println("in catch block.");
            return;
        }finally{
            System.out.println("in finally block");
        }
//        System.out.println("after finally block");
    }
}
