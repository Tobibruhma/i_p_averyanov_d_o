package com.example.i_p_averyanov_d_o.present.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.i_p_averyanov_d_o.R;

public class SecProductActivivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_product_activivty);
    }

    public void GoBackToCatalog(View view)
    {
        Intent goback = new Intent (SecProductActivivty.this, CatalogActivity.class);
        startActivity(goback);
    }

    public void GoToStory(View view)
    {
        Intent gostory = new Intent (SecProductActivivty.this, StoryActivity.class);
        startActivity(gostory);
    }


        public void GoToBucket(View view)
        {
            Toast.makeText(getApplicationContext(),"Товар добавлен в корзину", Toast.LENGTH_SHORT);
        }

}