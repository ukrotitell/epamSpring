package org.epam.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Aspect
public class LoggingAspect {
   Logger log = LoggerFactory.getLogger(LoggingAspect.class);
//
//    @Pointcut(value="execution(* org.epam.*.*.*(..) )")
//    public void myPointcut() {
//
//    }
//
//    @Around("myPointcut()")
//    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
//        ObjectMapper mapper = new ObjectMapper();
//        String methodName = pjp.getSignature().getName();
//        String className = pjp.getTarget().getClass().toString();
//        Object[] array = pjp.getArgs();
//        log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
//                + mapper.writeValueAsString(array));
//        Object object = pjp.proceed();
//        log.info(className + " : " + methodName + "()" + "Response : "
//                + mapper.writeValueAsString(object));
//        return object;
//    }
//
//    @After("execution(* org.epam.*.*.*(..) )")
//    public void logStringArguments(){
//        System.out.println("Running After Advice. String argument passed=");
//    }

    @After("execution(* org.epam.operations.Operations.removeStudentFromList() )")     //point-cut expression
    public void removeStudentLog()
    {
        log.info("Студент удален");
    }
}
