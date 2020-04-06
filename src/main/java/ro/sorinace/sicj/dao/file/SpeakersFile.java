package ro.sorinace.sicj.dao.file;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author Sorin
 * Reading data from a file, saved in JSON format
 * Connection with the speakers.json file
 */
@Configuration
public class SpeakersFile {
    private HashMap fileRead = (HashMap)ReadJson.readJson("src/main/webapp/resources/data/speakers.json");

    /**
     * Load the speakers array from the file in an Array object in memory
     * @return ArrayList with all the speakers
     */
    @Bean
    public ArrayList<HashMap> getSpeakersFile() {
        return (ArrayList) fileRead.get("speakers");
    }

};
