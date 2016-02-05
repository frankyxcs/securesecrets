package com.praxisgs.securesecrets.base;

import android.app.Application;

import com.praxisgs.securesecrets.controllers.AppNavigationController;

import drive.SecureSecretsDrive;
import eventbus.SecureSecretsEventBus;
import model.SecureSecretsModel;

/**
 * Created by British Gas on 26/01/2016.
 */
public class SecureSecretsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SecureSecretsModel.initialise(this);
        SecureSecretsEventBus.initialise();
    }
}
