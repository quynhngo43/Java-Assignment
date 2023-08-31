package com.kms.functionals;

import com.kms.processings.FilterQuestions;
import com.kms.utils.Reader;
import com.kms.utils.JSONWriter;
import org.junit.Test;



public class FilterQuestionsTest {
    private final static String DATA_PATH = "src/test/resources/testdata/input/DataCollection.csv";
    private final static String TARGET_PATH = "src/test/resources/testdata/output/Output.json";
    @Test
    public void main() {

        Reader.ReadCSV(DATA_PATH);
        FilterQuestions.ProcessData();
        JSONWriter.CreateJSON(TARGET_PATH);
    }
}
