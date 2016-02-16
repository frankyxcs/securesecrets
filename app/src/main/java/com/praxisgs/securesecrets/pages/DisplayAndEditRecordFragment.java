package com.praxisgs.securesecrets.pages;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.praxisgs.securesecrets.R;
import com.praxisgs.securesecrets.base.BaseFragment;

import model.RecordsEntity;
import utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayAndEditRecordFragment extends BaseFragment<DisplayAndEditRecordPresenter> implements DisplayAndEditRecordPresenter.ViewInterface {

    public static final String TAG = DisplayAndEditRecordFragment.class.getName();
    private EditText mTitle;
    private EditText mUsername;
    private EditText mPassword;
    private EditText mCategory;
    private EditText mWebsite;
    private EditText mNotes;
    private boolean mIsEditing;
    private int mClickedId;

    @Override
    protected DisplayAndEditRecordPresenter instantiatePresenter() {
        return DisplayAndEditRecordPresenter.newInstance(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_and_edit_record, container, false);
        mClickedId = getArguments().getInt(Constants.BUNDLE_ID);
        bindView(view);
        return view;
    }

    private void bindView(View view) {
        RecordsEntity.Record record = mPresenter.getRecordDetails(mClickedId);
        mTitle = (EditText) view.findViewById(R.id.displayTitle_editView);
        mUsername = (EditText) view.findViewById(R.id.displayUsername_editView);
        mPassword = (EditText) view.findViewById(R.id.displayPassword_editView);
        mCategory = (EditText) view.findViewById(R.id.displayCategory_editView);
        mWebsite = (EditText) view.findViewById(R.id.displayWebsite_editView);
        mNotes = (EditText) view.findViewById(R.id.displayNotes_editView);

        if(record!=null){
            mTitle.setText(record.getTitle());
            mUsername.setText(record.getUserName());
            mPassword.setText(record.getPassword());
            mCategory.setText(record.getCategory().getTitle());
            mWebsite.setText(record.getWebsite());
            mNotes.setText(record.getNotes());
        }

        if (mIsEditing) {
            mTitle.setEnabled(true);
            mUsername.setEnabled(true);
            mPassword.setEnabled(true);
            mCategory.setEnabled(true);
            mWebsite.setEnabled(true);
            mNotes.setEnabled(true);
        }
    }


}
