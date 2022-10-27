package com.example.mygym.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygym.R;
import com.example.mygym.moudle.Guide;

import java.util.ArrayList;

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.MyViewHolder> {
    Context context;
    ArrayList<Guide> list;

    public GuideAdapter(Context context, ArrayList<Guide> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GuideAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_01,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GuideAdapter.MyViewHolder holder, int position) {
        holder.imgSrc.setImageResource(list.get(position).image);
        holder.title.setText(list.get(position).title);
        holder.id.setText((position+1)+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgSrc;
        private TextView title;
        private TextView id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSrc = (ImageView) itemView.findViewById(R.id.imgSrc);
            title = (TextView) itemView.findViewById(R.id.title);
            id = (TextView) itemView.findViewById(R.id.id);
        }
    }
}
