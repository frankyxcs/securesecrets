package com.praxisgs.securesecrets.base;

import android.content.Intent;
import android.content.IntentSender;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;

import drive.SecureSecretsDrive;

public class BaseActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{

    private  GoogleApiClient mDriveClient;
    private  final int REQUEST_CODE_CAPTURE_IMAGE = 1;
    private  final int REQUEST_CODE_CREATOR = 2;
    private  final int REQUEST_CODE_RESOLUTION = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialiseGoogleDriveAccess();
    }

    @Override
    protected void onStart() {
        super.onStart();
        connectToGoogleDrive();
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            try {
                connectionResult.startResolutionForResult(this, REQUEST_CODE_RESOLUTION);
            } catch (IntentSender.SendIntentException e) {
                // Unable to resolve, message user appropriately
            }
        }else {
            GooglePlayServicesUtil.getErrorDialog(connectionResult.getErrorCode(), this, 0).show();
        }
    }

    @Override
    protected void onActivityResult(final int requestCode,final int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_CODE_RESOLUTION:
                if (resultCode == RESULT_OK) {
                    mDriveClient.connect();
                }break;
        }
    }

    private  void initialiseGoogleDriveAccess() {
        mDriveClient = new GoogleApiClient.Builder(this)
                .addApi(Drive.API)
                .addScope(Drive.SCOPE_APPFOLDER)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
    }

    private  void connectToGoogleDrive() {
        mDriveClient.connect();
    }
}
