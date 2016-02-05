package com.praxisgs.securesecrets.base;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created on 05/02/2016.
 */
public class BaseListAdapter extends ArrayAdapter<String> {
    /**
     * Constructor
     *
     * @param context            The current context.
     * @param resource           The resource ID for a layout file containing a layout to use when
     *                           instantiating views.
     * @param textViewResourceId The id of the TextView within the layout resource to be populated
     * @param objects            The objects to represent in the ListView.
     */
    public BaseListAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
