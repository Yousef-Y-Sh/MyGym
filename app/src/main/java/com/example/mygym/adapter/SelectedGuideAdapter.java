package com.example.mygym.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygym.R;
import com.example.mygym.moudle.Guide;

import java.util.ArrayList;
import java.util.List;

public class SelectedGuideAdapter extends RecyclerView.Adapter<SelectedGuideAdapter.MyViewHolder> {
    Context context;
    List<Guide> list;
    ImageButton imageButton;
    int counter = 0;

    public SelectedGuideAdapter(Context context, List<Guide> list, ImageButton imageButton) {
        this.context = context;
        this.list = list;
        this.imageButton = imageButton;
    }

    @NonNull
    @Override
    public SelectedGuideAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_03, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedGuideAdapter.MyViewHolder holder, int position) {
        holder.imgSrc.setImageResource(list.get(position).image);
        holder.title.setText(list.get(position).title);
        holder.id.setText((position + 1) + "");
        if (list.get(holder.getAdapterPosition()).isSelected) {
            holder.imgSelect.setVisibility(View.VISIBLE);
            imageButton.setVisibility(View.VISIBLE);
        } else holder.imgSelect.setVisibility(View.GONE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.get(holder.getAdapterPosition()).isSelected) {
                    list.get(holder.getAdapterPosition()).setSelected(false);
                    holder.imgSelect.setVisibility(View.GONE);
                } else {
                    list.get(holder.getAdapterPosition()).setSelected(true);
                    holder.imgSelect.setVisibility(View.VISIBLE);
                }
                if (getSelectedCount() != 0) {
                    imageButton.setVisibility(View.VISIBLE);
                } else {
                    imageButton.setVisibility(View.GONE);
                }
            }
        });

    }

    public int getSelectedCount() {
        counter = 0;
        for (Guide guide : list) {
            if (guide.isSelected) {
                counter += 1;
            }
        }
        return counter;
    }

    public List<Guide> getSelectedItem() {
        List<Guide> selectedItem = new ArrayList<>();
        for (Guide guide : list) {
            if (guide.isSelected) {
                selectedItem.add(guide);
            }
        }
        return selectedItem;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgSrc;
        private TextView title;
        private TextView id;
        private ImageView imgSelect;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSrc = (ImageView) itemView.findViewById(R.id.imgSrc);
            title = (TextView) itemView.findViewById(R.id.title);
            id = (TextView) itemView.findViewById(R.id.id);
            imgSelect = (ImageView) itemView.findViewById(R.id.imgSelect);
        }
    }
}
