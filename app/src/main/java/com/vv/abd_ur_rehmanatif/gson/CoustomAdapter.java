package com.vv.abd_ur_rehmanatif.gson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.prefs.BackingStoreException;

/**
 * Created by abd-ur-rehmanatif on 01/05/2017.
 */

public class CoustomAdapter extends BaseAdapter {

    Context C;
    ArrayList<ContectList> ObjectForContect;

    public CoustomAdapter(Context c , ArrayList<ContectList> ObjectForContect) {

      this.C = c;
        this.ObjectForContect = ObjectForContect;



    }

    @Override
    public int getCount() {
        return ObjectForContect.size();
    }

    @Override
    public Object getItem(int position) {
        return ObjectForContect.get(position);


    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflator = (LayoutInflater) C.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)

        {

            convertView = inflator.inflate(R.layout.adapterlayout, parent , false);

        }

        TextView id = (TextView) convertView.findViewById(R.id.IdForCoustomLayout);
        id.setText(ObjectForContect.get(position).getId());
        return convertView;
    }
}
