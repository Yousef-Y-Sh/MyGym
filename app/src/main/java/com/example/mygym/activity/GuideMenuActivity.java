package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.databinding.ActivityGuideMenuBinding;

public class GuideMenuActivity extends AppCompatActivity {
    ActivityGuideMenuBinding binding;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuideMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = GuideMenuActivity.this;
        binding.chest.setOnClickListener(view -> Utils._Intent(activity, ChestActivity.class));
        binding.shoulders.setOnClickListener(view -> Utils._Intent(activity, ShouldersActivity.class));
        binding.back.setOnClickListener(view -> Utils._Intent(activity, BackActivity.class));
        binding.legs.setOnClickListener(view -> Utils._Intent(activity, LegsActivity.class));
        binding.stomach.setOnClickListener(view -> Utils._Intent(activity, StomachActivity.class));
        binding.baycep.setOnClickListener(view -> Utils._Intent(activity, BaycepsActivity.class));
        binding.triceps.setOnClickListener(view -> Utils._Intent(activity, TricepsActivite.class));
        binding.forearms.setOnClickListener(view -> Utils._Intent(activity, ForearmsActivity.class));
    }
}