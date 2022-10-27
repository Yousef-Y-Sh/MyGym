package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mygym.R;
import com.example.mygym.adapter.GuideAdapter;
import com.example.mygym.databinding.ActivityShouldersBinding;
import com.example.mygym.moudle.Guide;

import java.util.ArrayList;

public class ShouldersActivity extends AppCompatActivity {
    ActivityShouldersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShouldersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Guide> arrayList = new ArrayList<>();
        arrayList.add(new Guide(R.drawable.img001, "تمرين الكتف بالبار أمامي"));
        arrayList.add(new Guide(R.drawable.img002, "تمرين الكتف بالبار خلفي"));
        arrayList.add(new Guide(R.drawable.img003, "تمرين الكتف بالدامبل أمامي"));
        arrayList.add(new Guide(R.drawable.img004, "تمرين أرنولد بريس"));
        arrayList.add(new Guide(R.drawable.img005, "تمرين أرنولد بريس مطرقة"));
        arrayList.add(new Guide(R.drawable.img006, "رفع أمامي دامبل"));
        arrayList.add(new Guide(R.drawable.img007, "رفع أمامي كابل"));
        arrayList.add(new Guide(R.drawable.img008, "رفع أمامي بالدامبل مطرقة"));
        arrayList.add(new Guide(R.drawable.img009, "رفع أمامي بالوزن"));
        arrayList.add(new Guide(R.drawable.img0010, "تمرين رفرفة بالكابل خلفي"));
        arrayList.add(new Guide(R.drawable.img0011, "تمرين رفرفة بالدامبل خلفي"));
        arrayList.add(new Guide(R.drawable.img0012, "تمرين سحب بالبار علوي"));
        arrayList.add(new Guide(R.drawable.img0013, "تمرين سحب خلفي بالكابل"));
        arrayList.add(new Guide(R.drawable.img0014, "تمرين رفرفة بالدامبل خلفي"));
        arrayList.add(new Guide(R.drawable.img0015, "تمرين ارجاع خلفي بالبار"));
        arrayList.add(new Guide(R.drawable.img0016, "تمرين رفرفة بالدامبل"));
        arrayList.add(new Guide(R.drawable.img0017, "تمرين رفرفة بالدامبل"));
        arrayList.add(new Guide(R.drawable.img0018, "تمرين رفرفة بالدامبل جانبي"));
        arrayList.add(new Guide(R.drawable.img0019, "تمرين سحب افقي بالبار"));
        arrayList.add(new Guide(R.drawable.img0020, "تمرين رفرفة بالبار جانبي"));
        arrayList.add(new Guide(R.drawable.img0021, "تمرين رفرفة بالكابل جانبي"));
        arrayList.add(new Guide(R.drawable.img0022, "تمرين سحب افقي بالدامبل"));
        arrayList.add(new Guide(R.drawable.img0023, "تمرين رفرفة بالدامبل خلفي"));
        GuideAdapter adapter = new GuideAdapter(getApplicationContext(), arrayList);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recycle.setAdapter(adapter);
    }
}