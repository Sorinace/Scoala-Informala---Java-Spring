package ro.sorinace.sicj.dao.file;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;

@Configuration
public class FeedbackFile {

    @Bean
    public ArrayList<HashMap> getFeedbackFile() {
        return (ArrayList) ReadJson.readJson("src/main/webapp/resources/data/feedback.json");
    };

};
