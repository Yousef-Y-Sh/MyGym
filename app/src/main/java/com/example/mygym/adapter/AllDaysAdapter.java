package com.example.mygym.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygym.R;
import com.example.mygym.moudle.Day;

import java.util.ArrayList;
import java.util.List;

public class AllDaysAdapter extends RecyclerView.Adapter<AllDaysAdapter.MyViewHolder> {
    Activity activity;
    List<Day> list;

    public AllDaysAdapter(Activity activity, List<Day> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public AllDaysAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_04, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AllDaysAdapter.MyViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout constraintLayout2;
        private ImageView imgOpen;
        private TextView title;
        private RecyclerView recycleItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout2 = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout2);
            imgOpen = (ImageView) itemView.findViewById(R.id.imgOpen);
            title = (TextView) itemView.findViewById(R.id.title);
            recycleItem = (RecyclerView) itemView.findViewById(R.id.recycleItem);

        }
    }
}
