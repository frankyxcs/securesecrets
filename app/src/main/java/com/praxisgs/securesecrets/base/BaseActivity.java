package com.praxisgs.securesecrets.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import drive.SecureSecretsDrive;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SecureSecretsDrive.REQUEST_CODE_RESOLUTION:
                if (resultCode == RESULT_OK) {
                    SecureSecretsDrive.getInstance().connectToGoogleDrive();
                }
                break;
        }
    }
}
