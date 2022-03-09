package org.epam.logging.aopconfig;

import org.epam.logging.aop.CustomPointcut;
import org.epam.logging.aop.LearningCenterLoggingAspect;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {

    @Bean
    //@ConditionalOnProperty(prefix = "logging.enable", havingValue = "true")
    public CustomPointcut customPointcut() {
        return new CustomPointcut();
    }

    @Bean
    public LearningCenterLoggingAspect learningCenterLoggingAspect() {
        return new LearningCenterLoggingAspect();
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        return new DefaultPointcutAdvisor(customPointcut(), learningCenterLoggingAspect());
    }



}
