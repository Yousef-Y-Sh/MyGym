package com.example.mygym.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.databinding.ActivityAddDaysBinding;
import com.example.mygym.moudle.MyGuide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Map;

public class AddDaysActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityAddDaysBinding binding;
    BottomSheetDialog bottomSheetDialog;
    BottomSheetBehavior bottomSheetBehavior;
    //inflate botttom sheet
    private CardView chest;
    private CardView shoulders;
    private CardView back;
    private CardView legs;
    private CardView stomach;
    private CardView baycep;
    private CardView triceps;
    private CardView forearms;
    MyGuide myGuide;
    int day = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddDaysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle b = getIntent().getExtras();
        if (b != null) {
            myGuide = b.getParcelable("object");
        }

        binding.imageView1.setOnClickListener(this);
        binding.imageView2.setOnClickListener(this);
        binding.imageView3.setOnClickListener(this);
        binding.imageView4.setOnClickListener(this);
        binding.imageView5.setOnClickListener(this);
        binding.imageView6.setOnClickListener(this);
        binding.imageView7.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView1:
                day = 1;
                break;
            case R.id.imageView2:
                day = 2;
                break;
            case R.id.imageView3:
                day = 3;
                break;
            case R.id.imageView4:
                day = 4;
                break;
            case R.id.imageView5:
                day = 5;
                break;
            case R.id.imageView6:
                day = 6;
                break;
            case R.id.imageView7:
                day = 7;
                break;
        }
        Map<String, Object> map = Utils._showBottomSheetFullScreen(AddDaysActivity.this, R.layout.menu_sheet, R.id.scroll);
        bottomSheetDialog = (BottomSheetDialog) map.get(Utils.__BOTTOMSHEETDIALOG);
        View v = (View) map.get(Utils.__VIEW);
        bottomSheetBehavior = (BottomSheetBehavior) map.get(Utils.__BOTTOMSHEETBEHAVIOR);


        chest = (CardView) v.findViewById(R.id.chest);
        shoulders = (CardView) v.findViewById(R.id.shoulders);
        back = (CardView) v.findViewById(R.id.back);
        legs = (CardView) v.findViewById(R.id.legs);
        stomach = (CardView) v.findViewById(R.id.stomach);
        baycep = (CardView) v.findViewById(R.id.baycep);
        triceps = (CardView) v.findViewById(R.id.triceps);
        forearms = (CardView) v.findViewById(R.id.forearms);


        chest.setOnClickListener(view1 -> {
            goIntent(Utils.__CHESTGUIDS);
        });
        shoulders.setOnClickListener(view1 -> {
            goIntent(Utils.__SHOULDERSGUIDS);
        });
        back.setOnClickListener(view1 -> {
            goIntent(Utils.__BACKGUIDS);
        });
        legs.setOnClickListener(view1 -> {
            goIntent(Utils.__LEGSGUIDS);
        });
        stomach.setOnClickListener(view1 -> {
            goIntent(Utils.__STOMACHGUIDS);
        });
        baycep.setOnClickListener(view1 -> {
            goIntent(Utils.__BAYCEPSGUIDS);
        });
        triceps.setOnClickListener(view1 -> {
            goIntent(Utils.__TRICEPSGUIDS);
        });
        forearms.setOnClickListener(view1 -> {
            goIntent(Utils.__FOREAMRMSGUIDS);
        });

    }

    void goIntent(String bundleValue) {
        Intent intent = new Intent(getApplicationContext(), SelectGuideActivity.class);
        intent.putExtra("data", bundleValue);
        intent.putExtra("object", myGuide);
        intent.putExtra("day", day);
        startActivity(intent);
        bottomSheetDialog.dismiss();

    }

}