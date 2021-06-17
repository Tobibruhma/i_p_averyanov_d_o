 package com.example.i_p_averyanov_d_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

 public class MainActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {

         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         try {
             TrustManager[] trustAllCerts = new TrustManager[]{
                     new X509TrustManager() {
                         public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                             return null;
                         }

                         public void checkClientTrusted(
                                 java.security.cert.X509Certificate[] certs, String authType) {
                         }

                         public void checkServerTrusted(
                                 java.security.cert.X509Certificate[] certs, String authType) {
                         }
                     }
             };

// Install the all-trusting trust manager
             try {
                 SSLContext sc = SSLContext.getInstance("SSL");
                 sc.init(null, trustAllCerts, new java.security.SecureRandom());
                 HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
             } catch (Exception e) {
             }

// Now you can access an https URL without having the certificate in the truststore
             try {
                 URL url = new URL("https://kitaeza-api.herokuapp.com");
             } catch (MalformedURLException e) {
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
  }




     public void GoToLogin(View view)
     {
         Intent logintent = new Intent(MainActivity.this, LoginActivity.class);
         startActivity(logintent);
     }

     public void GoToReg(View view)
     {
         Intent regint = new Intent(MainActivity.this, RegisterActivity.class);
         startActivity(regint);
     }
 }