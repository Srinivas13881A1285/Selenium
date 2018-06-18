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
                    ("src/main/resources/properties/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDriverPath(final String driverType) {
        return properties.getProperty(driverType);
    }
    
    public static String getTestDataFilePath(final String fileName) {
    	return properties.getProperty(fileName);
    }
    
}
