package cn.qingtianr.demo_produce.controller;

import cn.qingtianr.demo_produce.model.GenericTest;
import cn.qingtianr.demo_produce.model.ImplAGeneric;
import org.springframework.web.bind.annotation.*;

/**
**  author:jack 2016年11月2016/11/20日
*/
@RestController
@RequestMapping("/home")
public class HomeController {

    @ResponseBody
    @RequestMapping(value = "/index")
    public String Hello(){
        return "Hello,MVC";
    }

    @ResponseBody
    @RequestMapping(value = "/nihao",method= RequestMethod.POST)
    public <T extends GenericTest> String niHao(T t){
//        System.out.println(t.getName());
//        System.out.println(t.getClass());
        return "niHao";
    }

    @ResponseBody
    @RequestMapping(value = "/nihaoa")
    public  String niHaoa(ImplAGeneric t){
        System.out.println(t.getName());
        return "niHao";
    }
}
