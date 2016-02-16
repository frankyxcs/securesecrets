package com.praxisgs.securesecrets.pages;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.praxisgs.securesecrets.base.BasePresenter;

import model.RecordsEntity;
import utils.SecureSecretsModelUtils;

/**
 * Created on 04/02/2016.
 */
public class DisplayAndEditRecordPresenter implements BasePresenter {
    private ViewInterface mView;

    private DisplayAndEditRecordPresenter(ViewInterface viewInterface) {
        this.mView = viewInterface;
    }

    public static DisplayAndEditRecordPresenter newInstance(ViewInterface viewInterface) {
        return new DisplayAndEditRecordPresenter(viewInterface);
    }



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

}
