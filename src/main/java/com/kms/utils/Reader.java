package com.kms.utils;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private static List<String[]> rawData = new ArrayList<>();
    public static void ReadCSV(String path) {
        try {
            CSVReader reader = new CSVReader(new FileReader(path));
            rawData = reader.readAll();
            reader.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public static List<String[]> getRawData() {
        return rawData;
    }
}
