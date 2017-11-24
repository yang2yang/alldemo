package sl4jdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jack on 2017/11/10.
 */
public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        logger.info("这是一条info日志.");
    }
}
