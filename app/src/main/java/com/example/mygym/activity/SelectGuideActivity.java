package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.adapter.SelectedGuideAdapter;
import com.example.mygym.database.MyDataBase;
import com.example.mygym.databinding.ActivitySelectGuideBinding;
import com.example.mygym.moudle.Guide;
import com.example.mygym.moudle.MyGuide;

import java.util.ArrayList;

public class SelectGuideActivity extends AppCompatActivity {
    ActivitySelectGuideBinding binding;
    SelectedGuideAdapter selectedGuideAdapter;
    MyDataBase db;
    MyGuide myGuide;
    int day = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = new MyDataBase(this);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            switch (getIntent().getExtras().getString("data")) {
                case Utils.__CHESTGUIDS:
                    inflateRecycle(Utils.Chest());
                    break;
                case Utils.__BACKGUIDS:
                    inflateRecycle(Utils.Back());
                    break;
                case Utils.__BAYCEPSGUIDS:
                    inflateRecycle(Utils.BaycepsList());
                    break;
                case Utils.__FOREAMRMSGUIDS:
                    inflateRecycle(Utils.ForearmsList());
                    break;
                case Utils.__LEGSGUIDS:
                    inflateRecycle(Utils.LegList());
                    break;
                case Utils.__SHOULDERSGUIDS:
                    inflateRecycle(Utils.ShoulderList());
                    break;
                case Utils.__STOMACHGUIDS:
                    inflateRecycle(Utils.StomachList());
                    break;
                case Utils.__TRICEPSGUIDS:
                    inflateRecycle(Utils.TricepesList());
                    break;
            }
            myGuide = b.getParcelable("object");
            day = b.getInt("day");
            binding.floating.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (Guide guide : selectedGuideAdapter.getSelectedItem()) {
                        Guide guideObject = new Guide(guide.getImage(), guide.getTitle(), myGuide.getId(), day);
                        db.INSERT_MY_GUIDE(guideObject);
                    }
                    finish();
                }
            });
        }

    }

    void inflateRecycle(ArrayList<Guide> guides) {
        selectedGuideAdapter = new SelectedGuideAdapter(getApplicationContext(), guides, binding.floating);
        binding.recycle.setLayoutManager(new LinearLayoutManager(this));
        binding.recycle.setAdapter(selectedGuideAdapter);
    }


}