package com.example.mygym.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygym.R;
import com.example.mygym.database.MyDataBase;
import com.example.mygym.moudle.Day;

import java.util.ArrayList;
import java.util.List;

public class AllDaysAdapter extends RecyclerView.Adapter<AllDaysAdapter.MyViewHolder> {
    Activity activity;
    List<Day> list;
    MyDataBase db;
    boolean flag = false;

    public AllDaysAdapter(Activity activity, List<Day> list) {
        this.activity = activity;
        this.list = list;
        db = new MyDataBase(activity);
    }

    @NonNull
    @Override
    public AllDaysAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_04, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AllDaysAdapter.MyViewHolder holder, int position) {
        if (list.get(position).isOpen) {
            holder.recycleItem.setVisibility(View.VISIBLE);
            holder.imgOpen.setText("اخفاء");

        } else {
            holder.recycleItem.setVisibility(View.GONE);
            holder.imgOpen.setText("عرض");
        }

        holder.title.setText(list.get(position).getTitle());
        holder.recycleItem.setVisibility(View.GONE);
        holder.constraintLayout2.setOnClickListener(view -> {
            if (!list.get(holder.getAdapterPosition()).isOpen) {
                list.get(holder.getAdapterPosition()).setOpen(true);
                GuideAdapter guideAdapter = new GuideAdapter(activity, db.GET_ALL_MY_GUIDES(list.get(holder.getAdapterPosition()).getId(), list.get(holder.getAdapterPosition()).getTitle()));
                holder.recycleItem.setLayoutManager(new LinearLayoutManager(activity));
                holder.recycleItem.setAdapter(guideAdapter);
                holder.recycleItem.setVisibility(View.VISIBLE);
                holder.imgOpen.setText("اخفاء");
            } else {
                list.get(holder.getAdapterPosition()).setOpen(false);
                holder.recycleItem.setVisibility(View.GONE);
                holder.imgOpen.setText("عرض");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout constraintLayout2;
        private TextView imgOpen;
        private TextView title;
        private RecyclerView recycleItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout2 = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout2);
            imgOpen = (TextView) itemView.findViewById(R.id.imgOpen);
            title = (TextView) itemView.findViewById(R.id.title);
            recycleItem = (RecyclerView) itemView.findViewById(R.id.recycleItem);

        }
    }
}
