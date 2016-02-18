package com.praxisgs.securesecrets.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

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
        setHasOptionsMenu(true);
        return view;
    }

    private void bindView(View view) {
        ListView records_listview = (ListView) view.findViewById(R.id.categories_records_listview);
        BaseListAdapter listAdapter = new BaseListAdapter(getAppContext(), mPresenter.getRecords(clickedId));
        records_listview.setAdapter(listAdapter);
        records_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BaseEntity baseEntity = (BaseEntity)parent.getItemAtPosition(position);
                mPresenter.listItemWithIdClicked(baseEntity.getId());
            }
        });

        TextView emptyTextView = (TextView) view.findViewById(R.id.categories_records_empty_list);
        if(!mPresenter.getRecords(clickedId).isEmpty()){
            emptyTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.record_list_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.record_add:
                mPresenter.addRecordClicked();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
