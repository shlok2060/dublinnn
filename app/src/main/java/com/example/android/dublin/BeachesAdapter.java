package com.example.android.dublin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

public class BeachesAdapter extends BaseAdapter {
    ArrayList<String> name,url_link;
    Main5Activity context;

    public BeachesAdapter(Main5Activity context,ArrayList<String> beachname,ArrayList<String> ImageLink){
        this.context = context;
        name = beachname;
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
        view = context.getLayoutInflater().inflate(R.layout.customadapter4,null);
        NetworkImageView img = (NetworkImageView)view.findViewById(R.id.img2);
        TextView t2 = (TextView)view.findViewById(R.id.tv2);
        ImageLoader imageLoader = customrequest.getInstance(context).getImageLoader();
        img.setImageUrl(url_link.get(i),imageLoader);
        t2.setText(name.get(i));
        return view;
    }
}
