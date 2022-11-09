package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.adapter.GuideAdapter;
import com.example.mygym.databinding.ActivityExerciseGuideBinding;
import com.example.mygym.moudle.Guide;

import java.util.ArrayList;
import java.util.List;

public class ExerciseGuideActivity extends AppCompatActivity {
    ActivityExerciseGuideBinding binding;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExerciseGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbar.backImg.setOnClickListener(view -> finish());

        bundle = getIntent().getExtras();
        if (bundle != null) {
            switch (bundle.getString("type")) {
                case Utils.__BACKGUIDS:
                    inflateItem(Utils.Back());
                    break;
                case Utils.__BAYCEPSGUIDS:
                    inflateItem(Utils.BaycepsList());
                    break;
                case Utils.__CHESTGUIDS:
                    inflateItem(Utils.Chest());
                    break;
                case Utils.__FOREAMRMSGUIDS:
                    inflateItem(Utils.ForearmsList());
                    break;
                case Utils.__LEGSGUIDS:
                    inflateItem(Utils.LegList());
                    break;
                case Utils.__SHOULDERSGUIDS:
                    inflateItem(Utils.ShoulderList());
                    break;
                case Utils.__STOMACHGUIDS:
                    inflateItem(Utils.StomachList());
                    break;
                case Utils.__TRICEPSGUIDS:
                    inflateItem(Utils.TricepesList());
                    break;
            }
        }
    }

    void inflateItem(List<Guide> myList) {
        String title = bundle.getString("title");
        binding.toolbar.title.setText(title);
        GuideAdapter adapter = new GuideAdapter(getApplicationContext(), myList, false);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recycle.setAdapter(adapter);
    }
}
