package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    static Properties properties;

    public  static Properties getProperties(){
        if(properties==null)
        {
            properties=new Properties();
            try {
                properties.load(new FileInputStream("src/test/resources/config.properties"));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return properties;
    }
}
