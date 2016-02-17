package com.praxisgs.securesecrets.pages;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.praxisgs.securesecrets.R;

import model.RecordsEntity;
import utils.Constants;
import com.praxisgs.securesecrets.base.BaseRecordDetailsFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayAndEditRecordFragment extends BaseRecordDetailsFragment<DisplayAndEditRecordPresenter> implements DisplayAndEditRecordPresenter.ViewInterface {

    public static final String TAG = DisplayAndEditRecordFragment.class.getName();
    private boolean mIsEditing;
    private Menu mMenu;

    @Override
    protected DisplayAndEditRecordPresenter instantiatePresenter() {
        return DisplayAndEditRecordPresenter.newInstance(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= super.onCreateView(inflater,container,savedInstanceState);
        setHasOptionsMenu(true);
        enableDisableEditing();
        return view;
    }

    private void enableDisableEditing() {
        if (mIsEditing) {
            mTitle.setEnabled(true);
            mUsername.setEnabled(true);
            mPassword.setEnabled(true);
            mCategory.setEnabled(true);
            mWebsite.setEnabled(true);
            mNotes.setEnabled(true);
            if (mMenu != null) {
                mMenu.findItem(R.id.display_record_save).setVisible(true);
                mMenu.findItem(R.id.display_record_edit).setVisible(false);
            }
        } else {
            mTitle.setEnabled(false);
            mUsername.setEnabled(false);
            mPassword.setEnabled(false);
            mCategory.setEnabled(false);
            mWebsite.setEnabled(false);
            mNotes.setEnabled(false);
            if (mMenu != null) {
                mMenu.findItem(R.id.display_record_edit).setVisible(true);
                mMenu.findItem(R.id.display_record_save).setVisible(false);
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.display_record_menu, menu);
        mMenu = menu;
        enableDisableEditing();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.display_record_edit:
                mIsEditing = true;
                enableDisableEditing();
                return true;
            case R.id.display_record_save:
                mIsEditing = false;
                saveRecord();
                enableDisableEditing();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveRecord() {
        mPresenter.saveRecord(mClickedId, mTitle.getText().toString(), mUsername.getText().toString(), mPassword.getText().toString(), mCategory.getText().toString(), mWebsite.getText().toString(), mNotes.getText().toString());
    }
}
