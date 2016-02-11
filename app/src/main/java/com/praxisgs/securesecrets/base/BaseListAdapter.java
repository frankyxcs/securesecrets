package com.praxisgs.securesecrets.base;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created on 05/02/2016.
 */
public class BaseListAdapter extends ArrayAdapter<BaseEntity> {
    /**
     * Constructor
     *
     * @param context            The current context.
     * @param textViewResourceId The id of the TextView within the layout resource to be populated
     * @param items            The objects to represent in the ListView.
     */
    public BaseListAdapter(Context context, int textViewResourceId, List<BaseEntity> items) {
        super(context, textViewResourceId, items);
    }
}
