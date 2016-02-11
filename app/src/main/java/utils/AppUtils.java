package utils;

import com.praxisgs.securesecrets.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.RecordsEntity;
import model.SecureSecretsModel;

/**
 * Created on 11/02/2016.
 */
public class AppUtils {

    public static int generateUniqueCategoryId(){
        List<BaseEntity> categories = SecureSecretsModelUtils.getCategories();
        List<Integer> categoriesIDs = new ArrayList();
        for(BaseEntity tempCategory:categories){
            categoriesIDs.add(tempCategory.getId());
        }

        return getRandomNumber(categoriesIDs);

    }

    public static int generateUniqueRecordId(){
        List<Integer> recordIDs = new ArrayList();
        for(RecordsEntity.Record tempRecord:SecureSecretsModel.getInstance().getRecordsEntity().getRecords()){
            recordIDs.add(tempRecord.getId());
        }
        return getRandomNumber(recordIDs);
    }





    private static int getRandomNumber(List<Integer> ids) {
        Random random  = new Random();
        int randomNumber = random.nextInt();
        while(ids.contains(randomNumber)){
            randomNumber =  random.nextInt();
        }
        return randomNumber;
    }
}
