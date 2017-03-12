package threaddebugdemo;
/**
**  author:jack 2017年03月2017/3/3日
*/
public class TestPri implements Runnable{

    public void printprint(){
        System.out.println("123456");
    }

    @Override
    public void run() {
        System.out.println("*******");
    }
}
