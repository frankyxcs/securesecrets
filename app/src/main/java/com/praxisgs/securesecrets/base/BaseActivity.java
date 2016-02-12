package com.praxisgs.securesecrets.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.praxisgs.securesecrets.R;

import drive.SecureSecretsDrive;

public abstract class BaseActivity extends AppCompatActivity {

    final String TAG = BaseActivity.class.getName();

//    private Fragment newInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_activity);
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

    private void hideKeyboard() {
        try {
            InputMethodManager im = (InputMethodManager) BaseActivity.this.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (im != null) {
                im.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void showFragment(String fragmentTag, Bundle bundle, String title) {

//        if (newInstance != null && newInstance.getTag() != null && newInstance.getTag().equals(fragmentTag)) {
//            return;
//        }

        hideKeyboard();
        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        Fragment newInstance = Fragment.instantiate(this, fragmentTag, bundle);
        ft.replace(R.id.fragment_container, newInstance);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        setTitle(title);
    }

}
