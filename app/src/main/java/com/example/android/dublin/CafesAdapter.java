package com.example.android.dublin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

public class CafesAdapter extends BaseAdapter {
    ArrayList<String> name,food,url_link;
    Main4Activity context;


    public CafesAdapter(Main4Activity context,ArrayList<String> restroname,ArrayList<String> foodtype,ArrayList<String> ImageLink){
       this.context = context;
       name = restroname;
       food = foodtype;
       url_link = ImageLink;

    }
    @Override
    public int getCount() {
        return name.size();
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
        view = context.getLayoutInflater().inflate(R.layout.customadapter3,null);
        NetworkImageView img = (NetworkImageView)view.findViewById(R.id.img1);
        TextView t1 = (TextView)view.findViewById(R.id.tv1);
        ImageLoader imageLoader = customrequest.getInstance(context).getImageLoader();
        img.setImageUrl(url_link.get(i),imageLoader);
        t1.setText(name.get(i));
        return view;


    }
}
