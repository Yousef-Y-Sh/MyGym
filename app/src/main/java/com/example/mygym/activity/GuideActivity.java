package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.adapter.MyGuideAdapter;
import com.example.mygym.database.MyDataBase;
import com.example.mygym.databinding.ActivityGuideBinding;
import com.example.mygym.moudle.MyGuide;

import java.util.List;
import java.util.Collections;

public class GuideActivity extends AppCompatActivity {
    ActivityGuideBinding binding;
    MyDataBase db;
    List<MyGuide> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = new MyDataBase(this);
        binding.floating.setOnClickListener(view -> Utils._Intent(GuideActivity.this, AddGuideActivity.class));
        binding.toolbar.title.setText("البرامج التدريبية");
        binding.toolbar.backImg.setOnClickListener(view -> finish());
    }

    @Override
    protected void onStart() {
        super.onStart();

        list = db.GETALLGUIDES();
        _bubbleSort(list);
        MyGuideAdapter myGuideAdapter = new MyGuideAdapter(GuideActivity.this, list);
        binding.recycleGudie.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleGudie.setAdapter(myGuideAdapter);

        if (list.isEmpty()) binding.tvEmpty.setVisibility(View.VISIBLE);
        else binding.tvEmpty.setVisibility(View.GONE);

    }

    public void _bubbleSort(List<MyGuide> movies) {
        for (int a = 1; a < movies.size(); a++) {
            for (int b = 0; b < movies.size() - a; b++) {
                if (((movies.get(b).getId()) < ((movies.get(b + 1).getId())))) {
                    Collections.swap(movies, b, b + 1);
                }
            }
        }
    }

}