package com.praxisgs.securesecrets.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.praxisgs.securesecrets.R;

import java.util.List;

/**
 * Created on 05/02/2016.
 */
public class BaseListAdapter extends BaseAdapter {
    private final Context context;
    private final List<BaseEntity> listItems;

    /**
     * Constructor
     *
     * @param context            The current context.
     * @param items            The objects to represent in the ListView.
     */
    public BaseListAdapter(Context context, List<BaseEntity> items) {
        this.context = context;
        this.listItems = items;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public BaseEntity getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView ==null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.base_list_view_item, null);
            viewHolder.titleTxt = (CheckedTextView) convertView.findViewById(R.id.base_list_view_txt);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        BaseEntity listItem = getItem(position);
        viewHolder.titleTxt.setText(listItem.getTitle());
        viewHolder.titleTxt.setChecked(true);
        return convertView;

    }

    class ViewHolder{
        CheckedTextView titleTxt;
    }
}
