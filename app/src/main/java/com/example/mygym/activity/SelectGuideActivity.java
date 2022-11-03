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

import java.util.List;

public class SelectGuideActivity extends AppCompatActivity {
    ActivitySelectGuideBinding binding;
    SelectedGuideAdapter selectedGuideAdapter;
    MyDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = new MyDataBase(this);
        binding.toolbar.backImg.setOnClickListener(view -> finish());
        Bundle b = getIntent().getExtras();
        if (b != null) {
            switch (getIntent().getExtras().getString("type")) {
                case Utils.__CHESTGUIDS:
                    binding.toolbar.title.setText(getString(R.string.chest));
                    inflateRecycle(Utils.Chest());
                    break;
                case Utils.__BACKGUIDS:
                    binding.toolbar.title.setText(getString(R.string.back));
                    inflateRecycle(Utils.Back());
                    break;
                case Utils.__BAYCEPSGUIDS:
                    binding.toolbar.title.setText(getString(R.string.baysep));
                    inflateRecycle(Utils.BaycepsList());
                    break;
                case Utils.__FOREAMRMSGUIDS:
                    binding.toolbar.title.setText(getString(R.string.formar));
                    inflateRecycle(Utils.ForearmsList());
                    break;
                case Utils.__LEGSGUIDS:
                    binding.toolbar.title.setText(getString(R.string.leg));
                    inflateRecycle(Utils.LegList());
                    break;
                case Utils.__SHOULDERSGUIDS:
                    binding.toolbar.title.setText(getString(R.string.soulder));
                    inflateRecycle(Utils.ShoulderList());
                    break;
                case Utils.__STOMACHGUIDS:
                    binding.toolbar.title.setText(getString(R.string.stomach));
                    inflateRecycle(Utils.StomachList());
                    break;
                case Utils.__TRICEPSGUIDS:
                    binding.toolbar.title.setText(getString(R.string.trycep));
                    inflateRecycle(Utils.TricepesList());
                    break;
            }
            binding.floating.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (selectedGuideAdapter.getSelectedCount() != 0) {
                        GuideIntent guideIntent = new GuideIntent(selectedGuideAdapter.getSelectedItem());
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("list", guideIntent);
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    }
                }
            });
        }

    }

    void inflateRecycle(List<Guide> guides) {
        selectedGuideAdapter = new SelectedGuideAdapter(getApplicationContext(), guides, binding.floating);
        binding.recycle.setLayoutManager(new LinearLayoutManager(this));
        binding.recycle.setAdapter(selectedGuideAdapter);
    }


}