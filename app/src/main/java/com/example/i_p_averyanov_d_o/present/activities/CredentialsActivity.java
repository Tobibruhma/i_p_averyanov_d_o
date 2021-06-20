package com.example.i_p_averyanov_d_o.present.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
import com.example.i_p_averyanov_d_o.databinding.ActivityCreditionalsBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class CredentialsActivity extends AppCompatActivity {

    ActivityCreditionalsBinding binding;
    AppData appData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreditionalsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        appData = AppData.getInstance(this);
        loaded();
        binding.buttonSaveParams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(_idCredential!=null)
                    SaveParams();
            }
        });
    }
    private void loaded() {
        JsonObjectRequest userReq = new JsonObjectRequest(Request.Method.GET, URLs.CUR_USER(User.getCurrentUser().getId()),
                null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject userData) {
                        JSONObject userCredential = null;
                        try {
                            userCredential = userData.getJSONObject("userCredential");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if( userCredential!=null)
                        {

                            try {
                                _idCredential = userCredential.getString("_id");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                binding.nameInput.setText(userCredential.getString("name"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                binding.sNameInput.setText(userCredential.getString("surname"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                binding.vkInput.setText(userCredential.getString("vkontakte"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                binding.tgInput.setText(userCredential.getString("telegram"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
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
    String _idCredential = null;
    private void SaveParams() {
        JSONObject userData = new JSONObject();
        try {
            userData.put("name",binding.nameInput.getText().toString());
            userData.put("surname",binding.sNameInput.getText().toString());
            userData.put("vkontakte",binding.vkInput.getText().toString());
            userData.put("telegram",binding.tgInput.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest userReq = new JsonObjectRequest(Request.Method.PUT,
                URLs.USER_CREDENTIALS(_idCredential),
                userData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String status = response.getString("status");
                            if(!status.equals("OK"))
                                Toast.makeText(CredentialsActivity.this, "Ошибка", Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(CredentialsActivity.this, "Ошибка", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(CredentialsActivity.this, "Ошибка", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return CheckData.getAuthorizationHeader();
            }
        };
        appData.queue.add(userReq);
    }
}