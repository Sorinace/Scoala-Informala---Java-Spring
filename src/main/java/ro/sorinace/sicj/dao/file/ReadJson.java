package ro.sorinace.sicj.dao.file;

import org.apache.tomcat.util.json.JSONParser;

import java.io.FileReader;

/**
 * @Author Sorin
 * Parse the data from file in JSON format
 */
public class ReadJson {
    /**
     * Read the file name 'filename' and return the JSON object from it
     * @param filename the name of the file to be read
     * @return the JSON object for the file
     */
    public static Object readJson(String filename)  {
        try {
            FileReader reader = new FileReader(filename);
            JSONParser jsonParser = new JSONParser(reader);
            return jsonParser.parse();
        } catch (Exception ex){
            return ex;
        }
    };
}
