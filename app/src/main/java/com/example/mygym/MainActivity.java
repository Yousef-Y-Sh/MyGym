package com.example.mygym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mygym.Utils.Utils;
import com.example.mygym.activity.GuideActivity;
import com.example.mygym.activity.GuideMenuActivity;
import com.example.mygym.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.item1.setOnClickListener(view -> {
            Utils._Intent(MainActivity.this, GuideMenuActivity.class);
        });
        binding.item2.setOnClickListener(view -> {
            Utils._Intent(MainActivity.this, GuideActivity.class);
        });

    }
}