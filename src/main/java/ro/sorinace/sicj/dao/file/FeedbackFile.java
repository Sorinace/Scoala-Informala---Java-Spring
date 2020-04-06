package ro.sorinace.sicj.dao.file;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author Sorin
 * Reading data from a file, saved in JSON format
 * Connection with the feedback.json file
 */
@Configuration
public class FeedbackFile {

    /**
     * Load the feedback array from the file in an Array object in memory
     * @return ArrayList with all the feedback
     */
    @Bean
    public ArrayList<HashMap> getFeedbackFile() {
        return (ArrayList) ReadJson.readJson("src/main/webapp/resources/data/feedback.json");
    };

};
