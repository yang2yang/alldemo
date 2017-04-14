package cn.qingtianr.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ding on 2017/3/31.
 */
@Controller
@RequestMapping(value="/test")
public class TestController {

    @ResponseBody
    @RequestMapping(value="/index")
    public String testHome(){
        return "hello testHome!";
    }

    @ResponseBody
    @RequestMapping(value = "testParams")
    public String testParameters(String name){
        return name;
    }

}
