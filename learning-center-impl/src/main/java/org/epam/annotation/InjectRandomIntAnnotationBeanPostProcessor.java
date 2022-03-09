package org.epam.annotation;

import org.aspectj.weaver.ast.Test;
import org.epam.testbean.TestStudent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields
        ) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                List<Integer> listOfMarks = new ArrayList<>();
                TestStudent testStudent =(TestStudent) bean;
                for (int j = 0; j < 3; j++) {
                    listOfMarks.add(min + random.nextInt(max - min));
                }
                testStudent.setMarks(listOfMarks);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, listOfMarks);
            }
        }

        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
