package com.praxisgs.securesecrets;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.praxisgs.securesecrets.base.BaseActivity;

import drive.SecureSecretsDrive;
import model.SecureSecretsModel;
import model.TestData;

public class SecureSecretsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SecureSecretsDrive.initialise(this);
        SecureSecretsDrive.getInstance().initialiseGoogleDriveAccess();
        setContentView(R.layout.activity_secure_secrets);
        bindView();
    }

    private void bindView() {

        Button login = (Button) findViewById(R.id.driveLoginBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecureSecretsDrive.getInstance().connectToGoogleDrive();
                //connectToGoogleDrive();
            }
        });

        Button logout = (Button) findViewById(R.id.driveLogoutBtn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecureSecretsDrive.getInstance().disconnectToGoogleDrive();
                //disconnectToGoogleDrive();
            }
        });

        Button createFile = (Button) findViewById(R.id.driveCreateFileBtn);
        createFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecureSecretsDrive.getInstance().createFile();
            }
        });

        Button readFile = (Button) findViewById(R.id.driveReadFileBtn);
        readFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecureSecretsDrive.getInstance().readFileFromDrive();
            }
        });

        Button writeFile = (Button) findViewById(R.id.driveWriteFileBtn);
        writeFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String modelStr = new TestData().getData().toString();
                SecureSecretsDrive.getInstance().writeFileToDrive(modelStr);
            }
        });

        Button deleteFile = (Button)findViewById(R.id.driveDeleteFileBtn);
        deleteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecureSecretsDrive.getInstance().deleteFile();
            }
        });
    }


}
