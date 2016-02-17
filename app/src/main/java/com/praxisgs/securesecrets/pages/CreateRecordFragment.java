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
import com.praxisgs.securesecrets.base.BaseFragment;
import com.praxisgs.securesecrets.base.BaseRecordDetailsFragment;

import model.RecordsEntity;
import utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateRecordFragment extends BaseRecordDetailsFragment<CreateRecordPresenter> implements CreateRecordPresenter.ViewInterface {

    public static final String TAG = CreateRecordFragment.class.getName();
//    private EditText mTitle;
//    private EditText mUsername;
//    private EditText mPassword;
//    private EditText mCategory;
//    private EditText mWebsite;
//    private EditText mNotes;
//    private boolean mIsEditing;
//    private int mClickedId;
//    private Menu mMenu;

    @Override
    protected CreateRecordPresenter instantiatePresenter() {
        return CreateRecordPresenter.newInstance(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
//        if (getArguments() != null)
//            mClickedId = getArguments().getInt(Constants.BUNDLE_ID);
//        bindView(view);
        setHasOptionsMenu(true);
        return view;
    }

//    private void bindView(View view) {
//        RecordsEntity.Record record = mPresenter.getRecordDetails(mClickedId);
//        mTitle = (EditText) view.findViewById(R.id.displayTitle_editView);
//        mUsername = (EditText) view.findViewById(R.id.displayUsername_editView);
//        mPassword = (EditText) view.findViewById(R.id.displayPassword_editView);
//        mCategory = (EditText) view.findViewById(R.id.displayCategory_editView);
//        mWebsite = (EditText) view.findViewById(R.id.displayWebsite_editView);
//        mNotes = (EditText) view.findViewById(R.id.displayNotes_editView);
//
//        if (record != null) {
//            mTitle.setText(record.getTitle());
//            mUsername.setText(record.getUserName());
//            mPassword.setText(record.getPassword());
//            mCategory.setText(record.getCategory().getTitle());
//            mWebsite.setText(record.getWebsite());
//            mNotes.setText(record.getNotes());
//        }
//
//        enableDisableEditing();
//    }

//    private void enableDisableEditing() {
//        if (mIsEditing) {
//            mTitle.setEnabled(true);
//            mUsername.setEnabled(true);
//            mPassword.setEnabled(true);
//            mCategory.setEnabled(true);
//            mWebsite.setEnabled(true);
//            mNotes.setEnabled(true);
//            if (mMenu != null) {
//                mMenu.findItem(R.id.display_record_save).setVisible(true);
//                mMenu.findItem(R.id.display_record_edit).setVisible(false);
//            }
//        } else {
//            mTitle.setEnabled(false);
//            mUsername.setEnabled(false);
//            mPassword.setEnabled(false);
//            mCategory.setEnabled(false);
//            mWebsite.setEnabled(false);
//            mNotes.setEnabled(false);
//            if (mMenu != null) {
//                mMenu.findItem(R.id.display_record_edit).setVisible(true);
//                mMenu.findItem(R.id.display_record_save).setVisible(false);
//            }
//        }
//    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.create_record_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_record_save:
                saveRecord();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveRecord() {
        mPresenter.saveRecord(-1, mTitle.getText().toString(), mUsername.getText().toString(), mPassword.getText().toString(), mCategory.getText().toString(), mWebsite.getText().toString(), mNotes.getText().toString());
    }
}
