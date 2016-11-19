package cn.qingtianr.demo.bizservice.impl;

import cn.qingtianr.demo.bizservice.BizService;
import cn.qingtianr.demo.service.SpitterService;
import cn.qingtianr.demo.springconfig.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfig.class, loader=AnnotationConfigContextLoader.class)
//@ContextConfiguration("classpath:/spring/demo.xml")
public class BizServiceImplTest {

    @Autowired
    private SpitterService spitterService;

    @Autowired
    private BizService bizService;

    @Test
    public void sayHello() throws Exception {
        System.out.println(spitterService.SayHello());
    }

    @Test
    public void onlySayHello() throws Exception {
        bizService.onlySayHello();
    }
}