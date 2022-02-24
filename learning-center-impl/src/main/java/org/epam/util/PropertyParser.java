package org.epam.util;


import com.sun.tools.javac.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class PropertyParser {
    Logger log = LoggerFactory.getLogger(PropertyParser.class);
    public String getPropertyVariable() {
        Properties prop = new Properties();
        {
            try {
                //load a properties file from class path, inside static method
                prop.load(Main.class.getClassLoader().getResourceAsStream("properties.properties"));
            } catch (IOException ex) {
                log.error("Файл с properties не был найден");
                ex.printStackTrace();
            }
        }
        return prop.getProperty("properties");
    }
}
