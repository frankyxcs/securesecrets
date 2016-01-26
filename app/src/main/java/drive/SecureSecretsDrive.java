package drive;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.praxisgs.securesecrets.base.BaseActivity;

/**
 * Created by British Gas on 26/01/2016.
 */
public class SecureSecretsDrive implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static SecureSecretsDrive instance;
    private static Context context;
    private static GoogleApiClient mDriveClient;
    private static final int REQUEST_CODE_CAPTURE_IMAGE = 1;
    private static final int REQUEST_CODE_CREATOR = 2;
    private static final int REQUEST_CODE_RESOLUTION = 3;
    private static BaseActivity activity;

    private SecureSecretsDrive(Context context) {
        this.context = context;
    }

    public static void initialise(Context context) {
        if (instance == null)
            instance = new SecureSecretsDrive(context);
    }

    public static void initialiseGoogleDriveAccess(BaseActivity activity) {
        instance.activity = activity;
        mDriveClient = new GoogleApiClient.Builder(activity)
                .addApi(Drive.API)
                .addScope(Drive.SCOPE_FILE)
                .addConnectionCallbacks(SecureSecretsDrive.instance)
                .addOnConnectionFailedListener(SecureSecretsDrive.instance)
                .build();
    }

    public static void connectToGoogleDrive() {
        mDriveClient.connect();
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
                connectionResult.startResolutionForResult(activity, REQUEST_CODE_RESOLUTION);
            } catch (IntentSender.SendIntentException e) {
                // Unable to resolve, message user appropriately
            }
        }else {
            GooglePlayServicesUtil.getErrorDialog(connectionResult.getErrorCode(), activity, 0).show();
        }
    }

}
