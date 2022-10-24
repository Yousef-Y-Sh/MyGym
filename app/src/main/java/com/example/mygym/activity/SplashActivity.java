package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.example.mygym.MainActivity;
import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Utils._IntentWithClearTask(SplashActivity.this, MainActivity.class);
            }
        }, 3000);
    }
}