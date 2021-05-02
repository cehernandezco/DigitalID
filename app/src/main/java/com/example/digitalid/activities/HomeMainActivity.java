package com.example.digitalid.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.digitalid.R;
import com.example.digitalid.entities.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeMainActivity extends AppCompatActivity {
    private User user;

    public User getUser() {
        return user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intentThatCalled = getIntent();
        if(intentThatCalled.hasExtra(User.USER_KEY)){
            user = (User) intentThatCalled.getSerializableExtra(User.USER_KEY);
        }

        setContentView(R.layout.activity_home_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_account, R.id.navigation_validate)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);




    }

}