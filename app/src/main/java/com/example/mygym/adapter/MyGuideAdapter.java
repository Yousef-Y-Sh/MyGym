package com.example.mygym.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygym.R;
import com.example.mygym.moudle.MyGuide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyGuideAdapter extends RecyclerView.Adapter<MyGuideAdapter.MyViewHolder> {
    Context context;
    ArrayList<MyGuide> list;

    public MyGuideAdapter(Context context, ArrayList<MyGuide> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyGuideAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_02, parent, false);
        return new MyViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull MyGuideAdapter.MyViewHolder holder, int position) {
        MyGuide myGuide = list.get(position);
        holder.cover.setImageResource(myGuide.getCover());
        holder.difficulty.setText(myGuide.difficulty);
        holder.tvTime.setText(myGuide.getTime() + "");
        holder.title.setText(myGuide.getName());
        //status code
        {
            if (myGuide.status.equals(context.getString(R.string.start))) {
                holder.clockImg.setVisibility(View.VISIBLE);
                holder.closeImg.setVisibility(View.GONE);
                holder.finishImg.setVisibility(View.GONE);
                holder.tvState.setText(myGuide.status);
                holder.tvState.setTextColor(context.getColor(R.color.clock_color));
            } else if (myGuide.status.equals(context.getString(R.string.finish))) {
                holder.clockImg.setVisibility(View.GONE);
                holder.closeImg.setVisibility(View.GONE);
                holder.finishImg.setVisibility(View.VISIBLE);
                holder.tvState.setText(myGuide.status);
                holder.tvState.setTextColor(context.getColor(R.color.finish_color));
            } else if (myGuide.status.equals(context.getString(R.string.pause))) {
                holder.clockImg.setVisibility(View.GONE);
                holder.closeImg.setVisibility(View.VISIBLE);
                holder.finishImg.setVisibility(View.GONE);
                holder.tvState.setText(myGuide.status);
                holder.tvState.setTextColor(context.getColor(R.color.close_color));
            }
        }
        //electeric code
        {
            if (myGuide.difficulty.equals(context.getString(R.string.first))) {
                holder.elec1.setImageResource(R.drawable.electric_selected);
                holder.elec2.setImageResource(R.drawable.electric_selected);
                holder.elec3.setImageResource(R.drawable.electric);
                holder.elec4.setImageResource(R.drawable.electric);
                holder.elec5.setImageResource(R.drawable.electric);
                holder.elec6.setImageResource(R.drawable.electric);
            } else if (myGuide.difficulty.equals(context.getString(R.string.second))) {
                holder.elec1.setImageResource(R.drawable.electric_selected);
                holder.elec2.setImageResource(R.drawable.electric_selected);
                holder.elec3.setImageResource(R.drawable.electric_selected);
                holder.elec4.setImageResource(R.drawable.electric_selected);
                holder.elec5.setImageResource(R.drawable.electric);
                holder.elec6.setImageResource(R.drawable.electric);
            } else if (myGuide.difficulty.equals(context.getString(R.string.third))) {
                holder.elec1.setImageResource(R.drawable.electric_selected);
                holder.elec2.setImageResource(R.drawable.electric_selected);
                holder.elec3.setImageResource(R.drawable.electric_selected);
                holder.elec4.setImageResource(R.drawable.electric_selected);
                holder.elec5.setImageResource(R.drawable.electric_selected);
                holder.elec6.setImageResource(R.drawable.electric_selected);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView cover;
        private TextView title;
        private ImageView elec1;
        private ImageView elec2;
        private ImageView elec3;
        private ImageView elec4;
        private ImageView elec5;
        private ImageView elec6;
        private TextView difficulty;
        private TextView tvTime;
        private ImageView clockImg;
        private ImageView finishImg;
        private ImageView closeImg;
        private TextView tvState;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cover = (ImageView) itemView.findViewById(R.id.cover);
            title = (TextView) itemView.findViewById(R.id.title);
            elec1 = (ImageView) itemView.findViewById(R.id.elec1);
            elec2 = (ImageView) itemView.findViewById(R.id.elec2);
            elec3 = (ImageView) itemView.findViewById(R.id.elec3);
            elec4 = (ImageView) itemView.findViewById(R.id.elec4);
            elec5 = (ImageView) itemView.findViewById(R.id.elec5);
            elec6 = (ImageView) itemView.findViewById(R.id.elec6);
            difficulty = (TextView) itemView.findViewById(R.id.difficulty);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            clockImg = (ImageView) itemView.findViewById(R.id.clockImg);
            finishImg = (ImageView) itemView.findViewById(R.id.finishImg);
            closeImg = (ImageView) itemView.findViewById(R.id.closeImg);
            tvState = (TextView) itemView.findViewById(R.id.tvState);
        }
    }
}
