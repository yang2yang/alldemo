package cn.qingtianr.controller;

import cn.qingtianr.model.MessageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

/**
 * Created by ding on 2017/4/13.
 */
@Controller
@RequestMapping(path = "/home")
public class HomeController {

    @Autowired
    Environment env;

    @Value("${something}")
    private String something;

    private String bePosted;

    private String example;

    @Value("${fort.a.b}")
    private String hello;

    @PostConstruct
    public void init(){
        this.bePosted = env.getProperty("something");
        this.example = env.getProperty("somethingInExample");
    }

    @ResponseBody
    @RequestMapping(path = "/index")
    public String home() {
        System.out.println("something in env = " + env.getProperty("something"));
        System.out.println("something = " + something);
        System.out.println("bePosted = " + bePosted);
        System.out.println("example = " + example);
        System.out.println("hello = "+hello);
        return "Hello,SpringBoot!";
    }

    @ResponseBody
    @RequestMapping(value = "/returnMessageBean")
    public MessageBean returnMessageBean(){
        return new MessageBean(true,"返回对象成功");
    }

    @RequestMapping(path = "/webSocket")
    public String getWebSocket(){
        return "testWebSocket";
    }
}
