package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mygym.R;
import com.example.mygym.adapter.GuideAdapter;
import com.example.mygym.databinding.ActivityBackBinding;
import com.example.mygym.databinding.ActivityChestBinding;
import com.example.mygym.moudle.Guide;

import java.util.ArrayList;

public class BackActivity extends AppCompatActivity {
    ActivityBackBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBackBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Guide> arrayList = new ArrayList<>();
        arrayList.add(new Guide(R.drawable.img0001, "سحب خلفي واسع"));
        arrayList.add(new Guide(R.drawable.img0002, "سحب امامي ضيق"));
        arrayList.add(new Guide(R.drawable.img0003, "سحب امامي ضيق عكسي"));
        arrayList.add(new Guide(R.drawable.img0004, "سحب امامي ضيق V"));
        arrayList.add(new Guide(R.drawable.img0005, "تمرين سحب كابل V"));
        arrayList.add(new Guide(R.drawable.img0006, "سحب امامي كابل واسع"));
        arrayList.add(new Guide(R.drawable.img0007, "تمرين سحب بار"));
        arrayList.add(new Guide(R.drawable.img0008, "سحب بار قبضة معكوسة"));
        arrayList.add(new Guide(R.drawable.img0009, "ديدليفت"));
        arrayList.add(new Guide(R.drawable.img00010, "تمرين الحصان"));
        arrayList.add(new Guide(R.drawable.img00011, "تمرين جذب البار"));
        arrayList.add(new Guide(R.drawable.img00012, "تمرين سحب ضيق بالجهاز"));
        arrayList.add(new Guide(R.drawable.img00013, "سحب افقي بالكابل"));
        arrayList.add(new Guide(R.drawable.img00014, "سحب متوسط بالكابل"));
        arrayList.add(new Guide(R.drawable.img00015, "تمرين سحب بالدامبل فردي"));
        arrayList.add(new Guide(R.drawable.img00016, "تمرين سحب الدامبل زوجي"));
        arrayList.add(new Guide(R.drawable.img00017, "دامبل بول اوفر"));
        arrayList.add(new Guide(R.drawable.img00018, "تمرين العقلة واسع"));
        arrayList.add(new Guide(R.drawable.img00019, "تمرين العقلة ضيق"));
        arrayList.add(new Guide(R.drawable.img00020, "سحب متوسط بالكابل"));
        arrayList.add(new Guide(R.drawable.img00021, "سحب بالبار معكوس"));
        GuideAdapter adapter = new GuideAdapter(getApplicationContext(), arrayList);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recycle.setAdapter(adapter);
    }
}