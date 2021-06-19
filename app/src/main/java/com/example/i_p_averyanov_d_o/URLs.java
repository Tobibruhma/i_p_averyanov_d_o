package com.example.i_p_averyanov_d_o;

public class URLs
{
    private final static String BASE = "https://kitaeza-api.herokuapp.com/api/";

    public static final String PRODUCTS = BASE+"products/";
    //корневой домен
    public final static String  IMAGE = BASE + "up/images/";
    public final static String REGISTER = BASE +"users/";
    public final static String  LOGIN = BASE + "users/login";
    public final static String CUR_USER = BASE + "users/current";


    public static String PRODUCT_ID (int productItemId)

    {
        return BASE + "product/" + productItemId;
    }

    public  static String CUR_USER(String userId)
    {

        return BASE + "userCredentials/" + userId;
    }


}

