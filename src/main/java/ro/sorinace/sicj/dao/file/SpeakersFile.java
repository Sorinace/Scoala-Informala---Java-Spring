package ro.sorinace.sicj.dao.file;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

@Configuration
public class SpeakersFile {
    private HashMap fileRead = (HashMap)ReadJson.readJson("src/main/webapp/resources/data/speakers.json");

    @Bean
    public ArrayList<HashMap> getSpeakers() {
        return (ArrayList) fileRead.get("speakers");
    }

};
