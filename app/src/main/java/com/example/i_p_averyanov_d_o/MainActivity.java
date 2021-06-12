 package com.example.i_p_averyanov_d_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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