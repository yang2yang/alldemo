package cn.qingtianr.util;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by jack on 2017/9/24.
 */

public class MyPropertyUtil {

    private String path;

    @PostConstruct
    public void init() throws IOException {
        Properties properties = new Properties();
        properties.load(MyPropertyUtil.class.getClassLoader().getResourceAsStream(this.path));
        System.out.println("something = "+properties.getProperty("something"));
    }


    public String get(String name){
        return null;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
