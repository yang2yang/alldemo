package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jack on 2017/9/12.
 */
@Controller
@RequestMapping(path = "/jvm")
public class JvmTestController {

//    private static int count = 0;

    @ResponseBody
    @RequestMapping(path = "/test1")
    public String testJvm1(){
        int count = 0;
        while(count++ < 100000){
            new JsonBean();
        }
        return "it's ok";
    }
}
