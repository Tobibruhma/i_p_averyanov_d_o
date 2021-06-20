package com.example.i_p_averyanov_d_o.present.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.i_p_averyanov_d_o.AppData;
import com.example.i_p_averyanov_d_o.R;
import com.example.i_p_averyanov_d_o.URLs;
import com.example.i_p_averyanov_d_o.adapter.Order.OrderAdapter;
import com.example.i_p_averyanov_d_o.adapter.Order.OrderListener;
import com.example.i_p_averyanov_d_o.adapter.Product.ProductAdapter;
import com.example.i_p_averyanov_d_o.adapter.Product.ProductListener;
import com.example.i_p_averyanov_d_o.data.OrderItem;
import com.example.i_p_averyanov_d_o.data.ProductItem;
import com.example.i_p_averyanov_d_o.databinding.ActivityStoryBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import static com.example.i_p_averyanov_d_o.CheckData.makeMessage;

public class StoryActivity extends AppCompatActivity {

    ActivityStoryBinding binding;
    AppData appData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityStoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        appData =AppData.getInstance(this);
        InitOrderList();
    }
    private void InitOrderList() {
        JsonArrayRequest logonRequest = new JsonArrayRequest(Request.Method.GET,
                URLs.ORDERS_USER(), null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                InitOrderInfo(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                makeMessage(error.getMessage(), StoryActivity.this);
            }
        });

        appData.queue.add(logonRequest);
    }
    //
    private void InitOrderInfo(JSONArray response)  {

        List<OrderItem> productItems = new ArrayList<>();
        for (int i = 0; i < response.length(); i++) {
            try {
                productItems.add(new OrderItem(response.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        if(productItems.size()>0)
            binding.havnt.setVisibility(View.GONE);
        OrderAdapter adapter = new OrderAdapter(appData,getLayoutInflater());
        adapter.setItems(productItems);
        adapter.setListener(new OrderListener() {
            @Override
            public void SelectElement(OrderItem orderItem) {
                GoToOrder(orderItem);
            }
        });
        binding.recycler.setAdapter(adapter);
    }

    private void GoToOrder(OrderItem orderItem) {

    }
}