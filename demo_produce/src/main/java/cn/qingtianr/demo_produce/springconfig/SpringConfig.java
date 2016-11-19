package cn.qingtianr.demo_produce.springconfig;

import cn.qingtianr.demo_produce.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

/**
**  author:jack 2016年11月2016/11/19日
*/
@Configuration
@ComponentScan("cn.qingtianr.demo_produce")
public class SpringConfig {

    @Bean(name="/spitter.service")
    public HessianServiceExporter hessianExportedSpitterService(SpitterService service){
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(service);
        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }

}
