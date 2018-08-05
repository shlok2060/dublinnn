package com.example.android.dublin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView im1;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        im1 = (ImageView)findViewById(R.id.imageView);
        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);
        setSupportActionBar(toolbar);


        tv1.setText("Dublin Capital of the Republic of Ireland");
        tv2.setText("Our aim is to help you find popular tourist attractions and places of interest around Dublin including many castles, museums, art galleries, stately homes, royal palaces, zoos, gardens and theme parks.  We provide lots of useful information about the Dublin's favourite tourist attractions including pictures and photos, admission times, opening dates, ticket prices, location maps and contact information, to help you find things to see and do on your visit.\n   " +
                "\nWe also have many guides for tourists visiting Dublin from abroad, packed with information and advice on accommodation, travel advice and other useful information.   " +
                "Read more: http://www.tourist-information-dublin.co.uk");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            Intent intent6 = new Intent(getApplicationContext(),AboutActivity.class);
            startActivity(intent6);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.hotels) {
            Intent intent1 = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent1);
        } else if (id == R.id.restaurant) {
            Intent intent2 = new Intent(getApplicationContext(),Main3Activity.class);
             startActivity(intent2);

        } else if (id == R.id.cafe) {
            Intent intent3 = new Intent(getApplicationContext(),Main4Activity.class);
            startActivity(intent3);
        } else if (id == R.id.beaches) {
            Intent intent4 = new Intent(getApplicationContext(),Main5Activity.class);
            startActivity(intent4);
        } else if (id == R.id.sports) {
            Intent intent5 = new Intent(getApplicationContext(),Main6Activity.class);
            startActivity(intent5);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
