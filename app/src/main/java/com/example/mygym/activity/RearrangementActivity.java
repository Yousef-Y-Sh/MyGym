package com.example.mygym.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.adapter.RearrangeAdapter;
import com.example.mygym.database.MyDataBase;
import com.example.mygym.databinding.ActivityRearrangementBinding;
import com.example.mygym.moudle.Guide;
import com.example.mygym.moudle.GuideIntent;

import java.util.Collections;
import java.util.List;

public class RearrangementActivity extends AppCompatActivity {
    ActivityRearrangementBinding binding;
    Bundle bundle;
    List<Guide> myList;
    MyDataBase myDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRearrangementBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myDataBase = new MyDataBase(this);
        binding.toolbar.title.setText("ترتيب العناصر");
        binding.toolbar.backImg.setOnClickListener(view -> finish());
        binding.toolbar.save.setText("حفظ");
        binding.toolbar.save.setVisibility(View.VISIBLE);
        bundle = getIntent().getExtras();
        if (bundle.getParcelable("list") != null) {
            GuideIntent guideIntent = bundle.getParcelable("list");
            myList = guideIntent.getList();
            RearrangeAdapter adapter = new RearrangeAdapter(RearrangementActivity.this, myList);
            binding.recycle.setLayoutManager(new LinearLayoutManager(this));
            binding.recycle.setAdapter(adapter);
            binding.toolbar.save.setOnClickListener(view -> {
                for (int i = 0; i < myList.size(); i++) {
                    Guide guide = myList.get(i);
                    guide.setPosition(i);

                    Log.e("aaaa", myDataBase.UPDATE_EXECUTE(guide) + "");
                }
                finish();
            });
        }
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        binding.recycle.addItemDecoration(dividerItemDecoration);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.recycle);
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END, 0) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();
            Collections.swap(myList, fromPosition, toPosition);
            recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };
}
