package org.epam.logging.aop;

import org.epam.logging.aopconfig.PackageProperties;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.List;
public class CustomPointcut extends DynamicMethodMatcherPointcut {

    @Autowired
    private List<PackageProperties> packageProperties;

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        for (int i = 0; i < packageProperties.size(); i++) {
            if (method.getName().equals(packageProperties.get(i).getMethodName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ClassFilter getClassFilter() {
        return clazz -> {
            for (int i = 0; i < packageProperties.size(); i++) {
                if (clazz.getPackage().getName().contains(packageProperties.get(i).getPackageName())){
                    return true;
                }
            }
            return false;
        };
    }
}
