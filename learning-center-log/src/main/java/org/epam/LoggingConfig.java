package org.epam;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class LoggingConfig {


    @Pointcut(value = "execution(public PackageLogger org.epam.BeanConfig.packageLoggerRemove())")
    public void pointcutRemoveStudent() {

    }

    @Pointcut(value = "execution(public PackageLogger org.epam.BeanConfig.packageLoggerAdd())")
    public void pointcutAddStudent() {

    }

    @Pointcut(value = "execution(* org.epam.operations.Operations.setMark() )")
    public void pointcutSetMark() {

    }

    @Pointcut(value = "execution(* org.epam.operations.Operations.filterStudents() )")
    public void pointcutFilterStudents() {

    }

    @Pointcut(value = "execution(* org.epam.operations.Operations.createReport() )")
    public void pointcutCreateReport() {

    }

    @Pointcut(value = "execution(* org.epam.operations.Operations.sortStudents() )")
    public void pointcutSortStudents() {

    }

}
