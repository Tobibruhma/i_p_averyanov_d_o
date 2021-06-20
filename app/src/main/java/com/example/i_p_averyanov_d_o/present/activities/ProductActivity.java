package com.example.i_p_averyanov_d_o.present.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.i_p_averyanov_d_o.AppData;
import com.example.i_p_averyanov_d_o.CheckData;
import com.example.i_p_averyanov_d_o.URLs;
import com.example.i_p_averyanov_d_o.User;
import com.example.i_p_averyanov_d_o.data.ProductItem;
import com.example.i_p_averyanov_d_o.databinding.ActivityProductBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.Map;

import static android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD;

public class ProductActivity extends AppCompatActivity {

    ActivityProductBinding productBinding;
    AppData appData;
    String productId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productBinding  = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(productBinding.getRoot());
        appData = AppData.getInstance(this);
        ProductItem item = AppData.SelectElementInCatalog;
        if(item==null)
            finish();
        else {
            productId = item.getId();
            productBinding.setProduct(item);
            AppData.getInstance(this).loadedImage(productBinding.mainImage,
                    item.getImageurl());
            if(item.getDescription().isEmpty()) {
                productBinding.desc.setVisibility(View.GONE);
                productBinding.descTitle.setVisibility(View.GONE);
            }
            else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                productBinding.desc.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
            }

        }

    }

    public void GoBackToCatalog(View view)
    {
        super.onBackPressed();
//        Intent cat_intent = new Intent (ProductActivity.this, CatalogActivity.class);
//        startActivity(cat_intent);
    }




    public void GoToBucket(View view)
    {
//        Toast.makeText(getApplicationContext(),"Товар добавлен в корзину", Toast.LENGTH_SHORT).show();
        if(User.getCurrentUser().basketId!=null){
        JSONObject data = new JSONObject();
        try {
            data.put("product",productId);
            data.put("basket", User.getCurrentUser().basketId);
            data.put("amount", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST,
                URLs.ADD_PRODUCT_IN_BASKET,
                data, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(getApplicationContext(), "Успешно", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return CheckData.getAuthorizationHeader();
            }
        };
        appData.queue.add(objectRequest);
    }
        else Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show();
    }

    public void GoToStory(View view)
    {
        Intent story = new Intent (ProductActivity.this, StoryActivity.class);
        startActivity(story);
    }
}