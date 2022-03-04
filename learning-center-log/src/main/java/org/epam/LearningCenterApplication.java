package org.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableConfigurationProperties(PackageLogger.class)
public class LearningCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningCenterApplication.class, args);
    }
}