package com.example.i_p_averyanov_d_o.present.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.i_p_averyanov_d_o.AppData;
import com.example.i_p_averyanov_d_o.data.ProductItem;
import com.example.i_p_averyanov_d_o.URLs;
import com.example.i_p_averyanov_d_o.adapter.Product.ProductAdapter;
import com.example.i_p_averyanov_d_o.adapter.Product.ProductListener;
import com.example.i_p_averyanov_d_o.databinding.ActivityCatalogBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import static com.example.i_p_averyanov_d_o.CheckData.makeMessage;

public class CatalogActivity extends AppCompatActivity {
    ActivityCatalogBinding binding;
    AppData appData;
//    int productItemsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCatalogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        appData =AppData.getInstance(this);
        InitProductList();



    }
   


//
    private void InitProductList() {
        JsonArrayRequest logonRequest = new JsonArrayRequest(Request.Method.GET,
                URLs.PRODUCTS, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    InitProductInfo(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                makeMessage(error.getMessage(), CatalogActivity.this);
            }
        });

        appData.queue.add(logonRequest);
    }
//
    private void InitProductInfo(JSONArray response) throws JSONException  {

        List<ProductItem> productItems = new ArrayList<>();
        for (int i = 0; i < response.length(); i++) {
            productItems.add(new ProductItem(response.getJSONObject(i)));

        }
        ProductAdapter adapter = new ProductAdapter(appData,getLayoutInflater());
        adapter.setItems(productItems);
        adapter.setListener(new ProductListener() {
            @Override
            public void SelectElement(ProductItem productItem) {
                GoToProduct(productItem);
            }
        });
        binding.products.setAdapter(adapter);
    }

    public void GoToProduct(ProductItem productItem) {
        Intent prod_intent = new Intent(CatalogActivity.this, ProductActivity.class);
        AppData.SelectElementInCatalog = productItem;
        prod_intent.putExtra(ProductItem.ID,productItem.getId());
        startActivity(prod_intent);
    }


//    private class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
//        public class ViewHolder extends RecyclerView.ViewHolder {
//
//              binding;
//            public ViewHolder(@NonNull View itemView) {
//                super(itemView);
//            }
//        }
//    }
}





//    private void initEpisodesInfo(JSONArray response) {
//    }

