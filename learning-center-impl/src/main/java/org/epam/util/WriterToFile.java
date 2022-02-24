package org.epam.util;

import epam.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class WriterToFile {
    Logger log = LoggerFactory.getLogger(WriterToFile.class);
    public void writeInfoToFile(String path, Student student) {
        try (OutputStreamWriter writer =
                     new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8)) {

            writer.write(student + "\n");
        } catch (IOException e) {
            log.error("Проблемы с записью в файл");
            e.printStackTrace();
        }

    }
}
