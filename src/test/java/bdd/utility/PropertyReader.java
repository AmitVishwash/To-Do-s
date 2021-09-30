package bdd.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyReader {
    static Properties properties = new Properties();

    public PropertyReader()
    {
        try {
            InputStreamReader file = new InputStreamReader(new FileInputStream("src/main/resources/config.properties"));
            properties.load(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static String getPropertyValue(String propertyName)
    {
        return properties.getProperty(propertyName);

    }
}
