package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.adapter.SelectedGuideAdapter;
import com.example.mygym.database.MyDataBase;
import com.example.mygym.databinding.ActivitySelectGuideBinding;
import com.example.mygym.moudle.Guide;
import com.example.mygym.moudle.GuideIntent;
import com.example.mygym.moudle.MyGuide;

import java.util.ArrayList;
import java.util.List;

public class SelectGuideActivity extends AppCompatActivity {
    ActivitySelectGuideBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}
