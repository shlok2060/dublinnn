package com.example.android.dublin;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class customrequest {private  static customrequest rInstance;
    private RequestQueue requestQueue;
    private static Context mcontext;
    private ImageLoader mImageLoader;

    private customrequest(Context context){
        mcontext = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(mcontext.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized customrequest getInstance(Context context){
        if(rInstance==null){
            rInstance = new customrequest(context);
        }
        return rInstance;
    }
    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.requestQueue, new MyLruCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQue(Request<T> request)
    {
        requestQueue.add(request);
    }
}
