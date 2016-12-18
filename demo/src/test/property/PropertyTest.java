package property;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
**  author:jack 2016年12月2016/12/17日
*/
public class PropertyTest {

    public static void main(String[] args) {
        TestModel tm = new TestModel();
        BeanWrapper bw = new BeanWrapperImpl(tm);

        bw.setPropertyValue("good","on");

        System.out.println(tm);

    }

//    public static void main(String[] args) {
//        TestModel tm = new TestModel();
//        BeanWrapperImpl bw = new BeanWrapperImpl(false);
//        bw.setWrappedInstance(tm);
//        bw.setPropertyValue("good", "1");
//        System.out.println(tm);
//
//    }
}
