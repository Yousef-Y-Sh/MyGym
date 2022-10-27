package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mygym.R;
import com.example.mygym.adapter.GuideAdapter;
import com.example.mygym.databinding.ActivityChestBinding;
import com.example.mygym.databinding.ActivityLegsBinding;
import com.example.mygym.moudle.Guide;

import java.util.ArrayList;

public class LegsActivity extends AppCompatActivity {

    ActivityLegsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLegsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Guide> arrayList = new ArrayList<>();
        arrayList.add(new Guide(R.drawable.img00001, "تمرين احماء عضلة الرجل"));
        arrayList.add(new Guide(R.drawable.img00002, "تمرين السكوات بالبار خلفي"));
        arrayList.add(new Guide(R.drawable.img00003, "تمرين السكوات بالبار امامي"));
        arrayList.add(new Guide(R.drawable.img00004, "تمرين سكوات بالبار امامي"));
        arrayList.add(new Guide(R.drawable.img00005, "تمرين المشي بالدامبل"));
        arrayList.add(new Guide(R.drawable.img00006, "تمرين المشي بالبار"));
        arrayList.add(new Guide(R.drawable.img00007, "تمرين الدرج بالدامبل"));
        arrayList.add(new Guide(R.drawable.img00008, "تمرين مرجحة رجل امامي"));
        arrayList.add(new Guide(R.drawable.img00009, "تمرين ضغط الرجلين"));
        arrayList.add(new Guide(R.drawable.img000010, "تمرين السكوات سميث خلفي"));
        arrayList.add(new Guide(R.drawable.img000011, "مرجحة رجل خلفي بالدامبل"));
        arrayList.add(new Guide(R.drawable.img000012, "تمرين مرجحة رجل خلفي"));
        arrayList.add(new Guide(R.drawable.img000013, "تمرين مرجحة رجل خلفي"));
        arrayList.add(new Guide(R.drawable.img000014, "تمرين ضغط سمانة بالدامبل"));
        arrayList.add(new Guide(R.drawable.img000015, "تمرين سمانة بالجهاز"));
        arrayList.add(new Guide(R.drawable.img000016, "ضغط سمانة في الجهاز"));
        arrayList.add(new Guide(R.drawable.img000017, "ضغط سمانة في الجهاز"));
        GuideAdapter adapter = new GuideAdapter(getApplicationContext(), arrayList);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recycle.setAdapter(adapter);
    }
}