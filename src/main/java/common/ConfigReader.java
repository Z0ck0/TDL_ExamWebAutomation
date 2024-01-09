package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    /**
     * The ConfigReader class encapsulates variables and methods for reading properties from a
     * configuration file named "configuration.properties". The use of ThreadLocal<Properties> suggests
     * that the class handles configuration properties in a thread-safe manner, allowing different threads
     * to access and manipulate their own instances of the Properties class.
     */


    // ThreadLocal variable to store Properties instances for thread safety.
    public static ThreadLocal<Properties> properties = new ThreadLocal<>();


    // File path for the configuration properties file.
    private static final String PATH =
            "src" + File.separator +
                    "main" + File.separator +
                    "resources" + File.separator +
                    "configs/configuration.properties";


    // Retrieves Properties from the configuration file. Return Properties instance containing configuration properties.
    public static Properties getPropertiesFromFile() {
        Properties prop = new Properties();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(PATH));
            try {
                prop.load(reader);
                reader.close();
            } catch (Exception ex) {
                System.out.println("Couldn't read configuration file ");
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            System.out.println("Couldn't find configuration file");
        }
        return prop;
    }


    // Sets the ThreadLocal variable (properties) with Properties obtained from the file.
    public static void setProperties() {
        properties.set(getPropertiesFromFile());
    }


    // Retrieves Properties from the ThreadLocal. If not set, it calls setProperties to set it first.
    // Return Properties instance containing configuration properties.
    public static Properties getProperties() {
        if (properties.get() == null) setProperties();
        return properties.get();
    }


    public String getDemoQaUrl() {
        return getProperty("demo.qa.url");
    }

    public String getDemoQaBooksUrl() {
        return getProperty("demo.qa.books.url");
    }

    public String getDemoQaPracticeFormUrl() {
        return getProperty("demo.qa.practice.form.url");
    }


    public String getFirstName(){
        return getProperty("firstName");}
    public String getLastName(){
        return getProperty("lastName");}
    public String getEmail(){
        return getProperty("email");}
    public String getMobile(){
        return getProperty("mobile");}
    public String getCurrentAddress(){
        return getProperty("current.address");}


  /*   Helper method: Retrieves the value of a specified property key.
     Throws a RuntimeException if the property is not found.*/
    private String getProperty( String key ) {
        String prop = getProperties().getProperty(key);
        if (prop != null) return prop;
        else throw new RuntimeException(key + " not specified in configuration.properties file");
    }
}