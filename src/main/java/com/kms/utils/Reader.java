package com.kms.utils;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static List<String[]> rawData = new ArrayList<>();
    public static void ReaderCSV(String path) {
        try {
            com.opencsv.CSVReader reader = new com.opencsv.CSVReader(new FileReader(path));
            rawData = reader.readAll();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public static List<String[]> getRawData() {
        return rawData;
    }
}
