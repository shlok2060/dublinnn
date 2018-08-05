package com.example.android.dublin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SportsAdapter extends BaseAdapter {
    Integer[] vimages;
    String[] vsportsname,vaddress;
    Main6Activity context;
    ImageView im1;
    TextView tv1,tv2;

    public SportsAdapter(Main6Activity m1,Integer[] images,String[] sportsname,String[] address){
        context = m1;
        vimages = images;
        vsportsname = sportsname;
        vaddress = address;
    }
    @Override
    public int getCount() {
        return vsportsname.length;
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
        view = context.getLayoutInflater().inflate(R.layout.customadapter5,null);
        tv1 = (TextView)view.findViewById(R.id.textView1);
        tv2 = (TextView)view.findViewById(R.id.textView2);
        im1 = (ImageView)view.findViewById(R.id.imageView1);
        im1.setImageResource(vimages[i]);
        tv1.setText(vsportsname[i]);
        tv2.setText(vaddress[i]);
        return view;
    }
}
