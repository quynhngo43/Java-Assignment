package com.kms.processings;

import com.kms.utils.Reader;

import java.util.ArrayList;
import java.util.List;

public class FilterQuestions {
    private static List<String[]> rawData = Reader.getRawData();
    private static List<String> processedData = new ArrayList<>();
    public static void ProcessData() {
        for (String[] row: rawData) {
            if (!processedData.contains(row[0]) && !row[0].equals("smalltalk") && !row[0].equals("BaseQuestion")) {
                processedData.add(row[0]);
            }
        }
    }
    public static List<String> getProcessedData() {
        return processedData;
    }
}
