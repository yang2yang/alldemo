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
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public String getJson(){
        System.out.println(123);
        return "{\n" +
                "\"data\":{\n" +
                "    \n" +
                "    \"deviceId\": \"3df439a5-ffcb-4386-aeeac-58897f1ba34\",\n" +
                "    \"deviceInfo\": {\n" +
                "        \"apkMD5\": \"\",\n" +
                "        \"cpuFrequency\": 1209600,\n" +
                "        \"dnsAddress\": \"192.168.6.8,192.168.8.61\",\n" +
                "        \"allowMockLocation\": false,\n" +
                "        \"vpnIp\": \"\",\n" +
                "        \"language\": \"zh\",\n" +
                "        \"deviceName\": \"HM2014811\",\n" +
                "        \"apkVersion\": \"3.0.4\",\n" +
                "        \"wifiIp\": \"10.57.4.43\",\n" +
                "        \"basebandVersion\": \"MPSS.DPM.1.0.c7.18-00023-M8916EAAAANUZM-1-all16\",\n" +
                "        \"wifiNetmask\": \"255.255.255.0\",\n" +
                "        \"batteryTemp\": 25,\n" +
                "        \"blueMac\": \"\",\n" +
                "        \"cellIp\": \"\",\n" +
                "        \"host\": \"qh-miui-ota-offline07\",\n" +
                "        \"model\": \"2014811\",\n" +
                "        \"cpuHardware\": \"ARMv7 Processor rev 0 (v7l)\",\n" +
                "        \"brand\": \"Xiaomi\",\n" +
                "        \"androidId\": \"8e814ba4266100c\",\n" +
                "        \"hardware\": \"qcom\",\n" +
                "        \"bootTime\": 1488700760511,\n" +
                "        \"activeTime\": 136428587,\n" +
                "        \"proxyInfo\": \"\",\n" +
                "        \"timeZone\": \"dstDiff=0,gmfOffset=480\",\n" +
                "        \"serialNo\": \"3792d62e\",\n" +
                "        \"tags\": \"release-keys\",\n" +
                "        \"deviceSVN\": \"07\",\n" +
                "        \"kernelVersion\": \"Linux version 3.10.28-g65c27a9 (builder@qh-miui-ota-offline07) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Thu May 26 00:45:26CST2016\\n\",\n" +
                "        \"fontHash\": \"9a89a551ded803f744d540f3595e5b3a\",\n" +
                "        \"sdkVersion\": \"19\",\n" +
                "        \"trueIp\": \"123.157.153.130\",\n" +
                "        \"cpuType\": \"Qualcomm Technologies, Inc MSM8916\",\n" +
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
                "        ],\n" +
                "        \"ssid\": \"\\\"TONGDUN\\\"\",\n" +
                "        \"totalStorage\": 5752967168,\n" +
                "        \"vpnNetmask\": \"\",\n" +
                "        \"root\": true,\n" +
                "        \"signMD5\": \"9ea04b98edadab5521b6c6f4ab6a3de1\",\n" +
                "        \"packageName\": \"cn.tongdun.android.demo304\",\n" +
                "        \"networkType\": \"WIFI\",\n" +
                "        \"batteryLevel\": 100,\n" +
                "        \"screenRes\": \"720x1280\",\n" +
                "        \"product\": \"2014811\",\n" +
                "        \"os\": \"android\",\n" +
                "        \"releaseVersion\": \"4.4.4\",\n" +
                "        \"display\": \"KTU84P\",\n" +
                "        \"upTime\": 250861493,\n" +
                "        \"gpsLocation\": {\n" +
                "            \"latitude\": 30.282403,\n" +
                "            \"longitude\": 120.011531\n" +
                "        },\n" +
                "        \"brightness\": 102,\n" +
                "        \"totalMemory\": 940589056,\n" +
                "        \"availableMemory\": 279117824,\n" +
                "        \"sdkMD5\": \"108808287700b41043347c85a068de8e\",\n" +
                "        \"batteryStatus\": \"full\",\n" +
                "        \"availableStorage\": 4225970176,\n" +
                "        \"wifiMac\": \"34:80:b3:83:d1:83\",\n" +
                "        \"gateway\": \"10.57.4.1\"\n" +
                "    },\n" +
                "    \"fpVersion\": \"3.0.4\"},\n" +
                "    \"reason_code\": \"200\",\n" +
                "    \"reason_desc\": \"\",\n" +
                "    \"seq_id\": \"1507799669419845T0B56301E7967773\", \n" +
                "    \"success\": true\n" +
                "}\n";
    }
}
