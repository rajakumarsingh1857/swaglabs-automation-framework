package com.swaglabs.utilities;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<TestDataModel> readTestData(String filePath) {
        List<TestDataModel> testDataList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord csvRecord : csvParser) {
                TestDataModel testData = new TestDataModel(
                    csvRecord.get("TC_ID"),
                    csvRecord.get("TC_Name"),
                    csvRecord.get("Username"),
                    csvRecord.get("Password"),
                    csvRecord.get("Action"),
                    csvRecord.get("Expected_Result"),
                    csvRecord.get("Scenario_Type")
                );
                testDataList.add(testData);
            }
            System.out.println("CSV file read successfully. Total records: " + testDataList.size());
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return testDataList;
    }

    public static List<TestDataModel> getFirstNTestCases(String filePath, int count) {
        List<TestDataModel> allData = readTestData(filePath);
        List<TestDataModel> limitedData = new ArrayList<>();
        for (int i = 0; i < Math.min(count, allData.size()); i++) {
            limitedData.add(allData.get(i));
        }
        System.out.println("Retrieved first " + limitedData.size() + " test cases");
        return limitedData;
    }
}