package com.example.mygym.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.moudle.Guide;

import java.util.ArrayList;
import java.util.List;

public class RearrangeAdapter extends RecyclerView.Adapter<RearrangeAdapter.MyViewHolder> {
    Context context;
    List<Guide> list;

    public RearrangeAdapter(Context context, List<Guide> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RearrangeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_06, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RearrangeAdapter.MyViewHolder holder, int position) {
        int img = context.getResources().getIdentifier("drawable/" + list.get(position).getImage(), null, context.getPackageName());
        holder.imgSrc.setImageResource(img);
        holder.title.setText(list.get(position).title);
        holder.type.setText(list.get(position).title);
        holder.id.setText((position + 1) + "");
        holder.type.setVisibility(View.VISIBLE);
        switch (list.get(position).getType()) {
            case Utils.__BACKGUIDS:
                holder.type.setText(context.getText(R.string.back));
                break;
            case Utils.__BAYCEPSGUIDS:
                holder.type.setText(context.getText(R.string.baysep));
                break;
            case Utils.__CHESTGUIDS:
                holder.type.setText(context.getText(R.string.chest));
                break;
            case Utils.__FOREAMRMSGUIDS:
                holder.type.setText(context.getText(R.string.formar));
                break;
            case Utils.__LEGSGUIDS:
                holder.type.setText(context.getText(R.string.leg));
                break;
            case Utils.__SHOULDERSGUIDS:
                holder.type.setText(context.getText(R.string.soulder));
                break;
            case Utils.__STOMACHGUIDS:
                holder.type.setText(context.getText(R.string.stomach));
                break;
            case Utils.__TRICEPSGUIDS:
                holder.type.setText(context.getText(R.string.trycep));
                break;
        }
    }


    public int getItemSelectedCount() {
        int i = 0;
        for (Guide guide : list) {
            if (guide.isSelected) i += 1;
        }
        return i;
    }

    public List<Guide> getItemSelected() {
        List<Guide> guides = new ArrayList<>();
        for (Guide guide : list) {
            if (guide.isSelected) guides.add(guide);
        }
        return guides;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgSrc;
        private ImageView move;
        private TextView title;
        private TextView type;
        private TextView id;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSrc = (ImageView) itemView.findViewById(R.id.imgSrc);
            move = (ImageView) itemView.findViewById(R.id.move);
            title = (TextView) itemView.findViewById(R.id.title);
            type = (TextView) itemView.findViewById(R.id.type);
            id = (TextView) itemView.findViewById(R.id.id);

        }
    }
}
