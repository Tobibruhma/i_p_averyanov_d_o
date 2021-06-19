package com.example.i_p_averyanov_d_o.present.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.i_p_averyanov_d_o.R;

public class BamperPerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bamper_per);
    }


    public void GoBackToCatalog(View view)
    {
        Intent cat_intent = new Intent (BamperPerActivity.this, CatalogActivity.class);
        startActivity(cat_intent);
    }




    public void GoToBucket(View view)
    {
        Toast.makeText(getApplicationContext(),"Товар добавлен в корзину", Toast.LENGTH_SHORT);
    }

    public void GoToStory(View view)
    {
        Intent story = new Intent (BamperPerActivity.this, StoryActivity.class);
        startActivity(story);
    }
}