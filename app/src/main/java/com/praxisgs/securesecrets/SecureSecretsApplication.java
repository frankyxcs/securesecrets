package com.praxisgs.securesecrets;

import android.app.Application;

import drive.SecureSecretsDrive;
import model.SecureSecretsModel;

/**
 * Created by British Gas on 26/01/2016.
 */
public class SecureSecretsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SecureSecretsModel.initialise(this);

    }
}
