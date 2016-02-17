package com.praxisgs.securesecrets.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.praxisgs.securesecrets.R;
import com.praxisgs.securesecrets.base.BaseEntity;
import com.praxisgs.securesecrets.base.BaseFragment;
import com.praxisgs.securesecrets.base.BaseListAdapter;

public class CategoriesFragment extends BaseFragment<CategoriesPresenter> implements CategoriesPresenter.ViewInterface {
    public static final String TAG = CategoriesFragment.class.getName();


    @Override
    protected CategoriesPresenter instantiatePresenter() {
        return CategoriesPresenter.newInstance(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_categories_records, null);
        bindView(view);
        return view;
    }

    private void bindView(View view) {
        ListView categories_listview = (ListView) view.findViewById(R.id.categories_records_listview);
        BaseListAdapter listAdapter = new BaseListAdapter(getAppContext(), mPresenter.getCategories());
        categories_listview.setAdapter(listAdapter);
        categories_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BaseEntity baseEntity = (BaseEntity)parent.getItemAtPosition(position);
                mPresenter.listItemWithIdClicked(baseEntity.getId());
            }
        });

    }
}
