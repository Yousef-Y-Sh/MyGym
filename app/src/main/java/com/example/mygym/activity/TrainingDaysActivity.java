package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.adapter.AllDaysAdapter;
import com.example.mygym.database.MyDataBase;
import com.example.mygym.databinding.ActivityTrainingDaysBinding;
import com.example.mygym.moudle.Day;
import com.example.mygym.moudle.Guide;
import com.example.mygym.moudle.MyGuide;

import java.util.List;

public class TrainingDaysActivity extends AppCompatActivity {
    ActivityTrainingDaysBinding binding;
    private MyGuide myGuide;
    MyDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrainingDaysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = new MyDataBase(this);

        binding.toolbar.backImg.setOnClickListener(view -> finish());
        Bundle b = getIntent().getExtras();
        if (b != null) {
            myGuide = b.getParcelable("object");
            binding.toolbar.title.setText(myGuide.getName());
            List<Day> day = db.GET_ALL_DAYS(myGuide.getId());
            AllDaysAdapter adapter = new AllDaysAdapter(TrainingDaysActivity.this, day);
            binding.recycle.setLayoutManager(new LinearLayoutManager(this));
            binding.recycle.setAdapter(adapter);
            if (day.isEmpty()) {
                binding.tvEmpty.setVisibility(View.VISIBLE);
            } else {
                binding.tvEmpty.setVisibility(View.GONE);
            }
        }
        binding.floating.setOnClickListener(view -> {
            Intent intent = new Intent(TrainingDaysActivity.this, AddDayActivity.class);
            intent.putExtra("object", myGuide);
            startActivity(intent);
        });
    }
}