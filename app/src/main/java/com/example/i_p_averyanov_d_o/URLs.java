package com.example.i_p_averyanov_d_o;

import android.widget.BaseAdapter;

public class URLs
{
    private final static String BASE = "https://kitaeza-api.herokuapp.com/api/";
    public final  static String ADD_PRODUCT_IN_BASKET=BASE+"productInstances";

    public static  String PRODUCTS_CUR_BASKET() {
        return BASE + "baskets/getProductsFromInstancesOfBasket/" + User.getCurrentUser().basketId;
    }

    public static String ORDERS_USER() {return BASE+"orders/ordersbyuser/"+User.getCurrentUser().getId();}
    public static final String PRODUCTS = BASE+"products/";
    //корневой домен
    public final static String  IMAGE = BASE + "up/images/";
    public final static String REGISTER = BASE +"users/";
    public final static String  LOGIN = BASE + "users/login";
    public final static String CUR_USER = BASE + "users/current";


    public static final String BASKET_USER = BASE +"baskets/basketsbyuser/"+User.getCurrentUser().getId();

    public static String PRODUCT_ID (int productItemId)
    {
        return BASE + "product/" + productItemId;
    }

    public  static String CUR_USER(String userId)
    {

        return BASE + "userCredentials/credsbyuserid/" + userId;
    }
  public  static String ORDERS_USER(String userId)
    {

        return BASE + "/orders/ordersbyuser/" + userId;
    }


    public static String USER_CREDENTIALS(String idCredential) {
        return  BASE +"userCredentials/"+idCredential;
    }

    public static String BUY=
         BASE+"baskets/basketToOrderEmailNotify";

    public static String ORDER(String orderId) {
        return  BASE+"orders/instancesWithProductByOrderId/"+orderId;
    }
}

