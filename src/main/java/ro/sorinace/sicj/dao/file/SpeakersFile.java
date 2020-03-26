package ro.sorinace.sicj.dao.file;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

@Configuration
public class SpeakersFile {
    private HashMap fileRead = (HashMap)readJson("src/main/webapp/resources/data/speakers.json");

    @Bean
    public ArrayList<HashMap> getSpeakers() {
        return (ArrayList) fileRead.get("speakers");
    }

    public static Object readJson(String filename)  {
        try {
            FileReader reader = new FileReader(filename);
            JSONParser jsonParser = new JSONParser(reader);
            return jsonParser.parse();
        } catch (Exception ex){
            return ex;
        }
    };
};
