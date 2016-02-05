package com.praxisgs.securesecrets.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.praxisgs.securesecrets.R;
import com.praxisgs.securesecrets.base.BaseFragment;

public class CategoriesFragment extends BaseFragment<CategoriesPresenter> implements CategoriesPresenter.ViewInterface {
    public static final String TAG = CategoriesFragment.class.getName();


    @Override
    protected CategoriesPresenter instantiatePresenter() {
        return CategoriesPresenter.newInstance(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_categories, null);
        bindView(view);
        return view;
    }

    private void bindView(View view) {

    }
}
