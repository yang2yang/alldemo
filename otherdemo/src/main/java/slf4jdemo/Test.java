package slf4jdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jack on 2017/11/10.
 */
public class Test {
    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(Test.class);
        Logger logger = LoggerFactory.getLogger("这是一个名字");
        logger.info("这是一条info信息");
        logger.debug("这是一条debug信息");
    }
}
