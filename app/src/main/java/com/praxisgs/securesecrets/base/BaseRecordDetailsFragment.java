package com.praxisgs.securesecrets.base;


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
import com.praxisgs.securesecrets.pages.DisplayAndEditRecordPresenter;

import model.RecordsEntity;
import utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseRecordDetailsFragment<T extends BaseRecordDetailsPresenter> extends BaseFragment<BaseRecordDetailsPresenter> implements BaseRecordDetailsPresenter.ViewInterface {

    public static final String TAG = BaseRecordDetailsFragment.class.getName();
    protected EditText mTitle;
    protected EditText mUsername;
    protected EditText mPassword;
    protected EditText mCategory;
    protected EditText mWebsite;
    protected EditText mNotes;
    protected int mClickedId;

//    @Override
//    protected BaseRecordDetailsPresenter instantiatePresenter() {
//        return BaseRecordDetailsPresenter.newInstance(this);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_and_edit_record, container, false);
        if (getArguments() != null)
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

        if (record != null) {
            mTitle.setText(record.getTitle());
            mUsername.setText(record.getUserName());
            mPassword.setText(record.getPassword());
            mCategory.setText(record.getCategory().getTitle());
            mWebsite.setText(record.getWebsite());
            mNotes.setText(record.getNotes());
        }
    }
}
