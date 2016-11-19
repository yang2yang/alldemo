package cn.qingtianr.demo.bizservice.impl;

import cn.qingtianr.demo.bizservice.BizService;
import cn.qingtianr.demo.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
**  author:jack 2016年11月2016/11/19日
*/
@Service
public class BizServiceImpl implements BizService{

    @Autowired
    SpitterService spitterService;

    public String sayHello() {
        return spitterService.SayHello();
//        return null;
    }

    public void onlySayHello() {
        System.out.println("Hello");
    }
}
