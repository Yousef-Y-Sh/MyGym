package com.example.mygym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mygym.Utils.Utils;
import com.example.mygym.activity.GuideActivity;
import com.example.mygym.activity.GuideMenuActivity;
import com.example.mygym.database.MyDataBase;
import com.example.mygym.databinding.ActivityMainBinding;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MyDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = new MyDataBase(this);

        binding.toolbar.backImg.setVisibility(View.GONE);
        binding.item1.setOnClickListener(view -> {
            Utils._Intent(MainActivity.this, GuideMenuActivity.class);
        });
        binding.item2.setOnClickListener(view -> {
            Utils._Intent(MainActivity.this, GuideActivity.class);
        });
        binding.countGuide.setText(db.GETALLCOLLECTIONS().size() + " تمارين");
    }
}
