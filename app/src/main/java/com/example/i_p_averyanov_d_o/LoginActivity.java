package com.example.i_p_averyanov_d_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.i_p_averyanov_d_o.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void GotoHome(View view) {
//        if(
//                //чек на пустоту
//                !binding.maleInput.getText().toString().equals("")&&
//                        !binding.passInput.getText().toString().equals("")
//        )
//        {
//            //проверка маила
////            if(CheckData.checkMail(binding.maleInput.getText().toString())) {
//    if (  !binding.maleInput.getText().toString().equals("")) {
//                CheckData.authConfirmed(LoginActivity.this,
//                        binding.maleInput.getText().toString(),
//                        binding.passInput.getText().toString());
//            }
//
//                else
//                {
//                    CheckData.makeMessage("Некорректный e-mail",this);
//                }
//            }
//        else
//            {
//            CheckData.makeMessage("Еть пустые поля",this);
//        }
//
//    }
        Intent homeint = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(homeint);
    }
}

