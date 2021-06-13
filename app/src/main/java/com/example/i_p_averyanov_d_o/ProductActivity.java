package com.example.i_p_averyanov_d_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }

    public void GoBackToCatalog(View view)
    {
        Intent cat_intent = new Intent (ProductActivity.this, CatalogActivity.class);
        startActivity(cat_intent);
    }
}