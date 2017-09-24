package cn.qingtianr;

//import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by jack on 2017/9/4.
 */
@Configuration
@PropertySource("properties/example.properties")
public class SprintBootJavaConfig {

    /**
     * 配置数据源
     * @return
     */
//    @Bean
//    public DataSource getDataSource(){
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/test");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("123456");
//        return (DataSource) dataSourceBuilder.build();
//    }


    @Bean
    public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
        PropertySourcesPlaceholderConfigurer p =  new PropertySourcesPlaceholderConfigurer();
        p.setIgnoreUnresolvablePlaceholders(true);
        return p;
    }



}
