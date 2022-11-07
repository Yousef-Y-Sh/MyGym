package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.adapter.AllDaysAdapter;
import com.example.mygym.adapter.GuideAdapter;
import com.example.mygym.database.MyDataBase;
import com.example.mygym.databinding.ActivityTrainingDaysBinding;
import com.example.mygym.moudle.Day;
import com.example.mygym.moudle.Guide;
import com.example.mygym.moudle.MyGuide;

import java.util.List;
import java.util.Map;

public class TrainingDaysActivity extends AppCompatActivity {
    ActivityTrainingDaysBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrainingDaysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
