package org.epam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy()
public class BeanConfig {

    @Bean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }

//    @Bean
//    public PackageLogger packageLogger(){
//        return new PackageLogger();
//    }

}
