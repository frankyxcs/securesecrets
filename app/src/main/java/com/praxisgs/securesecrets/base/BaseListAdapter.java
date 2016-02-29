package com.praxisgs.securesecrets.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.praxisgs.securesecrets.R;

import java.util.List;

import model.BaseEntity;

/**
 * Created on 05/02/2016.
 */
public class BaseListAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<BaseEntity> mListItems;
    private final boolean mShowMultiSelection;

    /**
     * Constructor
     *
     * @param context            The current context.
     * @param items            The objects to represent in the ListView.
     */
    public BaseListAdapter(Context context, List<BaseEntity> items) {
        this(context,items,false);
    }

    /**
     * Constructor
     *
     * @param context            The current context.
     * @param items            The objects to represent in the ListView.
     */
    public BaseListAdapter(Context context, List<BaseEntity> items, boolean showMultiSelection) {
        this.mContext = context;
        this.mListItems = items;
        this.mShowMultiSelection = showMultiSelection;
    }

    @Override
    public int getCount() {
        return mListItems.size();
    }

    @Override
    public BaseEntity getItem(int position) {
        return mListItems.get(position);
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
            convertView = View.inflate(mContext, R.layout.base_list_view_item, null);
            viewHolder.titleTxt = (TextView) convertView.findViewById(R.id.base_list_view_title_txt);
            viewHolder.checkBox = (CheckBox)convertView.findViewById(R.id.base_list_view_checkBox);

            if(mShowMultiSelection){
                viewHolder.checkBox.setVisibility(View.VISIBLE);
//                viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                        int positionOfCheckBox = (Integer) buttonView.getTag();
//                        mListItems.get(positionOfCheckBox).setSelected(buttonView.isChecked());
//
//                    }
//                });

            }else{
                viewHolder.checkBox.setVisibility(View.INVISIBLE);
               // viewHolder.checkBox.setOnCheckedChangeListener(null);
            }


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        BaseEntity listItem = getItem(position);
        viewHolder.titleTxt.setText(listItem.getTitle());
        viewHolder.checkBox.setSelected(listItem.isSelected());
        viewHolder.checkBox.setTag(position);

        return convertView;

    }

    public void toggleSelection(View view, int position) {
        CheckBox checkedBox = (CheckBox) view.findViewById(R.id.base_list_view_checkBox);
        BaseEntity selectedItem = mListItems.get(position);
        if(selectedItem.isSelected()){
            selectedItem.setSelected(false);
            checkedBox.setSelected(false);
        }else{
            selectedItem.setSelected(true);
            checkedBox.setSelected(true);
        }

        notifyDataSetChanged();
    }

    class ViewHolder{
        TextView titleTxt;
        CheckBox checkBox;
    }
}
