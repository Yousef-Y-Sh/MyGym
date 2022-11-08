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
    Bundle bundle;
    List<Guide> selectedList;
    private SelectedGuideAdapter selectedGuideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();
        selectedList = new ArrayList<>();
        binding.toolbar.backImg.setOnClickListener(view -> finish());

        if (bundle.getString("type") != null) {
            inflateRecycleItem(bundle.getString("type"));
        }
        if (bundle.getParcelable("list") != null) {
            GuideIntent guideIntent = bundle.getParcelable("list");
            selectedList.addAll(guideIntent.getList());
        }

        binding.floating.setOnClickListener(view -> {
            GuideIntent guideIntent = new GuideIntent(selectedGuideAdapter.getItemSelected());
            Intent intent = new Intent();
            intent.putExtra(Utils._DATA, guideIntent);
            setResult(RESULT_OK, intent);
            finish();
        });

    }

    void inflateRecycleItem(String type) {
        switch (bundle.getString("type")) {
            case Utils.__BACKGUIDS:
                binding.toolbar.title.setText(getString(R.string.back));
                setItems(Utils.Back());
                break;
            case Utils.__BAYCEPSGUIDS:
                binding.toolbar.title.setText(getString(R.string.baysep));
                setItems(Utils.BaycepsList());
                break;
            case Utils.__CHESTGUIDS:
                binding.toolbar.title.setText(getString(R.string.chest));
                setItems(Utils.Chest());
                break;
            case Utils.__FOREAMRMSGUIDS:
                binding.toolbar.title.setText(getString(R.string.formar));
                setItems(Utils.ForearmsList());
                break;
            case Utils.__LEGSGUIDS:
                binding.toolbar.title.setText(getString(R.string.leg));
                setItems(Utils.LegList());
                break;
            case Utils.__SHOULDERSGUIDS:
                binding.toolbar.title.setText(getString(R.string.soulder));
                setItems(Utils.ShoulderList());
                break;
            case Utils.__STOMACHGUIDS:
                binding.toolbar.title.setText(getString(R.string.stomach));
                setItems(Utils.StomachList());
                break;
            case Utils.__TRICEPSGUIDS:
                binding.toolbar.title.setText(getString(R.string.trycep));
                setItems(Utils.TricepesList());
                break;
        }
    }

    void setItems(List<Guide> guides) {
        selectedGuideAdapter = new SelectedGuideAdapter(SelectGuideActivity.this, guides, binding.floating, selectedList);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recycle.setAdapter(selectedGuideAdapter);
    }
}
