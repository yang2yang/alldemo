package threaddebugdemo;
/**
**  author:jack 2017年03月2017/3/3日
*/
public class TheadDebug {

    public static void main(String[] args) throws InterruptedException {
        TestPri testPri = new TestPri();
        Thread thread = new Thread(testPri);
        thread.start();
        for(int i = 0;i < 10;i++){
            System.out.println(i);
        }
        testPri.printprint();
    }

}
