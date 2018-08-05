package com.example.android.dublin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HotelsAdapter extends BaseAdapter {
    String[] vHotelname,vdesp,vaddress,vcontacts,vwebsites;
    Integer[] vimages;
    Main2Activity context;
    ImageView im1;
    TextView tv1,tv2,tv3,tv4,tv5;

    public HotelsAdapter(Main2Activity m1,String[] Hotelname,String[] desp,String[] address,String[] contacts,String[] websites,Integer[] images){
        context = m1;
        vHotelname = Hotelname;
        vdesp = desp;
        vaddress = address;
        vcontacts = contacts;
        vwebsites = websites;
        vimages = images;
    }
    @Override
    public int getCount() {
        return vHotelname.length;
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
        view = context.getLayoutInflater().inflate(R.layout.customadapter1,null);
        tv1 = (TextView)view.findViewById(R.id.textView1);
        tv2 = (TextView)view.findViewById(R.id.textView2);
        tv3 = (TextView)view.findViewById(R.id.textView3);
        tv4 = (TextView)view.findViewById(R.id.textView4);
        tv5 = (TextView)view.findViewById(R.id.textView5);
        im1 = (ImageView)view.findViewById(R.id.imageView2);
        tv1.setText(vHotelname[i]);
        tv2.setText(vdesp[i]);
        tv3.setText(vaddress[i]);
        tv4.setText(vcontacts[i]);
        tv5.setText(vwebsites[i]);
        im1.setImageResource(vimages[i]);
        return view;
    }
}
