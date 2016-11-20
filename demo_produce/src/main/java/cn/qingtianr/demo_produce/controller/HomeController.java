package cn.qingtianr.demo_produce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
**  author:jack 2016年11月2016/11/20日
*/
@Controller
public class HomeController {

    @ResponseBody
    @RequestMapping(value = "/index")
    public String Hello(){
        return "Hello,MVC";
    }
}
