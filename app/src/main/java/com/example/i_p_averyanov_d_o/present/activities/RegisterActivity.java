package com.example.i_p_averyanov_d_o.present.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.i_p_averyanov_d_o.AppData;
import com.example.i_p_averyanov_d_o.CheckData;
import com.example.i_p_averyanov_d_o.URLs;
import com.example.i_p_averyanov_d_o.databinding.ActivityRegisterBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

    public void RegToLog(View view)
    {
        if(
                !binding.maleInput.getText().toString().equals("")&&
                        !binding.passInput.getText().toString().equals("")
        )
        {
            //проверка маила
            if(CheckData.checkMail(binding.maleInput.getText().toString()))
            {

                    JSONObject user = new JSONObject();
                    try {
                        user.put("email",      binding.maleInput.getText().toString());
                        user.put("password",   binding.passInput.getText().toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                            URLs.REGISTER, user,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    if(error.getMessage()!=null)
                                    {
                                        if(error.getMessage().contains("Успешная")){
                                            //->авторизацию
                                            CheckData.authConfirmed(RegisterActivity.this,
                                                    binding.maleInput.getText().toString(),
                                                    binding.passInput.getText().toString());
                                        }    else
                                            CheckData.makeMessage("Проблема с регистрацией ошибка", RegisterActivity.this);

                                    }    else
                                        CheckData.makeMessage("Проблема с регистрацией ошибка", RegisterActivity.this);

                                }
                            });

                    JsonObjectRequest signUpRequest = new JsonObjectRequest(Request.Method.POST,
                            URLs.REGISTER, user, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            //будет вызывать авторизацию
                            CheckData.authConfirmed(RegisterActivity.this,
                                    binding.maleInput.getText().toString(),
                                    binding.passInput.getText().toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if(Objects.requireNonNull(error.getMessage()).contains("Успешная"))
                            {

                                //будет вызывать авторизацию
                                CheckData.authConfirmed(RegisterActivity.this,
                                        binding.maleInput.getText().toString(),
                                        binding.passInput.getText().toString());
                            }
                            else
                                CheckData.makeMessage("Проблема с регистрацией ошибка", RegisterActivity.this);
                        }
                    });
                    AppData.getInstance(this).queue.add(signUpRequest);
                }
                else
                {
                    CheckData.makeMessage("Пароли не совпадают",this);
                }
            }
            else
            {
                CheckData.makeMessage("Некорректный e-mail",this);
            }
        }


}

//        Intent Regintent = new Intent(RegisterActivity.this, LoginActivity.class);
//        startActivity(Regintent);

