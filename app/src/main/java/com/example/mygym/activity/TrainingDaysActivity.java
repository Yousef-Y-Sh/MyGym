package com.example.mygym.activity;

import androidx.annotation.Nullable;
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
    Bundle bundle;
    MyDataBase myDataBase;
    MyGuide parentCollectionIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrainingDaysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myDataBase = new MyDataBase(this);
        bundle = getIntent().getExtras();
        if (bundle.getParcelable("object") != null) {
            parentCollectionIntent = bundle.getParcelable("object");
            binding.toolbar.title.setText(parentCollectionIntent.getName());
            inflateRecycle(myDataBase.GET_ALL_DAYS(parentCollectionIntent.id), parentCollectionIntent);
            binding.floating.setOnClickListener(view -> {
                Intent intent = new Intent(getApplicationContext(), AddDayActivity.class);
                intent.putExtra(Utils.__INTENTCOLLECTION, parentCollectionIntent);
                startActivityForResult(intent, 111);
            });
        }
        binding.toolbar.backImg.setOnClickListener(view -> finish());

    }


    void inflateRecycle(List<Day> myList, MyGuide parentCollection) {
        if (myList.isEmpty()) {
            binding.tvEmpty.setVisibility(View.VISIBLE);
        } else {
            binding.tvEmpty.setVisibility(View.GONE);
            AllDaysAdapter adapter = new AllDaysAdapter(TrainingDaysActivity.this, myList, parentCollection);
            binding.recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            binding.recycle.setAdapter(adapter);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == 111) {
                inflateRecycle(myDataBase.GET_ALL_DAYS(parentCollectionIntent.id), parentCollectionIntent);
            }
        }
    }
}
