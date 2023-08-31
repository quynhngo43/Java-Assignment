package com.kms.functionals;

import com.kms.processings.FilterQuestions;
import com.kms.utils.Reader;
import com.kms.utils.JSONWriter;
import org.junit.Test;



public class FilterQuestionsTest {
    @Test
    public void main() {
        final String DATA_PATH = "src/test/resources/testdata/input/DataCollection.csv";
        final String TARGET_PATH = "src/test/resources/testdata/output/Output.json";

        Reader.ReadCSV(DATA_PATH);
        FilterQuestions.ProcessData();
        JSONWriter.CreateJSON(TARGET_PATH);
    }
}
