package com.example.digitalid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.digitalid.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}