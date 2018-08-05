package com.example.android.dublin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {
    String[] Hotelname = {"Ashling Hotel", "O'Callaghan Stephens Green", "The Gibson", "Dublin Central Inn", "O'Callaghan Alexander"};
    String[] desp = {"Ashling Hotel is a four star hotel situated a few minutes walk from the center of Dublin. Nearby are located the National Museum of Ireland, a zoo, numerous shops and restaurants.", "O'Callaghan Stephens Green is a wonderfully located hotel in the centre of Dublin overlooking the green Park after which it is named. Guests receive free Wi-Fi connectivity for their stay.", "The Gibson Hotel in Dublin is an urban and modern property in a superb location that allows easy access to many of the city’s attractions. The hotel is home to an on-site restaurant and offers unique spa experiences.", "Dublin Central Inn has a private guest lounge and 24-hour reception. The hotel is in the centre of Dublin, two minutes’ walk from O’Connell Street.", "The O’Callaghan Alexander hotel is a four star property located on Merrion Square in the city of Dublin. It’s located in the city center near the Merrion Square Park and with 102 guest rooms and suites it offers double/king bedded rooms and a junior suite. The airport coach stops near the hotel and car parking is available near the hotel against costs."};
    String[] address = {"Parkgate Street, Dublin 8, Dublin, Ireland", "1-5 Harcourt Street, D2, Dublin, Ireland", "Point Square, 31021, Dublin, Ireland", "95-98 Talbot Street,Dublin,Ireland", "41-47 Fenian Street, D2, Dublin, Ireland"};
    String[] contacts = {"+353 1 677 2324", "+353 1 607 3600", "+353 1 681 5000", "+353 1 874 9202", "+353 1 681 5123"};
    String[] websites = {"www.ashlinghotel.ie", "www.stephensgreenhotel.ie", "www.thegibsonhotel.ie", "www.dublincentralinn.com", "www.thealexdublin.ie"};
    Integer[] images = {R.drawable.ashlin, R.drawable.hotel2, R.drawable.gibson, R.drawable.hotel4, R.drawable.doblinin};
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView)findViewById(R.id.listview);
        HotelsAdapter adapter = new HotelsAdapter(this,Hotelname,desp,address,contacts,websites,images);
        listView.setAdapter(adapter);


    }
}
