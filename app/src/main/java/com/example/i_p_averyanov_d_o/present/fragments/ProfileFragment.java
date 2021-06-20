package com.example.i_p_averyanov_d_o.present.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.i_p_averyanov_d_o.databinding.FragmentProfileBinding;
import com.example.i_p_averyanov_d_o.present.activities.CredentialsActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    AppData appData;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appData = AppData.getInstance(getContext());
        loaded();

        initStartParamsMove();
    }

    private void loaded() {
        String val = URLs.CUR_USER(User.getCurrentUser().getId());
        JsonObjectRequest userReq = new JsonObjectRequest(Request.Method.GET, URLs.CUR_USER(User.getCurrentUser().getId()),
                null,
        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject userData = response.getJSONObject("userCredential");
                    binding.mailtext.setText(userData.getString("email"));
                    appData.loadedImage(binding.imageView,userData.getString("imagerul"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                }
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
        appData.queue.add(userReq);
    }

    private void initStartParamsMove() {
        binding.goToStoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cred_intent = new Intent (getContext(), CredentialsActivity.class);
                startActivity(cred_intent);
            }
        });
    }
}