package com.example.mygym.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.activity.AddDayActivity;
import com.example.mygym.activity.TrainingDaysActivity;
import com.example.mygym.database.MyDataBase;
import com.example.mygym.moudle.Day;
import com.example.mygym.moudle.Guide;
import com.example.mygym.moudle.GuideIntent;
import com.example.mygym.moudle.MyGuide;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllDaysAdapter extends RecyclerView.Adapter<AllDaysAdapter.MyViewHolder> {
    Activity activity;
    List<Day> list;
    MyDataBase db;
    MyGuide myGuide;
    boolean flag = true;
    private GuideAdapter guideAdapter;
    //////////// inflate alert dialog R.layout.confirm_delete
    View v;
    AlertDialog bottomSheetDialog;
    private TextView disBtn;
    private TextView deleteBtn;

    public AllDaysAdapter(Activity activity, List<Day> list, MyGuide myGuide) {
        this.activity = activity;
        this.list = list;
        db = new MyDataBase(activity);
        this.myGuide = myGuide;
    }

    @NonNull
    @Override
    public AllDaysAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_04, parent, false);
        return new MyViewHolder(v);
    }

    public void setList(List<Day> list) {
        this.list = list;
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
                guideAdapter = new GuideAdapter(activity, db.GET_ALL_MY_GUIDES(list.get(holder.getAdapterPosition()).getId()));
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
        holder.option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(activity, holder.option);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.delete:
                                Map<String, Object> map = Utils._showDialog(activity, R.layout.confirm_dialog);
                                v = (View) map.get(Utils.__VIEW);
                                bottomSheetDialog = (AlertDialog) map.get(Utils.__BOTTOMSHEETDIALOG);

                                deleteBtn = (TextView) v.findViewById(R.id.deleteBtn);
                                disBtn = (TextView) v.findViewById(R.id.disBtn);

                                deleteBtn.setOnClickListener(view -> {
                                    for (Guide guide : db.GET_ALL_MY_GUIDES(list.get(holder.getAdapterPosition()).getId())) {
                                        boolean res = db.DELETE_MY_GUIDE(guide.getId());
                                        if (!res) flag = false;

                                    }
                                    if (flag) {
                                        boolean res = db.DELETE_MY_DAY(list.get(holder.getAdapterPosition()).getId(), myGuide.getId());
                                        if (!res) flag = false;
                                        if (flag) {
                                            setList(db.GET_ALL_DAYS(myGuide.getId()));
                                            notifyDataSetChanged();
                                            bottomSheetDialog.dismiss();
                                        }
                                    }
                                });
                                disBtn.setOnClickListener(view -> {
                                    bottomSheetDialog.dismiss();
                                });
                                break;
                            case R.id.update:
                                GuideIntent guideIntent = new GuideIntent(db.GET_ALL_MY_GUIDES(list.get(holder.getAdapterPosition()).getId()));
                                Intent intent = new Intent(activity, AddDayActivity.class);
                                intent.putExtra("object", myGuide);
                                intent.putExtra("list", guideIntent);
                                intent.putExtra("day", list.get(holder.getAdapterPosition()));
                                activity.startActivity(intent);
                                break;
                        }
                        return true;
                    }
                });
                popup.show();
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
        private ImageView option;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout2 = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout2);
            imgOpen = (TextView) itemView.findViewById(R.id.imgOpen);
            title = (TextView) itemView.findViewById(R.id.title);
            recycleItem = (RecyclerView) itemView.findViewById(R.id.recycleItem);
            option = (ImageView) itemView.findViewById(R.id.option);

        }
    }
}
