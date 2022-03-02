package org.epam.service;

import org.epam.entity.Student;
import org.epam.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @Override
    public Student findStudentById(int id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public void updateStudent(int index, Student student) {
        studentRepository.updateStudent(index, student);
    }

    @Override
    public List<Student> removeStudent(int id) {
        studentRepository.removeStudent(id);
        return studentRepository.getListOfStudents();
    }

    @Override
    public double calculateAvgGrade(Student student) {
        Map<String, Integer> marks = student.getMarks();
        double avgGrade = marks.values().stream().mapToDouble(d -> d).sum() / marks.size();
        return avgGrade;
    }

    @Override
    public List<Student> filterStudents() {
        return studentRepository.filterStudents();
    }

    @Override
    public List<Student> sortBy(Comparator<Student> comparator, List<Student> list) {
        return studentRepository.sortBy(comparator, list);
    }

    @Override
    public Map<Integer, Double> getGradesReport() {
        return studentRepository.getGradesReport();
    }

    @Override
    public List<Student> getListOfStudents() {
        return studentRepository.getListOfStudents();
    }
}
