package org.epam.util;

import org.epam.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//изменить название
public class WriterToFileInOneThread implements Runnable {
    Logger log = LoggerFactory.getLogger(WriterToFileInOneThread.class);
    private String path;
    private Student student;

    public WriterToFileInOneThread(Student student, String path) {
        this.student = student;
        this.path = path;
    }

    WriterToFile writer = new WriterToFile();

    @Override
    public void run() {
        log.info(Thread.currentThread().getName());
        writer.writeInfoToFile(path, student);
        try {
            log.info(Thread.currentThread().getName() + " спит");
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            log.error("Поток прерван");
            e.printStackTrace();
        }
    }
}

