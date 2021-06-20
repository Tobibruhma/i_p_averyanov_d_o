package com.example.i_p_averyanov_d_o.data;

import com.example.i_p_averyanov_d_o.CheckData;

import org.json.JSONException;
import org.json.JSONObject;

public class OrderItem
{
    public  final  static String STATUS = "status";
    public  final  static String ID = "_id";
    private String status;
    private String id;



    public OrderItem(JSONObject movieJson) throws JSONException {
        status = movieJson.getString(STATUS);
        id    = movieJson.getString(ID);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
