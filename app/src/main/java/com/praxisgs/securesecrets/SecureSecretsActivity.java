package com.praxisgs.securesecrets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.praxisgs.securesecrets.base.BaseActivity;

import drive.SecureSecretsDrive;

public class SecureSecretsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secure_secrets);
    }


}
