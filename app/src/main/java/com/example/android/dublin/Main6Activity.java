package com.example.android.dublin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Main6Activity extends AppCompatActivity {
    Integer[] images = {R.drawable.sports1,R.drawable.sports2,R.drawable.sports3,R.drawable.sports4,R.drawable.sports5,R.drawable.sports6,R.drawable.sports7,R.drawable.sports8,R.drawable.sports9,R.drawable.sports10};
    String[] sportsname ={"Sea kayak","Windsurfer","Paragliding","Jetskies ","Sand Volleyball","Rugby","Go Karting","Power Marine","Electric Bike Tour","Horse Riding"};
    String[] address = {"Dalkey Island","Dollymount Beach","Dollymount Strand","High Rock Beach","Sunset Beach Camps","Dublin,Ireland","Birmingham Raceway","Dollymount Beach","Dublin city","Dollymount Beach"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        listView = (ListView)findViewById(R.id.listview);
        SportsAdapter adapter = new SportsAdapter(this,images,sportsname,address);
        listView.setAdapter(adapter);
    }
}
