package com.example.i_p_averyanov_d_o.present.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.i_p_averyanov_d_o.AppData;
import com.example.i_p_averyanov_d_o.CheckData;
import com.example.i_p_averyanov_d_o.R;
import com.example.i_p_averyanov_d_o.URLs;
import com.example.i_p_averyanov_d_o.User;
import com.example.i_p_averyanov_d_o.adapter.Instance.InstanceAdapter;
import com.example.i_p_averyanov_d_o.adapter.Instance.InstanceListener;
import com.example.i_p_averyanov_d_o.data.Instance;
import com.example.i_p_averyanov_d_o.databinding.FragmentBasketBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasketFragment extends Fragment {

    FragmentBasketBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBasketBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    AppData appData;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appData = AppData.getInstance(getContext());
        loadedBasket();
    }


    private void loadedBasket() {
        Toast.makeText(getContext(), "Загрузка...", Toast.LENGTH_SHORT).show();
        String kek = User.getCurrentUser().basketId;
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, URLs.PRODUCTS_CUR_BASKET(), null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               initProductsEx(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return CheckData.getAuthorizationHeader();
            }
        };
        appData.queue.add(arrayRequest);
    }

    List<Instance> instanceList = new ArrayList<>();
    private void initProductsEx(JSONArray response) {
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject productElementInfo = response.getJSONObject(i);
                instanceList.add(new Instance(productElementInfo));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        InstanceAdapter adapter = new InstanceAdapter(appData,getLayoutInflater());
        binding.recycler.setAdapter(adapter);
        adapter.setItems(instanceList);
        adapter.setListener(new InstanceListener() {
            @Override
            public void SelectElement(Instance instanceItem) {

            }
        });
        InitSum();
    }

    private void InitSum() {
        if(instanceList.size()>0)
        {

            binding.havnt.setVisibility(View.GONE);
            double fullPrice = 0;
            for (Instance instance : instanceList) {
                if(instance.productItem!=null)
                    fullPrice+=instance.productItem.price;
            }
            binding.fullPrice.setText(CheckData.returnStringPrice(fullPrice));
            binding.pricePanel.setVisibility(View.VISIBLE);
        }
        else {
            binding.pricePanel.setVisibility(View.GONE);

//            if(instanceList.isEmpty())binding.havnt.setVisibility(View.GONE);
        }
    }

}