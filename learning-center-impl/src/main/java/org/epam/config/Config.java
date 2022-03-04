package org.epam.config;

import org.epam.annotation.InjectRandomIntAnnotationBeanPostProcessor;
import org.epam.operations.Operations;
import org.epam.repository.IStudentRepository;
import org.epam.service.IStudentService;
import org.epam.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.epam.repository.StudentRepository;
import org.epam.service.StudentService;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class Config {

    @Bean
    public ProgramsParser programsParser() {
        return new ProgramsParser();
    }
    @Bean
    public ConsoleOperations consoleOperations() {
        return new ConsoleOperations();
    }
    @Bean
    public Comparators comparators() {
        return new Comparators();
    }
    @Bean
    public StudentsParser studentsFile() {
        return new StudentsParser();
    }
    @Bean
    public StudentsWriter studentsWriter() {
        return new StudentsWriter();
    }
    @Bean
    public IStudentRepository studentRepository() {
        return new StudentRepository(studentsFile());
    }
    @Bean
    public IStudentService studentService() {
        return new StudentService(studentRepository());
    }
    @Bean
    public Operations operations() {
        return new Operations(studentService());
    }



    @Bean
    public InjectRandomIntAnnotationBeanPostProcessor injectRandomIntAnnotationBeanPostProcessor() {
        return new InjectRandomIntAnnotationBeanPostProcessor();
    }
}
