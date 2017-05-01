package com.vv.abd_ur_rehmanatif.gson;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vv.abd_ur_rehmanatif.gson.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailView extends Fragment {

    TextView  id ;
    TextView Firstname;
    TextView Username;
    TextView Password;
    TextView Gender;
    TextView Address;
    TextView phone;
    List<ContectList> Newlist = new ArrayList<ContectList>();
    Type type = new TypeToken<List<ContectList>>() {}.getType();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_detail_view, container, false);

        id = (TextView)v.findViewById(R.id.id);
        Firstname = (TextView)v.findViewById(R.id.FirstName);
        Username = (TextView)v.findViewById(R.id.UserName);
        Password = (TextView)v.findViewById(R.id.Password);
        Gender = (TextView)v.findViewById(R.id.Gender);
        Address = (TextView)v.findViewById(R.id.Address);
        phone = (TextView)v.findViewById(R.id.PhoneNumber);


        String strtext = getArguments().getString("Data");


        Gson g = new Gson();
        List<ContectList> fromJson = g.fromJson(strtext, type);

        id.setText(fromJson.get(0).getId());
        Firstname.setText(fromJson.get(0).getFirstname());
        Username.setText(fromJson.get(0).getUsername());
        Password.setText(fromJson.get(0).getPassword());
        Gender.setText(fromJson.get(0).getGender());
        Address.setText(fromJson.get(0).getAddress());
        phone.setText(fromJson.get(0).getPhone());








        return v;
    }

}
