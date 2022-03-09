package org.epam.logging.aopconfig;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Aspect
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Autowired
    private List<PackageProperties> packageProperties;

    @Pointcut("execution(* org.epam.operations.Operations.removeStudentFromList())")
    public void removeStudentPointcut() {

    }

    @After("removeStudentPointcut()")
    public void removeStudentLogger() {
        for (int i = 0; i < packageProperties.size(); i++) {
            if (packageProperties.get(i).getMethodName().equals("removeStudentFromList")) {
                log.info("Student deleted");
                break;
            }
        }
    }

    @Pointcut("execution(* org.epam.operations.Operations.addStudent())")
    public void addStudentPointcut() {

    }

    @After("addStudentPointcut()")
    public void addStudentLogger() {
        for (int i = 0; i < packageProperties.size(); i++) {
            if (packageProperties.get(i).getMethodName().equals("addStudent")) {
                log.info("Student added");
                break;
            }
        }
    }

    @Pointcut("execution(* org.epam.operations.Operations.filterStudents())")
    public void filterStudentsPointcut() {

    }

    @After("filterStudentsPointcut()")
    public void filterStudentLogger() {
        for (int i = 0; i < packageProperties.size(); i++) {
            if (packageProperties.get(i).getMethodName().equals("filterStudents")) {
                log.info("Students filtered");
                break;
            }
        }
    }
    @Pointcut("execution(* org.epam.operations.Operations.createReport())")
    public void reportStudentsPointcut() {

    }

    @After("reportStudentsPointcut()")
    public void reportStudentLogger() {
        for (int i = 0; i < packageProperties.size(); i++) {
            if (packageProperties.get(i).getMethodName().equals("createReport")) {
                log.info("Report created");
                break;
            }
        }
    }
}
