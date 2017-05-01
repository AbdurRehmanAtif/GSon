package com.vv.abd_ur_rehmanatif.gson;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button FindButton;
    TextView  SearchTextView ;
    EditText  TextField;
    RelativeLayout SubView;
    RelativeLayout DetailView;
    GridView GridView;
    List<ContectList> list = new ArrayList<ContectList>();
    List<ContectList> Newlist = new ArrayList<ContectList>();
    Type type = new TypeToken<List<ContectList>>() {}.getType();
    Gson gson = new Gson();










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FindButton = (Button)findViewById(R.id.FindButton);
        SubView = (RelativeLayout)findViewById(R.id.LayoutOne);
        TextField =(EditText)findViewById(R.id.GetText);
        SearchTextView = (TextView)findViewById(R.id.SearchTextView);
        GridView = (GridView)findViewById(R.id.GridView);





          // Initalizing Data

        for (int i = 0; i < 20; i++) {

            list.add(new ContectList("" + i, "h", "rashid", "1231", "Male", "Defence Lahore", "+923423"));

        }


        list.add(new ContectList("" , "l", "rashid", "1231", "Male", "Defence Lahore", "+923423"));





        FindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String FetchedValue = TextField.getText().toString();

                String json = gson.toJson(list);
                List<ContectList> fromJson = gson.fromJson(json, type);

                for (ContectList Contect : fromJson) {

                    if (Contect.getFirstname().contentEquals(FetchedValue)){


                        Newlist.add(new ContectList(Contect.getId() , Contect.getFirstname(),Contect.getUsername(),Contect.getPassword(),Contect.getGender(),Contect.getAddress(),Contect.getPhone()));

                    }else {


                    }
                }



      if(Newlist.size() > 1){

             SwicthToSubView();

     }else if(Newlist.size() > 0 )
     {

         SwitchToDetailView(Newlist.get(0));

     }


            }
        });









    }



    public void SwitchToDetailView(ContectList ObjectForContect) {



        MainActivity M1 = new MainActivity();

        FragmentManager Fm = getFragmentManager();
        FragmentTransaction FT = Fm.beginTransaction();

        DetailView F1 = new DetailView();

        SearchTextView.setVisibility(View.GONE);
        TextField.setVisibility(View.GONE);
        FindButton.setVisibility(View.GONE);




        String json = gson.toJson(ObjectForContect);

        Bundle bundle = new Bundle();
        bundle.putString("Data", ""+json);

        DetailView fragobj = new DetailView();
        fragobj.setArguments(bundle);


        FT.add(R.id.LayoutOne , F1);


        FT.commit();
    }


    public void SwicthToSubView() {


        //GridView


        MainActivity M1 = new MainActivity();

        FragmentManager Fm = getFragmentManager();
        FragmentTransaction FT = Fm.beginTransaction();

        Grid F1 = new Grid();

        SearchTextView.setVisibility(View.GONE);
        TextField.setVisibility(View.GONE);
        FindButton.setVisibility(View.GONE);

        CoustomAdapter adapter = new CoustomAdapter(this, (ArrayList<ContectList>) Newlist);

        FT.add(R.id.LayoutOne , F1);
        GridView.setAdapter(adapter);

        FT.commit();



        GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                RandomFunction(Newlist.get(0));


            }
        });


    }

 public void RandomFunction(ContectList Object) {



     MainActivity M1 = new MainActivity();

     FragmentManager Fm = getFragmentManager();
     FragmentTransaction FT = Fm.beginTransaction();

     DetailView F1 = new DetailView();

     SearchTextView.setVisibility(View.GONE);
     TextField.setVisibility(View.GONE);
     FindButton.setVisibility(View.GONE);




     String json = gson.toJson(Object);

     Bundle bundle = new Bundle();
     bundle.putString("Data", ""+json);

     DetailView fragobj = new DetailView();
     fragobj.setArguments(bundle);


     FT.add(R.id.LayoutOne , F1);


     FT.commit();

 }





}