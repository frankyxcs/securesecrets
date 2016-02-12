package com.praxisgs.securesecrets.pages;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.praxisgs.securesecrets.base.BaseEntity;
import com.praxisgs.securesecrets.base.BasePresenter;

import java.util.List;

import eventbus.AppNavigationEvents;
import eventbus.SecureSecretsEventBus;
import utils.SecureSecretsModelUtils;

/**
 * Created on 04/02/2016.
 */
public class RecordsPresenter implements BasePresenter {
    private ViewInterface mView;

    private RecordsPresenter(ViewInterface viewInterface) {
        this.mView = viewInterface;
    }

    public static RecordsPresenter newInstance(ViewInterface viewInterface) {
        return new RecordsPresenter(viewInterface);
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

    public List<BaseEntity> getRecords(int id) {

        return SecureSecretsModelUtils.getRecordsForCategoryId(id);
    }

    public void floatingBtnClicked() {

    }

    public void listItemWithIdClicked(int id) {
        SecureSecretsEventBus.post(new AppNavigationEvents.EventShowRecordsForId(id));
    }


}
