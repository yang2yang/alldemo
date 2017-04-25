/**
 * ChangCai.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package cn.qingtianr.demo.controller;

import cn.qingtianr.demo.model.MessageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dingqingli
 * @version HomeController.java, v 0.1 2017/1/13 10:15 dingqingli Exp $
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @ResponseBody
    @RequestMapping(value = "/index")
    public String home(){
        return "Hello,MVC";
    }

    @ResponseBody
    @RequestMapping(value = "/returnMessageBean")
    public MessageBean returnMessageBean(){
        return new MessageBean(true,"返回对象成功");
    }
}
