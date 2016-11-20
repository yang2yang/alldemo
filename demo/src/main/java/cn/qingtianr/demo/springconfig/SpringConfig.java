package cn.qingtianr.demo.springconfig;

import cn.qingtianr.demo.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

/**
**  author:jack 2016年11月2016/11/19日
*/
//@Configuration
//@ComponentScan("cn.qingtianr.demo")
public class SpringConfig {

    @Bean
    public SpitterService spitterService(){
        HessianProxyFactoryBean proxy = new HessianProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/spitter.service");
        proxy.setServiceInterface(SpitterService.class);
        return (SpitterService) proxy.getObject();
    }

}
