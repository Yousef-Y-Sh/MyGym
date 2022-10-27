package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mygym.R;
import com.example.mygym.adapter.GuideAdapter;
import com.example.mygym.databinding.ActivityBaycepsBinding;
import com.example.mygym.moudle.Guide;

import java.util.ArrayList;

public class BaycepsActivity extends AppCompatActivity {
    ActivityBaycepsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBaycepsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Guide> arrayList = new ArrayList<>();
        arrayList.add(new Guide(R.drawable.img00000001, "تمرين بايسبس بالبار 1"));
        arrayList.add(new Guide(R.drawable.img00000002, "تمرين بايسبس بالبار 2"));
        arrayList.add(new Guide(R.drawable.img00000003, "تمرين بايسبس بالبار 3"));
        arrayList.add(new Guide(R.drawable.img00000004, "تمرين بايسبس بالبار 4"));
        arrayList.add(new Guide(R.drawable.img00000005, "تمرين بايسبس بالدامبل 1"));
        arrayList.add(new Guide(R.drawable.img00000006, "تمرين بايسبس بالدامبل 2"));
        arrayList.add(new Guide(R.drawable.img00000007, "تمرين بايسبس بالدامبل 3"));
        arrayList.add(new Guide(R.drawable.img00000008, "تمرين بايسبس بالدامبل 4"));
        arrayList.add(new Guide(R.drawable.img00000009, "تمرين بايسبس بالدامبل 5"));
        arrayList.add(new Guide(R.drawable.img000000010, "تمرين بايسبس بالدامبل 6"));
        arrayList.add(new Guide(R.drawable.img000000011, "تمرين بايسبس بالدامبل 7"));
        arrayList.add(new Guide(R.drawable.img000000012, "تمرين بايسبس بالكابل 1"));
        arrayList.add(new Guide(R.drawable.img000000013, "تمرين بايسبس بالكابل 2"));
        arrayList.add(new Guide(R.drawable.img000000014, "تمرين بايسبس بالكابل 3"));
        arrayList.add(new Guide(R.drawable.img000000015, "تمرين بايسبس بالكابل 4"));
        GuideAdapter adapter = new GuideAdapter(getApplicationContext(), arrayList);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recycle.setAdapter(adapter);
    }
}