package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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
        binding.toolbar.title.setText("دليل التمارين");
        binding.toolbar.backImg.setOnClickListener(view -> {
            finish();
        });

        binding.chest.setOnClickListener(view -> {
            Intent intent = new Intent(activity, ExerciseGuideActivity.class);
            intent.putExtra("title", Utils._GetText(binding.chestTV));
            intent.putExtra("type", Utils.__CHESTGUIDS);
            startActivity(intent);
        });

        binding.shoulders.setOnClickListener(view -> {
            Intent intent = new Intent(activity, ExerciseGuideActivity.class);
            intent.putExtra("title", Utils._GetText(binding.shouldersTV));
            intent.putExtra("type", Utils.__SHOULDERSGUIDS);
            startActivity(intent);
        });

        binding.back.setOnClickListener(view -> {
            Intent intent = new Intent(activity, ExerciseGuideActivity.class);
            intent.putExtra("title", Utils._GetText(binding.backTV));
            intent.putExtra("type", Utils.__BACKGUIDS);
            startActivity(intent);
        });
        binding.legs.setOnClickListener(view -> {
            Intent intent = new Intent(activity, ExerciseGuideActivity.class);
            intent.putExtra("title", Utils._GetText(binding.legsTV));
            intent.putExtra("type", Utils.__LEGSGUIDS);
            startActivity(intent);
        });

        binding.stomach.setOnClickListener(view -> {
            Intent intent = new Intent(activity, ExerciseGuideActivity.class);
            intent.putExtra("title", Utils._GetText(binding.stomachTV));
            intent.putExtra("type", Utils.__STOMACHGUIDS);
            startActivity(intent);
        });
        binding.baycep.setOnClickListener(view -> {
            Intent intent = new Intent(activity, ExerciseGuideActivity.class);
            intent.putExtra("title", Utils._GetText(binding.baycepTV));
            intent.putExtra("type", Utils.__BAYCEPSGUIDS);
            startActivity(intent);
        });
        binding.triceps.setOnClickListener(view -> {
            Intent intent = new Intent(activity, ExerciseGuideActivity.class);
            intent.putExtra("title", Utils._GetText(binding.tricepsTV));
            intent.putExtra("type", Utils.__TRICEPSGUIDS);
            startActivity(intent);
        });
        binding.forearms.setOnClickListener(view -> {
            Intent intent = new Intent(activity, ExerciseGuideActivity.class);
            intent.putExtra("title", Utils._GetText(binding.forearmsTV));
            intent.putExtra("type", Utils.__FOREAMRMSGUIDS);
            startActivity(intent);
        });
    }
}