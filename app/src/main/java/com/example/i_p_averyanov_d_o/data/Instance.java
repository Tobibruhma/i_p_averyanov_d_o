package com.example.i_p_averyanov_d_o.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Instance {
    public String id;
    public int amount;
    public ProductItem productItem;
    public Instance(JSONObject object) throws JSONException {
        id = object.getString("_id");
        amount = object.getInt("amount");
        try {
            productItem = new ProductItem((JSONObject) object.getJSONArray("instanceDetails").get(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
