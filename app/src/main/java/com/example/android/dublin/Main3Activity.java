package com.example.android.dublin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Main3Activity extends AppCompatActivity {
    String[] restro = {"Mr Fox Restaurant","Grill Dublin","San Lorenzo's","Dublin In","Pearl Brasserie"};
    String[] food = {"French Food","Asian,Chinese,Sea Food","Italian Food","Thai,Indian,Shri Lankan Food","Spanish Food"};
    String[] address = {"22 Dawson Street, Dublin 2, Co. Dublin","17-19 Merrion Street Upper, Dublin, Ireland","Gyleen, Seven Oaks, Whitehall, Drumcondra, Dublin 9, Ireland","11-13 Crown Alley, Temple Bar, Dublin, Ireland","5-7 Westmoreland St, Dublin, Ireland"};
    String[] contacts = {"+353 1 677 2324","+353 1 607 3600","+353 1 681 5000","+353 1 874 9202","+353 1 677 2525"};
    Integer[] images = {R.drawable.mr_fox_restro,R.drawable.restro2,R.drawable.restro3,R.drawable.restro4,R.drawable.restro5};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView = (ListView)findViewById(R.id.listview);
        RestaurantsAdapter adapter = new RestaurantsAdapter(this,restro,food,address,contacts,images);
        listView.setAdapter(adapter);

    }
}
