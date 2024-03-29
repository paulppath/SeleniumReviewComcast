package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader
{
    public static String readProperty(String filePath, String property)
    {
        Properties prop = null;
        try {
            FileInputStream fileInput = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fileInput);
        }catch(IOException e){
            e.printStackTrace();
        }
        return prop.getProperty(property);
    }
}
