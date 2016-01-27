package drive;

import android.app.Activity;
import android.content.IntentSender;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;

/**
 * Created by British Gas on 26/01/2016.
 */
public class SecureSecretsDrive implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static SecureSecretsDrive instance;
    private Activity activity;
    private GoogleApiClient mDriveClient;
    public static final int REQUEST_CODE_RESOLUTION = 3;

    private SecureSecretsDrive(Activity activity) {
        this.activity = activity;
    }

    public static void initialise(Activity context) {
        if (instance == null)
            instance = new SecureSecretsDrive(context);
    }

    public static SecureSecretsDrive getInstance() {
        return instance;
    }

    public void initialiseGoogleDriveAccess() {
        mDriveClient = new GoogleApiClient.Builder(activity)
                .addApi(Drive.API)
                .addScope(Drive.SCOPE_APPFOLDER)
                .addConnectionCallbacks(SecureSecretsDrive.instance)
                .addOnConnectionFailedListener(SecureSecretsDrive.instance)
                .build();
    }

    public void connectToGoogleDrive() {
        mDriveClient.connect();
    }

    public void disconnectToGoogleDrive() {
        mDriveClient.disconnect();
    }


    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(activity, "Connected to Drive...", Toast.LENGTH_LONG).show();
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
                e.printStackTrace();
            }
        } else {
            //TODO
        }
    }

}
