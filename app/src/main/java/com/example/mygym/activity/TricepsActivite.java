package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mygym.R;
import com.example.mygym.adapter.GuideAdapter;
import com.example.mygym.databinding.ActivityStomachBinding;
import com.example.mygym.databinding.ActivityTricepsActiviteBinding;
import com.example.mygym.moudle.Guide;

import java.util.ArrayList;

public class TricepsActivite extends AppCompatActivity {
    ActivityTricepsActiviteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTricepsActiviteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Guide> arrayList = new ArrayList<>();
        arrayList.add(new Guide(R.drawable.img000001, "تمرين ترايسبس بالدامبل 1"));
        arrayList.add(new Guide(R.drawable.img000002, "تمرين ترايسبس بالدامبل 2"));
        arrayList.add(new Guide(R.drawable.img000003, "تمرين ترايسبس بالدامبل 3"));
        arrayList.add(new Guide(R.drawable.img000004, "تمرين ترايسبس بالدامبل 4"));
        arrayList.add(new Guide(R.drawable.img000005, "تمرين ترايسبس بالدامبل 5"));
        arrayList.add(new Guide(R.drawable.img000006, "تمرين ترايسبس بالبار 1"));
        arrayList.add(new Guide(R.drawable.img000007, "تمرين ترايسبس بالبار 2"));
        arrayList.add(new Guide(R.drawable.img000008, "تمرين ترايسبس بالبار 3"));
        arrayList.add(new Guide(R.drawable.img000009, "تمرين ترايسبس بالبار 4"));
        arrayList.add(new Guide(R.drawable.img0000010, "تمرين ترايسبس بالبار 5"));
        arrayList.add(new Guide(R.drawable.img0000011, "تمرين ترايسبس بالبار 6"));
        arrayList.add(new Guide(R.drawable.img0000012, "تمرين ترايسبس بالكابل 1"));
        arrayList.add(new Guide(R.drawable.img0000013, "تمرين ترايسبس بالكابل 2"));
        arrayList.add(new Guide(R.drawable.img0000014, "تمرين ترايسبس بالكابل 3"));
        arrayList.add(new Guide(R.drawable.img0000015, "تمرين ترايسبس بالكابل 4"));
        arrayList.add(new Guide(R.drawable.img0000016, "تمرين ترايسبس بالبنك 1"));
        arrayList.add(new Guide(R.drawable.img0000017, "تمرين ترايسبس بالبنك 2"));
        GuideAdapter adapter = new GuideAdapter(getApplicationContext(), arrayList);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recycle.setAdapter(adapter);
    }
}