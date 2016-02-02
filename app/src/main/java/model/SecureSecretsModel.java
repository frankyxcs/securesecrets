package model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import utils.Constants;

/**
 * Created by British Gas on 01/02/2016.
 */
public class SecureSecretsModel {
    private static SecureSecretsModel instance;

    private final Gson gson;
    private final Context context;

    @Expose
    private Records records;
    @Expose
    private Passcode passcode;

    public static void initialise(Context context) {
        if (instance == null)
            instance = new SecureSecretsModel(context);
    }

    public static SecureSecretsModel getInstance() {
        return instance;
    }

    private SecureSecretsModel(Context context) {
        this.context = context;
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        load();
    }

    private void save() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARE_PREF_NAME, Context.MODE_PRIVATE);
        String modelAsString = gson.toJson(instance);
        sharedPreferences.edit().putString(Constants.SHARE_PREF_NAME, modelAsString).apply();
    }

    private void load() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARE_PREF_NAME, Context.MODE_PRIVATE);
        String loadedModelString = sharedPreferences.getString(Constants.SHARE_PREF_NAME, null);
        setData(loadedModelString);
    }

    private void setData(String model) {
        if (model != null) {

        }
    }

    public static void loadNewData(String model) {
        if (model != null) {
            loadNewData(model);
        }
    }

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }

    public Passcode getPasscode() {
        return passcode;
    }

    public void setPasscode(Passcode passcode) {
        this.passcode = passcode;
    }
}
