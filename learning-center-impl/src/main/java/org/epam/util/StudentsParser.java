package org.epam.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.epam.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StudentsParser {
    Logger log = LoggerFactory.getLogger(StudentsParser.class);

    public List<Student> readStudents(String path) {

        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = null;
        try {
            students = mapper.readValue(new File(path),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            log.error("Проблема с чтением студентов из файла");
            e.printStackTrace();
        }

        return students;
    }
}
