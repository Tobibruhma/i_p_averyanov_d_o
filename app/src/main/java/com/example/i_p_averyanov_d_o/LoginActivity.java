package com.example.i_p_averyanov_d_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.i_p_averyanov_d_o.databinding.ActivityLoginBinding;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        try {
//            TrustManager[] trustAllCerts = new TrustManager[]{
//                    new X509TrustManager() {
//                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                            return null;
//                        }
//
//                        public void checkClientTrusted(
//                                java.security.cert.X509Certificate[] certs, String authType) {
//                        }
//
//                        public void checkServerTrusted(
//                                java.security.cert.X509Certificate[] certs, String authType) {
//                        }
//                    }
//            };
//
//// Install the all-trusting trust manager
//            try {
//                SSLContext sc = SSLContext.getInstance("SSL");
//                sc.init(null, trustAllCerts, new java.security.SecureRandom());
//                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//            } catch (Exception e) {
//            }
//
//// Now you can access an https URL without having the certificate in the truststore
//            try {
//                URL url = new URL("http://kitaeza-api.herokuapp.com");
//            } catch (MalformedURLException e) {
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


        public void GotoHome(View view) {
        if
        (
                //чек на пустоту
                !binding.maleInput.getText().toString().equals("")&&
                        !binding.passInput.getText().toString().equals("")
        )
        {
//            //проверка маила
//        if (CheckData.checkMail(binding.maleInput.getText().toString())) {

                CheckData.authConfirmed(LoginActivity.this,
                        binding.maleInput.getText().toString(),
                        binding.passInput.getText().toString());

//        else
//            {
//                CheckData.makeMessage("Некорректный e-mail", this);
//            }
        }
        else
            {
            CheckData.makeMessage("Еть пустые поля", this);
            }

    }}


//        Intent homeint = new Intent(LoginActivity.this, HomeActivity.class);
//        startActivity(homeint);



