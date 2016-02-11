package model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import utils.Constants;

/**
 * Created on 01/02/2016.
 */
public class SecureSecretsModel {
    private static SecureSecretsModel instance;

    private final Gson gson;
    private final Context context;

    @Expose
    private RecordsEntity recordsEntity;
    @Expose
    private PassCodeEntity passCodeEntity;

    private TestData testData = new TestData();

    public static void initialise(Context context) {
        if (instance == null) {
            instance = new SecureSecretsModel(context);
        }
        //This is only for test
        if(instance.getRecordsEntity() == null){
            instance.setRecordsEntity(instance.testData.getData());
            instance.save();
        }
    }

    public static SecureSecretsModel getInstance() {
        return instance;
    }

    private SecureSecretsModel(Context context) {
        this.context = context;
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        load();
    }

    public void save() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARE_PREF_NAME, Context.MODE_PRIVATE);
        String modelAsString = gson.toJson(instance);
        sharedPreferences.edit().putString(Constants.SHARE_PREF_NAME, modelAsString).apply();
    }

    private void load() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARE_PREF_NAME, Context.MODE_PRIVATE);
        String loadedModelString = sharedPreferences.getString(Constants.SHARE_PREF_NAME, null);
        setData(loadedModelString);
    }

    private void setData(String modelStr) {
        if (modelStr != null) {
            SecureSecretsModel model = gson.fromJson(modelStr, SecureSecretsModel.class);
            setRecordsEntity(model.getRecordsEntity());
            setPassCodeEntity(model.getPassCodeEntity());
        }
    }

    public void clearAndResetData() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARE_PREF_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    public void loadNewData(String modelStr) {
        if (modelStr != null) {
            setRecordsEntity(gson.fromJson(modelStr, RecordsEntity.class));
        }
    }


    public RecordsEntity getRecordsEntity() {
        return recordsEntity;
    }

    public void setRecordsEntity(RecordsEntity recordsEntity) {
        this.recordsEntity = recordsEntity;
    }

    public PassCodeEntity getPassCodeEntity() {
        return passCodeEntity;
    }

    public void setPassCodeEntity(PassCodeEntity passCodeEntity) {
        this.passCodeEntity = passCodeEntity;
    }

}
