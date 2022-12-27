package utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class ConfigManager {
    private static ConfigManager manager = null;
    private String host;
    Properties properties;

    private ConfigManager() {
        //TODO pending review, some issues where found after read the file .properties
        properties = new Properties();
        String nameFile = "reqres.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);

        if (inputStream != null) {
            try {
                properties.load(inputStream);
                host = properties.getProperty("host");
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public static ConfigManager getInstance() {
        if (manager == null)
            manager = new ConfigManager();
        return manager;
    }

    public String getHost() {
        return host;
    }

    public String getProperty(String propertyName) {

        Object value = properties.get(propertyName);
        if (value != null) {
            return properties.get(propertyName).toString();
        } else {
            String errorLog = MessageFormat.format("Error occurred while getting {0} Property from MlsTestProperties. This could be due to no such property available in MlsTestProperties.properties file.", propertyName);
        }
        return "test";
    }
}
