import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {
    private static List<String[]> rawData = new ArrayList<>();
    private static List<String> handledData = new ArrayList<>();
    private final static String DATA_PATH = "C:\\Users\\quynhngo\\JavaAssignment\\src\\main\\DataCollection.csv";
    private final static String TARGET_PATH = "C:\\Users\\quynhngo\\JavaAssignment\\src\\main\\output.json";

    public static void readFile() {
        try {
            CSVReader reader = new CSVReader(new FileReader(DATA_PATH));
            rawData = reader.readAll();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    /*
    Get only BaseQuestion without duplicate data and ignore questions containing "smalltalk"
     */

    public static void dataHandling() {
        for (String[] row: rawData) {
            if (!handledData.contains(row[0]) && !row[0].equals("smalltalk") && !row[0].equals("BaseQuestion")) {
                handledData.add(row[0]);
            }
        }
    }

    /*
    Generate JSON file with data
     */

    public static void jsonFileCreating() {
        List<JSONObject> result = new ArrayList<>();
        for (int i = 0; i < handledData.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            String id = "REQ_" + String.format("%03d", i);
            String question = handledData.get(i);
            jsonArray.add(question);
            jsonObject.put("id", id);
            jsonObject.put("type", "REQUEST");
            jsonObject.put("name", id);
            jsonObject.put("question", jsonArray);
            result.add(jsonObject);
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(Paths.get(TARGET_PATH).toFile(), result);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        if (args[0] == "readfile" && args[1] == "jsongen") {
            readFile();
            dataHandling();
            jsonFileCreating();
        }
        else if (args[0] == "readfile") {
            readFile();
            dataHandling();
        }
        else if (args[0] == "jsongen") {
            jsonFileCreating();
        }
    }
}