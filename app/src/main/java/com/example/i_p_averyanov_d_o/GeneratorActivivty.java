package com.example.i_p_averyanov_d_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class GeneratorActivivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator_activivty);
    }

    public void GoBackToCatalog(View view)
    {
        Intent cat_intent = new Intent (GeneratorActivivty.this, CatalogActivity.class);
        startActivity(cat_intent);
    }




    public void GoToBucket(View view)
    {
        Toast.makeText(getApplicationContext(),"Товар добавлен в корзину", Toast.LENGTH_SHORT);
    }

    public void GoToStory(View view)
    {
        Intent story = new Intent (GeneratorActivivty.this, StoryActivity.class);
        startActivity(story);
    }
}

