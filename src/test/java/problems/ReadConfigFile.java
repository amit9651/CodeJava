package problems;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {
    private static Properties properties = new Properties();
    public ReadConfigFile()
    {
        try {

            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/problems/Config.properties");
            properties.load(file);
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }


    }

    public   String getUrl(String fieldName){
        return properties.getProperty("appURL");
    }

    public  String email(String fieldName){
        return properties.getProperty("email");
    }

    public  String password(String fieldName){
        return properties.getProperty("password");
    }

    public  String productName(String fieldName){
        return properties.getProperty("searchProductName");
    }


}
