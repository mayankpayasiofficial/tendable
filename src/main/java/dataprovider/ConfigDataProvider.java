package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.IOException;


public class ConfigDataProvider {
    public static Properties property = loadProperties();

    public static Properties loadProperties() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("C:\\Users\\ayush\\Desktop\\project\\testsuite_tendable\\src\\test\\resources\\configuration\\config.properties")) 
        {
            prop.load(fis);
        } catch (IOException e) {
            System.err.println("Error while loading the configuration file:");
            e.printStackTrace();
            throw new RuntimeException("Exception occurred while loading the configuration file.", e);
        }
        return prop;
    }

    public static String getBrowser() {
        return property.getProperty("Browser");
    }

    public static String getTendableURL() {
        return property.getProperty("Tendable_url");
    }

    // You can add more getter methods for other properties as needed
}

