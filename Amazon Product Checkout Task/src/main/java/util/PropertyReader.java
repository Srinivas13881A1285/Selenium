package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream
                    ("src/main/java/property/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(final String propertyName) {
        return properties.getProperty(propertyName);
    }
}
