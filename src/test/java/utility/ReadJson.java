package utility;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadJson {

    static public User getUser(){

        ObjectMapper mapper=new ObjectMapper();
        try {
           return mapper.readValue(new FileInputStream("src/test/resources/users.json"),User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
