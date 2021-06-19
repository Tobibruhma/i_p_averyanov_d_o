package com.example.i_p_averyanov_d_o.present.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.i_p_averyanov_d_o.AppData;
import com.example.i_p_averyanov_d_o.ProductItem;
import com.example.i_p_averyanov_d_o.R;
import com.example.i_p_averyanov_d_o.databinding.ActivityProductBinding;

import static android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD;

public class ProductActivity extends AppCompatActivity {

    ActivityProductBinding productBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productBinding  = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(productBinding.getRoot());
        ProductItem item = AppData.SelectElementInCatalog;
        if(item==null)
            finish();
        else {
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
        Toast.makeText(getApplicationContext(),"Товар добавлен в корзину", Toast.LENGTH_SHORT).show();
    }

    public void GoToStory(View view)
    {
        Intent story = new Intent (ProductActivity.this, StoryActivity.class);
        startActivity(story);
    }
}