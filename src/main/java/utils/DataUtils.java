package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DataUtils {

    public static String loadProp(String property) throws IOException {

        String file = System.getProperty("user.dir") + "/src/main/resources/" + "api.properties";
            // Read file as input stream
            InputStream input = new FileInputStream(file);
            Properties prop = new Properties();
            //load a properties file from class path
            prop.load(input);
            //get the property value and return it in the below statement
        return prop.getProperty(property);
    }
}
