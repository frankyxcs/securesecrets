package com.praxisgs.securesecrets.pages;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.praxisgs.securesecrets.R;
import com.praxisgs.securesecrets.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayRecordFragment extends BaseFragment<DisplayRecordPresenter> implements DisplayRecordPresenter.ViewInterface {

    public static final String TAG = DisplayRecordFragment.class.getName();

    @Override
    protected DisplayRecordPresenter instantiatePresenter() {
        return DisplayRecordPresenter.newInstance(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_record, container, false);
        bindView(view);
        return view;
    }

    private void bindView(View view) {

    }


}
