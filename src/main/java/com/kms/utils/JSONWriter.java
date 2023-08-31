package com.kms.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kms.objects.Questions;
import com.kms.processings.FilterQuestions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONWriter {
    private static List<String> processedData = FilterQuestions.getProcessedData();

    public static void CreateJSON(String targetPath) {
        List<Questions> result = new ArrayList<>();
        for (int i = 0; i < processedData.size(); i++) {
            Questions questionsObject = new Questions();
            String id = "REQ_" + String.format("%03d", i+1);
            List<String> question = new ArrayList<>();
            question.add(processedData.get(i));
            questionsObject.setId(id);
            questionsObject.setType("REQUEST");
            questionsObject.setName(id);
            questionsObject.setQuestion(question);
            result.add(questionsObject);
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(Paths.get(targetPath).toFile(), result);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
