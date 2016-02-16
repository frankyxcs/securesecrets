package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 02/02/2016.
 */
public class TestData {
    private RecordsEntity data;

    public TestData() {
        createData();
    }

    private void createData() {
        List<RecordsEntity.Record> recordList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            RecordsEntity.Record tempRecord = new RecordsEntity.Record();
            tempRecord.setId(i);
            tempRecord.setTitle("Title " + i);
            tempRecord.setUserName("Username " + i);
            tempRecord.setPassword("Password " + i);
            tempRecord.setWebsite("Website " + i);
            RecordsEntity.Category category = new RecordsEntity.Category();
            if (i <= 5) {
                category.setTitle("category 1");
                category.setId(1);
            } else {
                category.setTitle("category 2");
                category.setId(2);
            }
            tempRecord.setCategory(category);
            List<RecordsEntity.AdditionalRecord> addtionalRecordList = new ArrayList<>();

            for (int j = 1; j < 3; j++) {
                RecordsEntity.AdditionalRecord tempAdditionalRecord = new RecordsEntity.AdditionalRecord();
                tempAdditionalRecord.setTitle("Addtional Info: " + j);
                tempAdditionalRecord.setAdditionalRecordPassword("Addtional Password: " + j);
                addtionalRecordList.add(tempAdditionalRecord);
            }

            tempRecord.setAdditionalRecordList(addtionalRecordList);
            recordList.add(tempRecord);
        }
        data = new RecordsEntity();
        data.setRecords(recordList);

    }

    public RecordsEntity getData() {
        return data;
    }
}
