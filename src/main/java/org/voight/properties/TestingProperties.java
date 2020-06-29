package org.voight.properties;

import org.voight.exceptions.IVVRuntimeException;
import org.testng.log4testng.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class TestingProperties {
    private Properties properties = new Properties();
    private Logger log = Logger.getLogger(TestingProperties.class);

    public TestingProperties(Reader reader) throws IOException {
        properties.load(reader);
    }

    public TestingProperties() {
        try {
            Reader reader = new FileReader("src/main/resources/properties/testautomation.properties");
            properties.load(reader);
        } catch (IOException e) {
            log.fatal("src/main/resources/properties/testautomation.properties not found.", e);
            throw new IVVRuntimeException("Default Properties File not found. You must define a properties file.");
        }
    }

    public List<String> keys(String key) {
        ArrayList<String> returnKeys = new ArrayList<>();
        if ("".equals(key) || key == null) {
            return returnKeys;
        }
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String name = (String) propertyNames.nextElement();
            if (name.startsWith(key)) {
                returnKeys.add(name);
            }
        }
        return returnKeys;
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
