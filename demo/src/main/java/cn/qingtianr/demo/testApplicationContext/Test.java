package cn.qingtianr.demo.testApplicationContext;


import cn.qingtianr.demo.controller.BeforeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ding on 2017/4/1.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("cn.qingtianr.demo.controller");
        BeforeController beforeController = (BeforeController) context.getBean("before");
        beforeController.home();
    }
}
