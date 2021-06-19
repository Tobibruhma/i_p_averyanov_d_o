package com.example.i_p_averyanov_d_o;

import android.content.Context;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

public class AppData
{
    public  static String token;
    private static AppData instance;
    private final RequestManager glide;

    public static AppData getInstance(Context context) {
        if(instance==null)
            instance =new AppData(context.getApplicationContext());
        return instance;
    }

    public RequestQueue queue;
    public AppData(Context context) {
        queue = Volley.newRequestQueue(context);
        glide = Glide.with(context);
    }

    public void loadedImage(ImageView imageView, String url) {
        glide.load(url)
                .into(imageView);
    }
//    public void loadImage(String url, ImageView imageView)
//    {
//        glide.load(URLs.IMAGE+url).into(imageView);
//    }
}
