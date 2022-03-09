package org.epam.logging.aopconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfiguration {

    @Bean
   // @ConditionalOnProperty(prefix = "logging.enable", havingValue = "true")
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }

    @Bean
    List<PackageProperties> packagePropertiesList(List<PackageProperties> packageProperties) {
        return packageProperties;
    }

    @Bean
    @ConfigurationProperties(prefix = "remove")
    public PackageProperties removeMethod() {
        return new PackageProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "add")
    public PackageProperties addMethod() {
        return new PackageProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "filter")
    public PackageProperties filterMethod() {
        return new PackageProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "report")
    public PackageProperties reportMethod() {
        return new PackageProperties();
    }
}
