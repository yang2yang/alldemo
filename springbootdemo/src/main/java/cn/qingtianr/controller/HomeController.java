package cn.qingtianr.controller;

import cn.qingtianr.model.MessageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ding on 2017/4/13.
 */
@Controller
@RequestMapping(path = "/home")
public class HomeController {

    @ResponseBody
    @RequestMapping(path = "/index")
    public String home(){
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
