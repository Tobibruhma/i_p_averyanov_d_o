package com.example.i_p_averyanov_d_o;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.i_p_averyanov_d_o.databinding.ActivityCatalogBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class CatalogActivity extends AppCompatActivity {
    ActivityCatalogBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCatalogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




    }

    List<ProductItem> productItems = new ArrayList<>();

    private void InitProductList()

    {
//        JsonArrayRequest logonRequest = new JsonArrayRequest(Request.Method.GET, URLs.PRODUCT_ID(productItemsId), null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//
//                    }
//                })
    }

    public void GoToProduct(View view)
    {
        Intent prod_intent = new Intent(CatalogActivity.this, ProductActivity.class);
        startActivity(prod_intent);
    }



}

