package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;

import com.example.mygym.R;
import com.example.mygym.databinding.ActivityTrainingDaysBinding;
import com.example.mygym.moudle.MyGuide;

public class TrainingDaysActivity extends AppCompatActivity {
    ActivityTrainingDaysBinding binding;
    private MyGuide myGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrainingDaysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.backImg.setOnClickListener(view -> finish());

        Bundle b = getIntent().getExtras();
        if (b != null) {
            myGuide = b.getParcelable("object");
            binding.toolbar.title.setText(myGuide.getName());
        }
    }
}