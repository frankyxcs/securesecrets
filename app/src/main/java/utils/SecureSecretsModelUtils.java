package utils;

import java.util.ArrayList;
import java.util.List;

import model.RecordsEntity;
import model.SecureSecretsModel;

/**
 * Created on 04/02/2016.
 */
public class SecureSecretsModelUtils {

    public static List<String> getCategories() {
        return getCategories(SecureSecretsModel.getInstance().getRecordsEntity());
    }

    private static List<String> getCategories(RecordsEntity recordsEntity) {
        List<String> categories = new ArrayList();
        if(recordsEntity !=null && recordsEntity.getRecords() !=null){
            List<RecordsEntity.Record> recordList = recordsEntity.getRecords();
            for (RecordsEntity.Record record : recordList) {
                String category = record.getCategory();
                if (!categories.contains(category))
                    categories.add(category);
            }
        }

        return categories;
    }
}
