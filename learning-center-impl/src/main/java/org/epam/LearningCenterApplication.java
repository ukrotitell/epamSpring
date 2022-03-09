package org.epam;

import org.epam.aopconfig.AspectConfiguration;
import org.epam.aopconfig.ConfigProperties;
import org.epam.aopconfig.PackageProperties;
import org.epam.config.Config;
import org.epam.operations.Operations;
import org.epam.testbean.TestStudent;
import org.epam.util.ConsoleOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class LearningCenterApplication implements CommandLineRunner {

    @Autowired
    ApplicationContextProvider applicationContextProvider;



    public static void main(String[] args) {
        SpringApplication.run(LearningCenterApplication.class, args);
    }

    @Override
    public void run(String...args) throws Exception {
        TestStudent testStudent = applicationContextProvider.getApplicationContext().getBean(TestStudent.class);
        System.out.println(testStudent.getMarks());

        Operations operations = applicationContextProvider.getApplicationContext().getBean(Operations.class);
        ConsoleOperations consoleOperations = applicationContextProvider.getApplicationContext().getBean(ConsoleOperations.class);
        do {
            System.out.println("Выберите операцию:");
            System.out.println("1 - добавить студента!");
            System.out.println("2 - исключить студента");
            System.out.println("3 - поставить оценку за тест по теме");
            System.out.println("4 - рассчитать количество дней до завершения программы");
            System.out.println("5 - рассчитать и вывести отчет об успеваемости");
            System.out.println("6 - рассчитать возможность отчисления студента");
            System.out.println("7 - просмотреть список всех студентов");
            System.out.println("8 - фильтровать список студентов по условию «Есть вероятность, что не будет отчислен»");
            System.out.println("9 - сформировать общий отчет о студентах в .txt файле");

            int number = consoleOperations.readIntFromConsole();
            if (number==1){
                operations.addStudent();
            }
            if (number==2){
                operations.removeStudentFromList();
            }
            if (number==3){
                operations.setMark();
            }
            if (number==4){
                operations.countNumberOfDays();
            }
            if (number==5){
                operations.getGradesReport();
            }
            if (number==6){
                operations.checkGradesAchievement();
            }
            if (number==7){
                operations.sortStudents();
            }
            if (number==8){
                operations.filterStudents();
            }
            if (number==9){
                operations.createReport();
            }
        } while (!consoleOperations.readStringFromConsole().equals("exit"));
    }
}