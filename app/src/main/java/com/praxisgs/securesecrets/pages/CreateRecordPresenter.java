package com.praxisgs.securesecrets.pages;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.praxisgs.securesecrets.base.BaseEntity;
import com.praxisgs.securesecrets.base.BaseRecordDetailsPresenter;

import java.util.List;

import eventbus.AppNavigationEvents;
import eventbus.SecureSecretsEventBus;
import model.RecordsEntity;
import model.SecureSecretsModel;
import utils.AppUtils;
import utils.SecureSecretsModelUtils;

/**
 * Created on 04/02/2016.
 */
public class CreateRecordPresenter extends BaseRecordDetailsPresenter {
//    private ViewInterface mView;

    private CreateRecordPresenter(ViewInterface viewInterface) {
        super(viewInterface);
    }

    public static CreateRecordPresenter newInstance(ViewInterface viewInterface) {
        return new CreateRecordPresenter(viewInterface);
    }


//
//
//    public interface ViewInterface {
//        Context getAppContext();
//    }

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
        //This is required only for the first time
        //TODO do it properly
        if (SecureSecretsModel.getInstance().getRecordsEntity() == null) {
            SecureSecretsModel.getInstance().setRecordsEntity(new RecordsEntity());
        }
        List<RecordsEntity.Record> records = SecureSecretsModel.getInstance().getRecordsEntity().getRecords();
        RecordsEntity.Record newRecord = new RecordsEntity.Record();
        newRecord.setId(AppUtils.generateUniqueRecordId());
        newRecord.setTitle(title);
        newRecord.setUserName(username);
        newRecord.setPassword(password);
        BaseEntity category = SecureSecretsModelUtils.getCategoryDetails(categoryTitle);
        RecordsEntity.Category tempCategory = new RecordsEntity.Category();
        if (category == null) {
            tempCategory.setId(AppUtils.generateUniqueCategoryId());
            tempCategory.setTitle(categoryTitle);
        } else {
            tempCategory.setId(category.getId());
            tempCategory.setTitle(category.getTitle());
        }
        newRecord.setCategory(tempCategory);
        newRecord.setWebsite(website);
        newRecord.setNotes(notes);
        records.add(newRecord);
        SecureSecretsModel.getInstance().getRecordsEntity().setRecords(records);
        SecureSecretsModel.getInstance().save();
        SecureSecretsEventBus.post(new AppNavigationEvents.EventShowPreviousPage());
    }


}
