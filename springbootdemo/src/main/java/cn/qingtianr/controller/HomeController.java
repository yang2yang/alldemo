package cn.qingtianr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ding on 2017/4/13.
 */
@Controller
public class HomeController {

    @ResponseBody
    @RequestMapping(path = "/index")
    public String home(){
        return "Hello,SpringBoot!";
    }

}
