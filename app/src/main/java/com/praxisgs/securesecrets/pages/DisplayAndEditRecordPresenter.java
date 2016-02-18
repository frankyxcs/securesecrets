package com.praxisgs.securesecrets.pages;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.praxisgs.securesecrets.base.BasePresenter;
import com.praxisgs.securesecrets.base.BaseRecordDetailsPresenter;

import java.util.ArrayList;
import java.util.List;

import eventbus.AppNavigationEvents;
import eventbus.SecureSecretsEventBus;
import model.RecordsEntity;
import model.SecureSecretsModel;
import utils.SecureSecretsModelUtils;

/**
 * Created on 04/02/2016.
 */
public class DisplayAndEditRecordPresenter extends BaseRecordDetailsPresenter {

    private DisplayAndEditRecordPresenter(ViewInterface viewInterface) {
        super(viewInterface);
    }

    public static DisplayAndEditRecordPresenter newInstance(ViewInterface viewInterface) {
        return new DisplayAndEditRecordPresenter(viewInterface);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public Context getAppContext() {
        return mView.getAppContext();
    }

    public RecordsEntity.Record getRecordDetails(int id) {
        return SecureSecretsModelUtils.getRecordDetailsForId(id);
    }

    @Override
    public void saveRecord(int id, String title, String username, String password, String categoryTitle, String website, String notes) {
        List<RecordsEntity.Record> records = SecureSecretsModel.getInstance().getRecordsEntity().getRecords();
        List<RecordsEntity.Record> resultRecords = new ArrayList<>();
        for(RecordsEntity.Record tempRecord: records){
            if(tempRecord.getId() == id){
                tempRecord.setTitle(title);
                tempRecord.setUserName(username);
                tempRecord.setPassword(password);
                tempRecord.getCategory().setTitle(categoryTitle);
                tempRecord.setWebsite(website);
                tempRecord.setNotes(notes);
            }
            resultRecords.add(tempRecord);
        }
        SecureSecretsModel.getInstance().getRecordsEntity().setRecords(resultRecords);
        SecureSecretsModel.getInstance().save();
        SecureSecretsEventBus.post(new AppNavigationEvents.EventShowPreviousPage());
    }


}
