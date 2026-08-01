package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private static final String CONFIG_PATH = "src/test/resources/config.properties";

    // Static block loads the file once when class is first used
    static {
        try {
            FileInputStream fis = new FileInputStream(CONFIG_PATH);
            properties = new Properties();
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException("config.properties not found at " + CONFIG_PATH, e);
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public static int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("implicitWait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("explicitWait"));
    }

    public static String getEnvironment() {
        return properties.getProperty("environment");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

    // Generic getter for any future key without needing a new method each time
    public static String get(String key) {
        return properties.getProperty(key);
    }
}