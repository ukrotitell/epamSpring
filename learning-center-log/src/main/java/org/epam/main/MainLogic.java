package org.epam.main;

import org.epam.config.Config;
import org.epam.exception.IllegalInitialDataException;
import org.epam.operations.Operations;
import org.epam.util.ConsoleOperations;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
@Component
public class MainLogic implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        main(args);
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        Operations operations = context.getBean(Operations.class);
        ConsoleOperations consoleOperations = context.getBean(ConsoleOperations.class);
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