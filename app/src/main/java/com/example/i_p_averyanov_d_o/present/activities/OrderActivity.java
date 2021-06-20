package com.example.i_p_averyanov_d_o.present.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.i_p_averyanov_d_o.AppData;
import com.example.i_p_averyanov_d_o.CheckData;
import com.example.i_p_averyanov_d_o.R;
import com.example.i_p_averyanov_d_o.URLs;
import com.example.i_p_averyanov_d_o.User;
import com.example.i_p_averyanov_d_o.adapter.Instance.InstanceAdapter;
import com.example.i_p_averyanov_d_o.adapter.Instance.InstanceListener;
import com.example.i_p_averyanov_d_o.data.Instance;
import com.example.i_p_averyanov_d_o.databinding.ActivityOrderBinding;
import com.example.i_p_averyanov_d_o.databinding.FragmentBasketBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;
        String orderId;
    AppData appData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        appData = AppData.getInstance(this);
        String state =  getIntent().getStringExtra("state");
        binding.stateView.setText(state);
        orderId = getIntent().getStringExtra("orderId");
        loadedOrder();
    }

    private void loadedOrder() {
        Toast.makeText(this, "Загрузка...", Toast.LENGTH_SHORT).show();
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, URLs.ORDER(orderId), null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                initProductsEx(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return CheckData.getAuthorizationHeader();
            }
        };
        appData.queue.add(arrayRequest);
    }
    List<Instance> instanceList = new ArrayList<>();
    private void initProductsEx(JSONArray response) {
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject productElementInfo = response.getJSONObject(i);
                instanceList.add(new Instance(productElementInfo));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        InstanceAdapter adapter = new InstanceAdapter(appData,getLayoutInflater());
        binding.recycler.setAdapter(adapter);
        adapter.setItems(instanceList);
        adapter.setListener(new InstanceListener() {
            @Override
            public void SelectElement(Instance instanceItem) {

            }
        });
        InitSum();
    }

    private void InitSum() {
        if(instanceList.size()>0)
        {
            binding.havnt.setVisibility(View.GONE);
            double fullPrice = 0;
            for (Instance instance : instanceList) {
                if(instance.productItem!=null)
                    fullPrice+=instance.productItem.price;
            }
            binding.fullPrice.setText(CheckData.returnStringPrice(fullPrice));
            binding.pricePanel.setVisibility(View.VISIBLE);
        }
        else {
            binding.pricePanel.setVisibility(View.GONE);
//            if(instanceList.isEmpty())binding.havnt.setVisibility(View.GONE);
        }
    }
}