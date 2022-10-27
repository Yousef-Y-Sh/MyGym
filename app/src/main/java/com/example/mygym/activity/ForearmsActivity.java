package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;

import com.example.mygym.R;
import com.example.mygym.adapter.GuideAdapter;
import com.example.mygym.databinding.ActivityForearmsBinding;
import com.example.mygym.moudle.Guide;

import java.util.ArrayList;

public class ForearmsActivity extends AppCompatActivity {
    ActivityForearmsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForearmsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<Guide> arrayList = new ArrayList<>();
        arrayList.add(new Guide(R.drawable.img000000001, "تمرين سواعد بالبار جالس"));
        arrayList.add(new Guide(R.drawable.img000000002, "تمرين سواعد بالبار 1"));
        arrayList.add(new Guide(R.drawable.img000000003, "تمرين سواعد بالبار 2"));
        arrayList.add(new Guide(R.drawable.img000000004, "تمرين سواعد بالكابل"));
        arrayList.add(new Guide(R.drawable.img000000005, "تمرين سواعد بالدامبل"));
        arrayList.add(new Guide(R.drawable.img000000006, "تمرين سواعد بالدامبل"));
        arrayList.add(new Guide(R.drawable.img000000007, "تمرين سواعد بالدامبل"));
        arrayList.add(new Guide(R.drawable.img000000008, "تمرين سواعد بالدامبل"));
        arrayList.add(new Guide(R.drawable.img000000009, "تمرين سواعد بالبار"));
        arrayList.add(new Guide(R.drawable.img0000000010, "تمرين سواعد"));
        GuideAdapter adapter = new GuideAdapter(getApplicationContext(), arrayList);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recycle.setAdapter(adapter);

    }
}