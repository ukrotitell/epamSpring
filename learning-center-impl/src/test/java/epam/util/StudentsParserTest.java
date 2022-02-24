package epam.util;

import epam.Student;
import org.junit.jupiter.api.Test;
import org.epam.util.StudentsParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentsParserTest {

    @Test
    void shouldReadStudents(){
        String path = "src/test/resources/students.json";
        StudentsParser studentsParser = new StudentsParser();
        List<Student> students = studentsParser.readStudents(path);
        assertEquals(3, students.size());
    }
}