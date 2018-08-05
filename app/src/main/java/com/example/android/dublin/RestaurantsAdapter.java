package com.example.android.dublin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantsAdapter extends BaseAdapter {
    String[] vrestro,vfood,vaddress,vcontacts;
    Integer[] vimages;
    Main3Activity context;
    TextView tv1,tv2,tv3,tv4;
    ImageView im1;

    public RestaurantsAdapter(Main3Activity m1, String[] restro,String[] food,String[] address, String[] contacts,Integer[] images){
        context = m1;
        vrestro = restro;
        vfood = food;
        vaddress = address;
        vcontacts = contacts;
        vimages = images;
    }
    @Override
    public int getCount() {
        return vrestro.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = context.getLayoutInflater().inflate(R.layout.customadapter2,null);
        tv1 = (TextView)view.findViewById(R.id.textView1);
        tv2 = (TextView)view.findViewById(R.id.textView2);
        tv3 = (TextView)view.findViewById(R.id.textView3);
        tv4 = (TextView)view.findViewById(R.id.textView4);
        im1 = (ImageView)view.findViewById(R.id.imageView2);
        tv1.setText(vrestro[i]);
        tv2.setText(vfood[i]);
        tv3.setText(vaddress[i]);
        tv4.setText(vcontacts[i]);
        im1.setImageResource(vimages[i]);
        return view;
    }
}
