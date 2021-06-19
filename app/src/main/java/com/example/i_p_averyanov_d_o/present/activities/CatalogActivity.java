package com.example.i_p_averyanov_d_o.present.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.i_p_averyanov_d_o.databinding.ActivityCatalogBinding;

public class CatalogActivity extends AppCompatActivity {
    ActivityCatalogBinding binding;

//    int productItemsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCatalogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_catalog);
//        InitProductList();
         ;


    }
   


//    List<ProductItem> productItems = new ArrayList<>();
//
//    private void InitProductList() {
//        JsonArrayRequest logonRequest = new JsonArrayRequest(Request.Method.GET,
//                URLs.PRODUCT_ID(productItemsId), null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                try {
//                    InitProductInfo(response);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                makeMessage(error.getMessage(), CatalogActivity.this);
//            }
//        });
//
//        AppData.getInstance(this).queue.add(logonRequest);
//    }
//
//    private void InitProductInfo(JSONArray response) throws JSONException  {
//        for (int i = 0; i < response.length(); i++) {
//            productItems.add(new ProductItem(response.getJSONObject(i)));
//
//        }
//      //  binding.products.setAdapter(new ProductAdapter);
//    }

    public void GoToProduct(View view) {
        Intent prod_intent = new Intent(CatalogActivity.this, ProductActivity.class);
        startActivity(prod_intent);
    }

    public void GoToKolodki(View view)
    {
        Intent kolod_intent = new Intent (CatalogActivity.this, SecProductActivivty.class);
        startActivity(kolod_intent);
    }

    public  void GoToKolodkiPer(View view)
    {
        Intent perkol_intent = new Intent (CatalogActivity.this, KolodkiActivity.class);
        startActivity(perkol_intent);
    }

    public  void GoToGenerator (View view)

    {
        Intent gen_intent = new Intent(CatalogActivity.this, GeneratorActivivty.class);
        startActivity(gen_intent);
    }

    public  void GoToBox (View view)

    {
        Intent gen_intent = new Intent(CatalogActivity.this, BoxActivivty.class);
        startActivity(gen_intent);
    }

    public void GoToBamper (View view)

    {
        Intent bamp_intent = new Intent (CatalogActivity.this, BamperPerActivity.class);
        startActivity(bamp_intent);
    }

    public void GoToBamperZad(View view)
    {
        Intent bamp_intent = new Intent (CatalogActivity.this, BamperZadActivivty.class);
        startActivity(bamp_intent);
    }

    public void GoToCage(View view)
    {
        Intent bamp_intent = new Intent (CatalogActivity.this, CageActivity.class);
        startActivity(bamp_intent);
    }

    public void GoToGlass (View view)
    {
        Intent bamp_intent = new Intent (CatalogActivity.this, GlassActivity.class);
        startActivity(bamp_intent);
    }

    public void GoToPower (View view)

    {
        Intent bamp_intent = new Intent (CatalogActivity.this, PowerActivity.class);
        startActivity(bamp_intent);
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

