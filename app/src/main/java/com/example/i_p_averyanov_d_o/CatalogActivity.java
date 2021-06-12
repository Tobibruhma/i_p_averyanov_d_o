package com.example.i_p_averyanov_d_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CatalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
    }

    public void GoToProduct(View view)
    {
        Intent prod_intent = new Intent(CatalogActivity.this, ProductActivity.class);
        startActivity(prod_intent);
    }
}

