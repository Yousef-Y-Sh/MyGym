package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.databinding.ActivityGuideBinding;

public class GuideActivity extends AppCompatActivity {
    ActivityGuideBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.floating.setOnClickListener(view -> Utils._Intent(GuideActivity.this,AddGuideActivity.class));
    }
}