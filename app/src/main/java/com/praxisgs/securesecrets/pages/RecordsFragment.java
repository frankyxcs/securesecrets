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

import utils.Constants;

public class RecordsFragment extends BaseFragment<RecordsPresenter> implements RecordsPresenter.ViewInterface {
    public static final String TAG = RecordsFragment.class.getName();
    private int clickedId;


    @Override
    protected RecordsPresenter instantiatePresenter() {
        return RecordsPresenter.newInstance(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        clickedId = getArguments().getInt(Constants.BUNDLE_ID);
        View view = inflater.inflate(R.layout.fragment_categories_records, null);
        bindView(view);
        return view;
    }

    private void bindView(View view) {
        ListView records_listview = (ListView) view.findViewById(R.id.categories_records_listview);
        FloatingActionButton floatingBtn = (FloatingActionButton) view.findViewById(R.id.categories_records_floatingBtn);
        floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.floatingBtnClicked();
            }
        });
        BaseListAdapter listAdapter = new BaseListAdapter(getAppContext(), mPresenter.getRecords(clickedId));
        records_listview.setAdapter(listAdapter);
        records_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BaseEntity baseEntity = (BaseEntity)parent.getItemAtPosition(position);
                mPresenter.listItemWithIdClicked(baseEntity.getId());
            }
        });

    }
}
