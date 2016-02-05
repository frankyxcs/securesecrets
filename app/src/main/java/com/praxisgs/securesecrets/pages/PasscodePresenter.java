package com.praxisgs.securesecrets.pages;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.praxisgs.securesecrets.base.BasePresenter;

import model.PassCodeEntity;
import model.SecureSecretsModel;

/**
 * Created on 04/02/2016.
 */
public class PasscodePresenter implements BasePresenter {
    private ViewInterface mView;

    private PasscodePresenter(ViewInterface viewInterface) {
        this.mView = viewInterface;
    }

    public static PasscodePresenter newInstance(ViewInterface viewInterface) {
        return new PasscodePresenter(viewInterface);
    }

    public boolean isPassCodeCreated() {
        PassCodeEntity passCodeEntity = SecureSecretsModel.getInstance().getPassCodeEntity();
        if(passCodeEntity !=null && passCodeEntity.getPassCode() !=null && !passCodeEntity.getPassCode().isEmpty())
            return true;
        return false;
    }

    public void passCodeEnterOKBtnClicked(String passcode) {
        PassCodeEntity passCodeEntity = SecureSecretsModel.getInstance().getPassCodeEntity();
        if(passCodeEntity !=null && passCodeEntity.getPassCode() !=null && !passCodeEntity.getPassCode().isEmpty()){
            String storedPasscode = passCodeEntity.getPassCode();
            if(passcode.equals(storedPasscode)){
                //TODO show Categories page
            }else{
                //TODO Show error
            }
        }

    }

    public void createPassCodeBtnClicked(String createPassCode, String recreatePassCode) {
        if(createPassCode.equals(recreatePassCode)){
            //TODO store it in Model
        }else{
            //TODO show Error
        }

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
}
