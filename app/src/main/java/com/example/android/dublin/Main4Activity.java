package com.example.android.dublin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.ContextMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    GridView gridView;
    //Progress Bar Variable
    ProgressBar progressBar;
    private int mProgressStatus = 0;
    Handler mHandler = new Handler();
    Boolean flag = true;
    //end of progress Bar variable
    String json_url = "https://api.myjson.com/bins/u9sn2";
    ArrayList<String> restroname = new ArrayList<>();
    ArrayList<String> foodtype = new ArrayList<>();
    ArrayList<String> ImageLink = new ArrayList<>();
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setTitle("Cafe's");
        gridView = (GridView)findViewById(R.id.gridview);
        progressBar = (ProgressBar)findViewById(R.id.cafe_progressBar);

        jsondata();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(mProgressStatus);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                        gridView.setVisibility(View.VISIBLE);

                    }
                });
            }
        }).start();



    }

    @Override
    public void onBackPressed() {
        Intent intent6 = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent6);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        index = info.position;
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "SMS");
        menu.add(0, v.getId(), 0, "WhatsApp");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Call"){
            Uri number = Uri.parse("tel:123456789");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
            startActivity(callIntent);
            return true;
        }
        else if(item.getTitle()=="SMS"){
            String num = "smsto: 9795200506";
            Intent smsintent = new Intent(Intent.ACTION_SENDTO,Uri.parse(num));
            smsintent.putExtra("smsbody","Welcome to citydetails");
            startActivity(smsintent);

            return true;
        }else if(item.getTitle()=="WhatsApp"){
            Intent whtsapp =new Intent();
            whtsapp.setAction(Intent.ACTION_SEND);
            whtsapp.putExtra(Intent.EXTRA_TEXT,"Welcome to CityDetails");
            whtsapp.setType("text/plain");
            whtsapp.setPackage("com.whatsapp");
            startActivity(whtsapp);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public  void jsondata()
    {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, json_url,  null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray =response.getJSONArray("Cafe");

                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject jsonObject =jsonArray.getJSONObject(i);

                                restroname.add(jsonObject.getString("name"));
                                foodtype.add(jsonObject.getString("theme"));
                                ImageLink.add(jsonObject.getString("url"));


                            }
                            if(restroname.size() > 0)
                            {
                                flag = false;
                            }
                            CafesAdapter imageAdapterCafe = new CafesAdapter(Main4Activity.this,restroname,foodtype,ImageLink);
                            gridView.setAdapter(imageAdapterCafe);
                            registerForContextMenu(gridView);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        customrequest.getInstance(this).addToRequestQue(jsonObjectRequest);
    }
}
