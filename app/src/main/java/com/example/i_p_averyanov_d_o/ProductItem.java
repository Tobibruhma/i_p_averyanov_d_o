package com.example.i_p_averyanov_d_o;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductItem
{
    public  final  static String TITLE = "title";
    public  final  static String DESCRIPRTION = "description";
    public  final  static String PRICE = "price";
    public final static String IMAGEURL = "images";
    private String title;
    private String description;
    private String price;
    private String imageurl;

    public ProductItem(JSONObject movieJson) throws JSONException {
        title = movieJson.getString(TITLE);
        description  = movieJson.getString(DESCRIPRTION);
        price    = movieJson.getString(PRICE);
        imageurl    = movieJson.getString(IMAGEURL);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriprtion() {
        return description;
    }

    public void setDescriprtion(String description) {
        this.description = description;
    }

    public String getPrice() {
        return description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageurl(){return  imageurl;}
    public void  setImageurl(String imageurl){this.imageurl=imageurl;}
}
