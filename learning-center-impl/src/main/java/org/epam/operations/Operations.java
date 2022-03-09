package org.epam.operations;


import org.epam.aopconfig.PackageProperties;
import org.epam.entity.Program;
import org.epam.entity.Student;
import org.epam.entity.Module;
import org.epam.exception.IllegalInitialDataException;
import org.epam.service.IStudentService;
import org.epam.service.StudentService;
import org.epam.util.ConsoleOperations;
import org.epam.util.ProgramsParser;
import org.epam.util.StudentsWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.epam.util.Comparators;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Operations {
    @Autowired
    private List<PackageProperties> packageProperties;

    @Autowired
    private ProgramsParser programsFile;
    @Autowired
    private ConsoleOperations consoleOperations;
    @Autowired
    private StudentService studentService;
    @Autowired
    private Comparators comparators;
    @Autowired
    StudentsWriter studentsWriter;
    String path = "src/main/resources/studentsReport";

    public Operations(StudentService studentService) {
        this.studentService = studentService;
    }

    public void removeStudentFromList() {
        System.out.println("Введите id студента, которого удалить");
        int id = consoleOperations.readIntFromConsole();
        studentService.removeStudent(id);
    }

    public void addStudent() {
        System.out.println("Введите id");
        int id = consoleOperations.readIntFromConsole();
        System.out.println("Введите имя");
        String name = consoleOperations.readStringFromConsole();
        System.out.println("Выберите программу 1 или 2");
        int programId = consoleOperations.readIntFromConsole();
        Student student = new Student(id, name, programId, Map.of(), 0.0);
        studentService.addStudent(student);
    }

    public void setMark() throws FileNotFoundException, IllegalInitialDataException {
        System.out.println("Введите студента, которому заменить оценку");
        int studentId = consoleOperations.readIntFromConsole();
        Student student = studentService.findStudentById(studentId);
        System.out.println("Введите id модуля");
        int moduleId = consoleOperations.readIntFromConsole();
        System.out.println("Введите оценку");
        int mark = consoleOperations.readIntFromConsole();

        List<Program> programs = programsFile.getListOfPrograms();

        Program program = programs.stream().filter(p -> p.getId() == student.getProgramId()).findFirst().get();
        for (int i = 0; i < program.getModules().size(); i++) {
            if (moduleId == program.getModules().get(i).getId()) {
                student.getMarks().put(program.getModules().get(i).getName(), mark);
            }
        }
        double avgGrade = 0;
        Map<String, Integer> marks = student.getMarks();
        for (Map.Entry<String, Integer> pair : marks.entrySet()) {
            avgGrade += pair.getValue();
        }
        student.setAvgGrade(avgGrade / marks.size());
        int index = studentService.getListOfStudents().indexOf(student);
        studentService.updateStudent(index, student);
    }


    public void countNumberOfDays() throws Exception {
        System.out.println("Введите id студента");
        int studentId = consoleOperations.readIntFromConsole();
        Student student = studentService.findStudentById(studentId);
        List<Program> programs = programsFile.getListOfPrograms();

        Program program = programs.stream().filter(p -> p.getId() == student.getProgramId()).findFirst().get();
        int duration = 0;
        System.out.println("Сколько прошло времени с начала программы?");
        int currentDuration = consoleOperations.readIntFromConsole();
        for (Module module : program.getModules()) {
            duration += module.getDuration();
        }

        int daysLeft = (int) Math.ceil((duration - currentDuration) / 24.0);
        if (daysLeft == 0) {
            System.out.println("Программа уже завершена");
        } else {
            System.out.println("Осталось " + daysLeft + " дней");
        }
    }

    public void checkGradesAchievement() {
        System.out.println("Введите id студента");
        int id = consoleOperations.readIntFromConsole();
        Student student = studentService.findStudentById(id);
        double avgGrade = studentService.calculateAvgGrade(student);

        if (avgGrade < 75) {
            System.out.println("Студент " + student.getName() + " со средним баллом - " + avgGrade + " не проходит");

        } else {
            System.out.println("Студент " + student.getName() + " со средним баллом - " + avgGrade + " проходит");
        }
    }

    public void filterStudents() {
        System.out.println("Средняя оценка выше 75:");
        for (Student student :
                studentService.filterStudents()) {
            System.out.println(student);
        }
    }

    public void createReport() {
        studentsWriter.writeInFile(path, studentService.getListOfStudents());
    }

    public void getGradesReport() {
        Map<Integer, Double> mapGradesReport = studentService.getGradesReport();
        for (Map.Entry<Integer, Double> pair : mapGradesReport.entrySet()) {
            Student student = studentService.findStudentById(pair.getKey());
            System.out.println(String.format("Name is: %s, average grade is : %s", student.getName(), pair.getValue()));
        }
    }

    public void sortStudents() {
        System.out.println("1 - Сортировка по имени\n2 - Сортировка по оценкам");
        List<Student> studentList;
        int number = consoleOperations.readIntFromConsole();
        if (number == 1) {
            studentList = studentService.sortBy(comparators.getSortByName(), studentService.getListOfStudents());
        } else {
            studentList = studentService.sortBy(comparators.getSortByAvgGrade(), studentService.getListOfStudents());
        }
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
    }
}
