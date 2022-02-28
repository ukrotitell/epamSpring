package org.epam.util;

import org.epam.entity.Program;
import org.epam.exception.IllegalInitialDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ProgramsParser {
    PropertyParser propertyParser = new PropertyParser();
    String property = propertyParser.getPropertyVariable();
    String path = "src/main/resources/" + property;
    Logger log = LoggerFactory.getLogger(ProgramsParser.class);
    public List<Program> getListOfPrograms() throws FileNotFoundException, IllegalInitialDataException {
        List<Program> programList = new ArrayList<>();
        InputStream inputStream = new FileInputStream(path);
        Yaml yaml = new Yaml(new Constructor(Program.class));
        try {
            for (Object object : yaml.loadAll(inputStream)) {
                Program program = (Program) object;
                programList.add(program);
            }
        } catch (Exception e) {
            log.error("При загрузке программ из файла произошла ошибка");
            throw (new IllegalInitialDataException("Произошла ошибка. Проверьте исходные данные.\n" + e.getCause()));
        }
        return programList;
    }
}
