package drive;

import android.app.Activity;
import android.content.IntentSender;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import model.SecureSecretsModel;
import utils.Constants;

/**
 * Created by British Gas on 26/01/2016.
 */
public class SecureSecretsDrive implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static SecureSecretsDrive instance;
    private Activity activity;
    private GoogleApiClient mDriveClient;
    public static final int REQUEST_CODE_RESOLUTION = 3;
    private DriveId mDriveId;
    private String dataToWrite;

    final private ResultCallback<DriveApi.DriveContentsResult> createContentCallback = new ResultCallback<DriveApi.DriveContentsResult>() {
        @Override
        public void onResult(DriveApi.DriveContentsResult results) {

            if (!results.getStatus().isSuccess()) {
                Toast.makeText(activity, "Error while creating a file contents on Drive...", Toast.LENGTH_LONG).show();
                return;
            }

            MetadataChangeSet changeSet = new MetadataChangeSet.Builder()
                    .setTitle(Constants.DATA_FILE_NAME)
                    .setMimeType(Constants.DATA_FILE_NAME_MIME)
                    .build();

            Drive.DriveApi.getAppFolder(mDriveClient)
                    .createFile(mDriveClient, changeSet, results.getDriveContents())
                    .setResultCallback(createFileCallback);

        }
    };


    final private ResultCallback<DriveFolder.DriveFileResult> createFileCallback = new ResultCallback<DriveFolder.DriveFileResult>() {

        @Override
        public void onResult(DriveFolder.DriveFileResult result) {
            if (!result.getStatus().isSuccess()) {
                Toast.makeText(activity, "Error while creating a file on Drive...", Toast.LENGTH_LONG).show();
                return;
            }

            mDriveId = result.getDriveFile().getDriveId();

            Toast.makeText(activity, "Created a file  in App Folder: " + result.getDriveFile().getDriveId(), Toast.LENGTH_LONG).show();
        }
    };

    final private ResultCallback<Status> fileDeleteCallback = new ResultCallback<Status>() {
        @Override
        public void onResult(Status result) {
            if (result.getStatus().isSuccess()) {
                Toast.makeText(activity, "File Deleted Successfully...", Toast.LENGTH_LONG).show();
                mDriveId = null;
            } else {
                Toast.makeText(activity, "Could not delete File", Toast.LENGTH_LONG).show();
            }
        }
    };

    final private ResultCallback<Status> fileUpdatedCallback = new ResultCallback<Status>() {
        @Override
        public void onResult(Status result) {
            if (result.getStatus().isSuccess()) {
                Toast.makeText(activity, "File Updated Successfully...", Toast.LENGTH_LONG).show();
//                mDriveId = null;
            } else {
                Toast.makeText(activity, "Could not updated File", Toast.LENGTH_LONG).show();
            }
        }
    };

    final private ResultCallback<DriveApi.DriveContentsResult> readContentOpenedCallBack = new ResultCallback<DriveApi.DriveContentsResult>() {
        @Override
        public void onResult(DriveApi.DriveContentsResult results) {
            if (!results.getStatus().isSuccess()) {
                Toast.makeText(activity, "Could not Open File Content", Toast.LENGTH_LONG).show();
                return;
            }

            DriveContents driverContents = results.getDriveContents();
            BufferedReader reader = new BufferedReader(new InputStreamReader(driverContents.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String data;
            try {
                while ((data = reader.readLine()) != null) {
                    builder.append(data);
                }
            } catch (IOException e) {
                e.printStackTrace();

            }

            String contentString = builder.toString();
            SecureSecretsModel.getInstance().loadNewData(contentString);

        }
    };


    final private ResultCallback<DriveApi.DriveContentsResult> writeContentOpenedCallBack = new ResultCallback<DriveApi.DriveContentsResult>() {
        @Override
        public void onResult(DriveApi.DriveContentsResult results) {
            if (!results.getStatus().isSuccess()) {
                Toast.makeText(activity, "Could not Open File Content", Toast.LENGTH_LONG).show();
                return;
            }
            try {
                DriveContents driverContents = results.getDriveContents();
                OutputStream outputStream = driverContents.getOutputStream();
                outputStream.write(dataToWrite.getBytes());
                PendingResult<Status> status = driverContents.commit(mDriveClient, null);
                status.setResultCallback(fileUpdatedCallback);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };


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

    public void createFile() {
        Drive.DriveApi.newDriveContents(mDriveClient).setResultCallback(createContentCallback);
    }

    public void readFileFromDrive() {
        if (mDriveId == null) {
            Toast.makeText(activity, "Create the file first in Drive...", Toast.LENGTH_LONG).show();
        } else {
            DriveFile driveFile = mDriveId.asDriveFile();
            driveFile.open(mDriveClient, DriveFile.MODE_READ_ONLY, null)
                    .setResultCallback(readContentOpenedCallBack);
        }
    }

    public void writeFileToDrive(String dataToWrite) {
        if (mDriveId == null) {
            Toast.makeText(activity, "Create the file first in Drive...", Toast.LENGTH_LONG).show();
        } else {
            this.dataToWrite = dataToWrite;
            DriveFile driveFile = mDriveId.asDriveFile();
            driveFile.open(mDriveClient, DriveFile.MODE_WRITE_ONLY, null)
                    .setResultCallback(writeContentOpenedCallBack);
        }
    }

    public void deleteFile() {
        DriveFile fileToDelete = mDriveId.asDriveFile();
        PendingResult<Status> status = fileToDelete.delete(mDriveClient);
        status.setResultCallback(fileDeleteCallback);

    }

}
