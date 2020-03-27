package ro.sorinace.sicj.dao.file;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Configuration
public class SpeakersFile {
    private HashMap fileRead = (HashMap)ReadJson.readJson("src/main/webapp/resources/data/speakers.json");

    @Bean
    public ArrayList<HashMap> getSpeakersFile() {
        return (ArrayList) fileRead.get("speakers");
    }

};
