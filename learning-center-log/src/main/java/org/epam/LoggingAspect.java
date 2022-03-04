package org.epam;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Aspect
public class LoggingAspect {
    private Logger log = LoggerFactory.getLogger(this.getClass());



    @After("org.epam.LoggingConfig.pointcutRemoveStudent()")
    public void removeStudentLog() {
        log.info("Студент удален");
    }

    @After("org.epam.LoggingConfig.pointcutAddStudent()")
    public void addStudentLog() {
        log.info("Студент добавлен");
    }

    @After("org.epam.LoggingConfig.pointcutSetMark()")
    public void setMarkLog() {
        log.info("Оценка успешно изменена");
    }

    @After("org.epam.LoggingConfig.pointcutFilterStudents()")
    public void filterStudentsLog() {
        log.info("Студенты отфильтрованы");
    }

    @After("org.epam.LoggingConfig.pointcutCreateReport()")
    public void createReportLog() {
        log.info("Отчет создан");
    }

    @After("org.epam.LoggingConfig.pointcutSortStudents()")
    public void sortStudentsLog() {
        log.info("Отчет создан");
    }
}
