package Lesson2.Task1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;


public class Parser {
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        Formatter str = new Formatter();
        StringBuffer result = new StringBuffer();
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(
                "src/main/java/Lesson2/Task1/data.json"));

        for (Object item : jsonArray) {
            JSONObject person = (JSONObject) item;

            String surname = (String) person.get("фамилия");
            String subject= (String) person.get("предмет");
            String grate = (String) person.get("оценка");
            if (surname != null || subject != null || grate != null) {
                result.append("Студент " + surname + " получил" + " " + grate +  " по предмету " + subject + "\n");
            }
        }
        System.out.println(result);

    }
}