package com.praxisgs.securesecrets.pages;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.praxisgs.securesecrets.R;
import com.praxisgs.securesecrets.base.BaseFragment;
import com.praxisgs.securesecrets.base.BaseListAdapter;

import model.BaseEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends BaseFragment<SettingsPresenter> implements SettingsPresenter.ViewInterface {
    public static final String TAG = SettingsFragment.class.getName();

    @Override
    protected SettingsPresenter instantiatePresenter() {
        return SettingsPresenter.newInstance(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_categories_records_settings, null);
        bindView(view);
        return view;
    }

    private void bindView(View view) {
        ListView categories_listview = (ListView) view.findViewById(R.id.categories_records_settings_listview);
        BaseListAdapter listAdapter = new BaseListAdapter(getAppContext(), mPresenter.getSettings());
        categories_listview.setAdapter(listAdapter);
        categories_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BaseEntity baseEntity = (BaseEntity) parent.getItemAtPosition(position);
                mPresenter.listItemWithIdClicked(baseEntity.getId());
            }
        });

        TextView emptyTextView = (TextView) view.findViewById(R.id.categories_records_settings_empty_list);
        emptyTextView.setVisibility(View.GONE);

    }


}
