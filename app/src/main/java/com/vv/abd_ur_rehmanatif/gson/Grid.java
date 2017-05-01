package com.vv.abd_ur_rehmanatif.gson;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vv.abd_ur_rehmanatif.gson.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Grid extends Fragment {


    public Grid() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid, container, false);
    }

}
