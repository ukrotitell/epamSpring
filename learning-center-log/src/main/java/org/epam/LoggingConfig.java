package org.epam;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
public class LoggingConfig {


    @Pointcut(value = "execution(* org.epam.operations.Operations.removeStudentFromList(..) )")
    public void pointcutRemoveStudent() {

    }

    @Pointcut(value = "execution(* org.epam.operations.Operations.addStudent(..) )")
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
