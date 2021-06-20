package com.example.i_p_averyanov_d_o.data;

import com.example.i_p_averyanov_d_o.CheckData;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductItem
{
    public  final  static String TITLE = "title";
    public  final  static String ID = "_id";
    public  final  static String DESCRIPRTION = "description";
    public  final  static String PRICE = "price";
    public final static String IMAGEURL = "imageurl";
    public final static String SUBTITLE = "subtitle";
    private String title;
    private String id;
    private String description;
    public double price;
    private String subtitle;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String imageurl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductItem(JSONObject movieJson) throws JSONException {
        title = movieJson.getString(TITLE);
        description  = movieJson.getString(DESCRIPRTION);
        price    = movieJson.getDouble(PRICE);
        imageurl    = movieJson.getString(IMAGEURL);
        subtitle    = movieJson.getString(SUBTITLE);
        id    = movieJson.getString(ID);
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getPrice() {
        return CheckData.returnStringPrice(price);
    }


    public String getImageurl(){return  imageurl;}
    public void  setImageurl(String imageurl){this.imageurl=imageurl;}
}
