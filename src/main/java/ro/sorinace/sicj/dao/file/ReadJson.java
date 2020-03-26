package ro.sorinace.sicj.dao.file;

import org.apache.tomcat.util.json.JSONParser;

import java.io.FileReader;

public class ReadJson {
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
