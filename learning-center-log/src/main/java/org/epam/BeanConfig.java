package org.epam;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.epam")
public class BeanConfig {

    @Bean("packageLoggerRemove")
    @ConfigurationProperties(prefix = "remove")
    public PackageLogger packageLoggerRemove() {
        return new PackageLogger();
    }

    @Bean("packageLoggerAdd")
    @ConfigurationProperties(prefix = "add")
    public PackageLogger packageLoggerAdd() {
        return new PackageLogger();
    }

}
