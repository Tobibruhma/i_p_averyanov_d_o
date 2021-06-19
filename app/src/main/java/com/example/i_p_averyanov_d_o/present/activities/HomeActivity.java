package com.example.i_p_averyanov_d_o.present.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.i_p_averyanov_d_o.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {
    EditText search_text;
    TextView mailtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_profile)
//                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

//        mailtext = findViewById(R.id.mailtext);
//        mailtext.setText(User.EMAIL);


    }

    public void GoToCatalog(View view)
    {
        Intent cat_intent = new Intent(HomeActivity.this, CatalogActivity.class);
        startActivity(cat_intent);
    }

    public void GoToStory(View view)
    {
        Intent stor_intet = new Intent(HomeActivity.this, StoryActivity.class);
        startActivity(stor_intet);
    }

    public void GoToCreditionals(View view)
    {
        Intent cred_intent = new Intent (HomeActivity.this, CreditionalsActivity.class);
        startActivity(cred_intent);
    }

    public void GoToVk(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ru.stackoverflow.com/questions/559956/%D0%9A%D0%B0%D0%BA-%D0%BF%D0%BE-%D0%BD%D0%B0%D0%B6%D0%B0%D1%82%D0%B8%D1%8E-%D0%BD%D0%B0-button-%D0%BF%D0%B5%D1%80%D0%B5%D0%B9%D1%82%D0%B8-%D0%BD%D0%B0-%D1%81%D0%B0%D0%B9%D1%82"));
        startActivity(intent);
    }

    public void GoToSite(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://kitaeza.herokuapp.com/"));startActivity(intent);
    }

    public void GoToMap(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/maps/place/%D0%9A%D0%B8%D1%82%D0%B0%D1%91%D0%B7%D0%B0,+%D0%B0%D0%B2%D1%82%D0%BE%D0%B7%D0%B0%D0%BF%D1%87%D0%B0%D1%81%D1%82%D0%B8+%D0%BD%D0%B0+%D0%BA%D0%B8%D1%82%D0%B0%D0%B9%D1%81%D0%BA%D0%B8%D0%B5+%D0%B0%D0%B2%D1%82%D0%BE,+%D0%9B%D0%B8%D1%84%D0%B0%D0%BD,+%D0%94%D0%B6%D0%B8%D0%BB%D0%B8,+%D0%A7%D0%B5%D1%80%D0%B8+%D0%B8+%D1%82.%D0%B4/@64.3933983,105.3079545,3z/data=!4m5!3m4!1s0x417bf6a46ccfcbe3:0xa309ebb11b8c68fe!8m2!3d64.3933983!4d105.3079545"));startActivity(intent);
    }

    public void Search(View view)
    {

    }
}