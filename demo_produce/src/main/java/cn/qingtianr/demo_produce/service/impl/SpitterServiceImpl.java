package cn.qingtianr.demo_produce.service.impl;

import cn.qingtianr.demo_produce.service.SpitterService;
import org.springframework.stereotype.Service;

/**
**  author:jack 2016年11月2016/11/19日
*/
@Service
public class SpitterServiceImpl implements SpitterService{
    public String SayHello() {
        return "Hello,Hessian";
    }
}
