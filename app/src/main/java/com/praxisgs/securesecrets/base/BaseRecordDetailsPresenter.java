package com.praxisgs.securesecrets.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import model.RecordsEntity;
import model.SecureSecretsModel;
import utils.SecureSecretsModelUtils;

/**
 * Created on 04/02/2016.
 */
public abstract class BaseRecordDetailsPresenter implements BasePresenter {
    protected ViewInterface mView;

    protected BaseRecordDetailsPresenter(ViewInterface viewInterface) {
        this.mView = viewInterface;
    }

//    public static BaseRecordDetailsPresenter newInstance(ViewInterface viewInterface) {
//        return new BaseRecordDetailsPresenter(viewInterface);
//    }




    public interface ViewInterface {
        Context getAppContext();
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

    public abstract void saveRecord(int id, String title, String username, String password, String categoryTitle, String website, String notes);
//    public void saveRecord(int id, String mTitleText, String mUsernameText, String mPasswordText, String mCategoryText, String mWebsiteText, String mNotesText) {
//        List<RecordsEntity.Record> records = SecureSecretsModel.getInstance().getRecordsEntity().getRecords();
//        List<RecordsEntity.Record> resultRecords = new ArrayList<>();
//        for(RecordsEntity.Record tempRecord: records){
//            if(tempRecord.getId() == id){
//                tempRecord.setTitle(mTitleText);
//                tempRecord.setUserName(mUsernameText);
//                tempRecord.setPassword(mPasswordText);
//                tempRecord.getCategory().setTitle(mCategoryText);
//                tempRecord.setWebsite(mWebsiteText);
//                tempRecord.setNotes(mNotesText);
//            }
//            resultRecords.add(tempRecord);
//        }
//        SecureSecretsModel.getInstance().getRecordsEntity().setRecords(resultRecords);
//        SecureSecretsModel.getInstance().save();
//    }


}
