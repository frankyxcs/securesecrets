package utils;

import model.BaseEntity;

import java.util.ArrayList;
import java.util.List;

import model.RecordsEntity;
import model.SecureSecretsModel;

/**
 * Created on 04/02/2016.
 */
public class SecureSecretsModelUtils {

    public static List<BaseEntity> getCategories() {
        return getCategories(SecureSecretsModel.getInstance().getRecordsEntity());
    }

    public static List<BaseEntity> getCategories(RecordsEntity recordsEntity) {
        List<BaseEntity> categories = new ArrayList();
        if(recordsEntity !=null && recordsEntity.getRecords() !=null){
            List<RecordsEntity.Record> recordList = recordsEntity.getRecords();
            for (RecordsEntity.Record record : recordList) {
                RecordsEntity.Category category = record.getCategory();
                if (!categories.contains(category))
                    categories.add(category);
            }
        }

        return categories;
    }

    public static List<BaseEntity> getRecordsForCategoryId(int id) {
        return getRecordsForCategoryId(SecureSecretsModel.getInstance().getRecordsEntity(),id);
    }

    public static List<BaseEntity> getRecordsForCategoryId(RecordsEntity recordsEntity, int id) {
        List<BaseEntity> records = new ArrayList();
        if(recordsEntity !=null && recordsEntity.getRecords() !=null){
            List<RecordsEntity.Record> recordList = recordsEntity.getRecords();
            for (RecordsEntity.Record record: recordList){
                int recordCategoryId = record.getCategory().getId();
                if (recordCategoryId == id)
                    records.add(record);
            }
        }
        return records;
    }

    public static RecordsEntity.Record getRecordDetailsForId(int id) {
        return getRecordDetailsForId(SecureSecretsModel.getInstance().getRecordsEntity(),id);
    }

    public static RecordsEntity.Record getRecordDetailsForId(RecordsEntity recordsEntity, int id) {
        if(recordsEntity == null){
            return null;
        }
        for(RecordsEntity.Record record:recordsEntity.getRecords()){
         if(record.getId() == id)
             return record;
        }
        return null;
    }

    public static BaseEntity getCategoryDetails(String categoryTitle) {
        List<BaseEntity> categories = SecureSecretsModelUtils.getCategories();
        for(BaseEntity tempCategory:categories){
            if(tempCategory.getTitle().equalsIgnoreCase(categoryTitle)){
                return tempCategory;
            }
        }
        return null;
    }
}
