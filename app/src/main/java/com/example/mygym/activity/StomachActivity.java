package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mygym.R;
import com.example.mygym.adapter.GuideAdapter;
import com.example.mygym.databinding.ActivityLegsBinding;
import com.example.mygym.databinding.ActivityStomachBinding;
import com.example.mygym.moudle.Guide;

import java.util.ArrayList;

public class StomachActivity extends AppCompatActivity {
    ActivityStomachBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStomachBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Guide> arrayList = new ArrayList<>();
        arrayList.add(new Guide(R.drawable.img0000001, "تمرين معدة وسطى 1"));
        arrayList.add(new Guide(R.drawable.img0000002, "تمرين معدة وسطى 2"));
        arrayList.add(new Guide(R.drawable.img0000003, "تمرين معدة وسطى بالجهاز"));
        arrayList.add(new Guide(R.drawable.img0000004, "تمرين معدة وسطى بالكابل"));
        arrayList.add(new Guide(R.drawable.img0000005, "تمرين معدة وسطى 3"));
        arrayList.add(new Guide(R.drawable.img0000006, "تمرين معدة وسطى دحرجة"));
        arrayList.add(new Guide(R.drawable.img0000007, "تمرين معدة جانبية 1"));
        arrayList.add(new Guide(R.drawable.img0000008, "تمرين معدة جانبية بالدامبل"));
        arrayList.add(new Guide(R.drawable.img0000009, "تمرين معدة جانبية بالبار"));
        arrayList.add(new Guide(R.drawable.img00000010, "تمرين معدة جانبية 2"));
        arrayList.add(new Guide(R.drawable.img00000011, "تمرين معدة جانبية 3"));
        arrayList.add(new Guide(R.drawable.img00000012, "تمرين معدة جانبية 4"));
        GuideAdapter adapter = new GuideAdapter(getApplicationContext(), arrayList);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recycle.setAdapter(adapter);
    }
}