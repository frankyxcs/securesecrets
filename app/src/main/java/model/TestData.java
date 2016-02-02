package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 02/02/2016.
 */
public class TestData {
    private Records data;

    public TestData() {
        createData();
    }

    private void createData() {
        List<Records.Record> recordList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Records.Record tempRecord = new Records.Record();
            tempRecord.setTitle("Title " + i);
            tempRecord.setUserName("Username " + i);
            tempRecord.setPassword("Password " + i);
            tempRecord.setWebsite("Website " + i);
            if (i <= 5)
                tempRecord.setCategory("category 1");
            else
                tempRecord.setCategory("category 2");
            List<Records.AdditionalRecord> addtionalRecordList = new ArrayList<>();

            for(int j=1;j<3;j++){
                Records.AdditionalRecord tempAdditionalRecord = new Records.AdditionalRecord();
                tempAdditionalRecord.setAddtionalRecordTitle("Addtional Info: "+j);
                tempAdditionalRecord.setAdddtionalRecordPassword("Addtional Password: " + j);
                addtionalRecordList.add(tempAdditionalRecord);
            }

            tempRecord.setAdditionalRecordList(addtionalRecordList);
            recordList.add(tempRecord);
        }
        data.setRecords(recordList);

    }

    public Records getData() {
        return data;
    }
}
