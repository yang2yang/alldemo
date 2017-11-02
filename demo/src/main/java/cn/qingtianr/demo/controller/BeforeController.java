package cn.qingtianr.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

/**
 * Created by ding on 2017/3/31.
 */
@Controller(value = "before")
@RequestMapping(value="/before")
public class BeforeController {

    @PostConstruct
    public void init(){
        System.out.println("It is beforeController init method!");
    }


    @ResponseBody
    @RequestMapping(value="/index")
    public String home(){
        System.out.println("Hello,before!");
        return "Hello,before!";
    }
}
