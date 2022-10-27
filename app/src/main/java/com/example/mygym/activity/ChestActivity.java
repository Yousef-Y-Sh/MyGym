package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mygym.R;
import com.example.mygym.adapter.GuideAdapter;
import com.example.mygym.databinding.ActivityChestBinding;
import com.example.mygym.moudle.Guide;

import java.util.ArrayList;

public class ChestActivity extends AppCompatActivity {
    ActivityChestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Guide> arrayList = new ArrayList<>();
        arrayList.add(new Guide(R.drawable.img01, "تمرين الصدر بالبار سفلي"));
        arrayList.add(new Guide(R.drawable.img02, "تمرين الصدر بالبار علوي"));
        arrayList.add(new Guide(R.drawable.img03, "تمرين الصدر بالبار مستوي"));
        arrayList.add(new Guide(R.drawable.img04, "تمرين الصدر بالدامبل سفلي"));
        arrayList.add(new Guide(R.drawable.img05, "تمرين الصدر بالدامبل علوي"));
        arrayList.add(new Guide(R.drawable.img06, "تمرين الصدر بالدامبل مستوي"));
        arrayList.add(new Guide(R.drawable.img07, "تمرين الرفرفة بالدامبل سفلي"));
        arrayList.add(new Guide(R.drawable.img08, "تمرين الرفرفة بالدامبل علوي"));
        arrayList.add(new Guide(R.drawable.img09, "تمرين الرفرفة بالدامبل مستوي"));
        arrayList.add(new Guide(R.drawable.img010, "تمرين الصدر بالكابل سفلي"));
        arrayList.add(new Guide(R.drawable.img011, "تمرين الصدر بالكابل علوي"));
        arrayList.add(new Guide(R.drawable.img012, "تمرين الصدر بالكابل مستوي"));
        arrayList.add(new Guide(R.drawable.img013, "تمرين الصدر بالكابل متوسط"));
        arrayList.add(new Guide(R.drawable.img014, "تمرين الصدر بجهاز الفراشة"));
        arrayList.add(new Guide(R.drawable.img015, "تمرين هامر بالدامبل سفلي"));
        arrayList.add(new Guide(R.drawable.img016, "تمرين الغطس المتوازي"));
        arrayList.add(new Guide(R.drawable.img017, "تمرين SVEND PRESS"));
        arrayList.add(new Guide(R.drawable.img018, "تمرين الصدر بالة الضغط"));
        GuideAdapter adapter = new GuideAdapter(getApplicationContext(), arrayList);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recycle.setAdapter(adapter);
    }
}