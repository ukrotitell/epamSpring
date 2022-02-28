package org.epam.util;


import org.epam.entity.Student;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentsWriter {

    ClearFile clearFile = new ClearFile();

    ExecutorService service = Executors.newCachedThreadPool();

    public void writeInFile(String path, List<Student> studentList) {
        clearFile.clearFile(path);
        studentList.forEach(student -> service.submit(new WriterToFileInOneThread(student, path)));
        service.shutdown();
    }
}
































