package com.example.i_p_averyanov_d_o;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
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
}