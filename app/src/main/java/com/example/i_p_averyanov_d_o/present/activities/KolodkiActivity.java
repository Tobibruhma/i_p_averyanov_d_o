package com.example.i_p_averyanov_d_o.present.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.i_p_averyanov_d_o.R;

public class KolodkiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolodki);
    }

    public void GoBackToCatalog(View view)
    {
        Intent goback = new Intent (KolodkiActivity.this, CatalogActivity.class);
        startActivity(goback);
    }

    public void GoToOrder(View view)
    {
        Intent goorder = new Intent (KolodkiActivity.this, StoryActivity.class);
        startActivity(goorder);
    }

    public void GoToBucket(View view)
    {
        Toast.makeText(getApplicationContext(),"Товар добавлен в корзину", Toast.LENGTH_SHORT);

    }
}