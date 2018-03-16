package cn.qingtianr.controller;

import cn.qingtianr.model.MessageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @ResponseBody
    @RequestMapping(value = "/json")
    public String getJson(){
        System.out.println(123);
        return "\n" +
                "{\n" +
                "\"data\":{\n" +
                "    \"deviceId\": \"3df439a5-ffcb-4386-aeeac-58897f1ba34\",\n" +
                "    \"deviceInfo\": {\n" +
                "        \"deviceType\": \"Mac\",\n" +
                "        \"screenRes\": \"1440^^900^^-^^-\",\n" +
                "        \"referer\": \"file:///Users/zg/Documents/tongdun/fp/demo_web.html\",\n" +
                "        \"canvas\": \"e829b2a1468bc3561ec6abb045528fcc\",\n" +
                "        \"cookieEnabled\": true,\n" +
                "        \"acceptEncoding\": \"gzip, deflate, sdch\",\n" +
                "        \"os\": \"Mac OS\",\n" +
                "        \"flashEnabled\": false,\n" +
                "        \"userAgent\": \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36\",\n" +
                "        \"pluginListHash\": \"40864349a671edd01820f492549ef220\",\n" +
                "        \"accept\": \"*/*\",\n" +
                "        \"acceptLanguage\": \"zh-CN,zh;q=0.8,en;q=0.6\",\n" +
                "        \"browser\": \"chrome\",\n" +
                "        \"browserVersion\": \"56.0.2924.87\",\n" +
                "        \"fontListHash\": \"-\",\n" +
                "        \"trueIp\": \"10.57.2.23\",\n" +
                "        \"smartId\": \"s_b066f4e9649e4f8c6644cb1df4e81f2f\",\n" +
                "        \"abc\":\"123456\",\n" +
                "        \"telephonyInfos\": [\n" +
                "            {\n" +
                "                \"cellInfos\": [\n" +
                "                    {\n" +
                "                        \"type\": \"gsm\",\n" +
                "                        \"cid\": 22199,\n" +
                "                        \"lac\": 22450\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"type\": \"gsm\",\n" +
                "                        \"cid\": 60134,\n" +
                "                        \"lac\": 22450\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"type\": \"gsm\",\n" +
                "                        \"cid\": 22209,\n" +
                "                        \"lac\": 22450\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"type\": \"gsm\",\n" +
                "                        \"cid\": 31874,\n" +
                "                        \"lac\": 22450\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"type\": \"gsm\",\n" +
                "                        \"cid\": 31474,\n" +
                "                        \"lac\": 22450\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"carrier\": \"-\",\n" +
                "                \"phoneType\": \"GSM\",\n" +
                "                \"phoneNumber\": \"-\",\n" +
                "                \"countryIso\": \"-\",\n" +
                "                \"voiceMail\": \"-\",\n" +
                "                \"simOperator\": \"-\",\n" +
                "                \"imei\": \"867244025481256\",\n" +
                "                \"imsi\": \"-\",\n" +
                "                \"simSerial\": \"-\",\n" +
                "                \"radioType\": \"UNKNOWN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cellInfos\": [],\n" +
                "                \"carrier\": \"-\",\n" +
                "                \"phoneType\": \"GSM\",\n" +
                "                \"phoneNumber\": \"-\",\n" +
                "                \"countryIso\": \"-\",\n" +
                "                \"voiceMail\": \"-\",\n" +
                "                \"simOperator\": \"-\",\n" +
                "                \"imei\": \"867244025481256\",\n" +
                "                \"imsi\": \"-\",\n" +
                "                \"simSerial\": \"-\",\n" +
                "                \"radioType\": \"UNKNOWN\"\n" +
                "            }\n" +
                "        ],\"abnormalTags\": [\"DEBUGGER_DETECTED\",\"SUSPECTED_OF_WIPING_PHONE\"]\n" +
                "    },\n" +
                "    \"fpVersion\": \"3.0.4\"},\n" +
                "    \"reason_code\": \"200\",\n" +
                "    \"reason_desc\": \"\",\n" +
                "    \"seq_id\": \"1507799669419845T0B56301E7967773\",\n" +
                "    \"success\": true\n" +
                "}\n";
    }
}
