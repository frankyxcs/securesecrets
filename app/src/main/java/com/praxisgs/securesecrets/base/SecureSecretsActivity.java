package com.praxisgs.securesecrets.base;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.praxisgs.securesecrets.R;
import com.praxisgs.securesecrets.controllers.AppNavigationController;
import com.praxisgs.securesecrets.controllers.AppNavigationControllerInterface;

import drive.SecureSecretsDrive;
import model.TestData;
import utils.AppNavigationEnum;

public class SecureSecretsActivity extends BaseActivity implements AppNavigationControllerInterface {

    private AppNavigationController appNavigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SecureSecretsDrive.initialise(this);
        SecureSecretsDrive.getInstance().initialiseGoogleDriveAccess();
        //setContentView(R.layout.activity_secure_secrets);
        //bindView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initialiseControllers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showPassCodePage();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appNavigationController.destroy();
    }

    private void initialiseControllers() {
        appNavigationController =   new AppNavigationController(this);
    }


//    private void bindView() {
//
//        Button login = (Button) findViewById(R.id.driveLoginBtn);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SecureSecretsDrive.getInstance().connectToGoogleDrive();
//                //connectToGoogleDrive();
//            }
//        });
//
//        Button logout = (Button) findViewById(R.id.driveLogoutBtn);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SecureSecretsDrive.getInstance().disconnectToGoogleDrive();
//                //disconnectToGoogleDrive();
//            }
//        });
//
//        Button createFile = (Button) findViewById(R.id.driveCreateFileBtn);
//        createFile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SecureSecretsDrive.getInstance().createFile();
//            }
//        });
//
//        Button readFile = (Button) findViewById(R.id.driveReadFileBtn);
//        readFile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SecureSecretsDrive.getInstance().readFileFromDrive();
//            }
//        });
//
//        Button writeFile = (Button) findViewById(R.id.driveWriteFileBtn);
//        writeFile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String modelStr = new TestData().getData().toString();
//                SecureSecretsDrive.getInstance().writeFileToDrive(modelStr);
//            }
//        });
//
//        Button deleteFile = (Button) findViewById(R.id.driveDeleteFileBtn);
//        deleteFile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SecureSecretsDrive.getInstance().deleteFile();
//            }
//        });
//    }


    /**
     * Show PassCode Page
     */
    @Override
    public void showPassCodePage() {
        showFragment(AppNavigationEnum.PASSCODE.getFragmentTag(),null,AppNavigationEnum.PASSCODE.getTitle());
    }

    /**
     * Show the Categories page
     */
    @Override
    public void showCategoriesPage() {
        showFragment(AppNavigationEnum.CATEGORIES.getFragmentTag(), null, AppNavigationEnum.CATEGORIES.getTitle());
    }


}
