package com.example.mygym.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.database.MyDataBase;
import com.example.mygym.databinding.ActivityAddDayBinding;
import com.example.mygym.moudle.Day;
import com.example.mygym.moudle.Guide;
import com.example.mygym.moudle.GuideIntent;
import com.example.mygym.moudle.MyGuide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddDayActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityAddDayBinding binding;
    List<Guide> selectedList;
    MyDataBase db;
    boolean flag = true;
    int idDayParent = -1;
    MyGuide guideParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddDayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = new MyDataBase(this);
        selectedList = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            guideParent = bundle.getParcelable("object");
        }
        binding.toolbar.save.setVisibility(View.VISIBLE);
        binding.toolbar.title.setText("إضافة يوم تدريبي");
        binding.toolbar.backImg.setOnClickListener(view -> finish());
        binding.nameOfDay.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                    binding.textInputLayout.setBackgroundResource(R.drawable.text_input_layout_shape_foucse);
                else
                    binding.textInputLayout.setBackgroundResource(R.drawable.text_input_layout_shape);
            }
        });
        binding.nameOfDay.setOnKeyListener((view, i, keyEvent) -> {
            if (i == keyEvent.KEYCODE_ENTER) {
                Utils._HideKeyboard(AddDayActivity.this, binding.nameOfDay);
                binding.nameOfDay.clearFocus();
                return true;
            }
            return false;
        });
        binding.toolbar.save.setOnClickListener(view -> {
            if (!Utils._valideText(binding.nameOfDay)) {
                binding.nameOfDay.setError("هذاالحقل مطلوب");
                return;
            }
            if (selectedList.isEmpty()) {
                Utils._Toast(getApplicationContext(), "يرجى تحديد التمارين لهذا اليوم");
                return;
            }
            idDayParent = db.INSERT_DAY(new Day(Utils._GetText(binding.nameOfDay), guideParent.getId()));
            if (idDayParent <= 0) {
                flag = false;
            }
            for (Guide guide : selectedList) {
                guide.setDayTitle(Utils._GetText(binding.nameOfDay));
                guide.setIdParent(idDayParent);
                guide.setSelected(false);
                boolean res = db.INSERT_MY_GUIDE(guide);
                if (!res) flag = false;
            }
            if (flag) {
                Map<String, Object> map = Utils._showDialog(AddDayActivity.this, R.layout.complete_add);
                View v = (View) map.get(Utils.__VIEW);
                TextView dissbtn = (TextView) v.findViewById(R.id.dissbtn);
                dissbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AddDayActivity.this, TrainingDaysActivity.class);
                        intent.putExtra("object", guideParent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });

        binding.chest.setOnClickListener(view ->

        {
            goIntent(Utils.__CHESTGUIDS);
        });
        binding.shoulders.setOnClickListener(view ->

        {
            goIntent(Utils.__SHOULDERSGUIDS);
        });
        binding.back.setOnClickListener(view ->

        {
            goIntent(Utils.__BACKGUIDS);
        });
        binding.legs.setOnClickListener(view ->

        {
            goIntent(Utils.__LEGSGUIDS);
        });
        binding.stomach.setOnClickListener(view ->

        {
            goIntent(Utils.__STOMACHGUIDS);
        });
        binding.baycep.setOnClickListener(view ->

        {
            goIntent(Utils.__BAYCEPSGUIDS);
        });
        binding.triceps.setOnClickListener(view ->

        {
            goIntent(Utils.__TRICEPSGUIDS);
        });
        binding.forearms.setOnClickListener(view ->

        {
            goIntent(Utils.__FOREAMRMSGUIDS);
        });
    }

    @Override
    public void onClick(View view) {

    }

    void goIntent(String bundleValue) {
        Intent intent = new Intent(getApplicationContext(), SelectGuideActivity.class);
        intent.putExtra("type", bundleValue);
        startActivityForResult(intent, 111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == RESULT_OK && data != null) {
            GuideIntent guideIntent = data.getParcelableExtra("list");
            List<Guide> list = guideIntent.getList();
            selectedList.addAll(list);
            switch (list.get(0).getType()) {
                case Utils.__BACKGUIDS:
                    inflateShortImage(binding.one, binding.oneImage, R.drawable.daher);
                    break;
                case Utils.__BAYCEPSGUIDS:
                    inflateShortImage(binding.two, binding.twoImage, R.drawable.bay);
                    break;
                case Utils.__CHESTGUIDS:
                    inflateShortImage(binding.three, binding.threeImage, R.drawable.sader);
                    break;
                case Utils.__FOREAMRMSGUIDS:
                    inflateShortImage(binding.four, binding.fourImage, R.drawable.formars_full);
                    break;
                case Utils.__LEGSGUIDS:
                    inflateShortImage(binding.five, binding.fiveImage, R.drawable.leg);
                    break;
                case Utils.__SHOULDERSGUIDS:
                    inflateShortImage(binding.sex, binding.sexImage, R.drawable.ketef);
                    break;
                case Utils.__STOMACHGUIDS:
                    inflateShortImage(binding.seven, binding.sevenImage, R.drawable.meda);
                    break;
                case Utils.__TRICEPSGUIDS:
                    inflateShortImage(binding.eight, binding.eightImage, R.drawable.tray_full);
                    break;
            }
        }
    }

    void inflateShortImage(LinearLayout linearLayout, ImageView imageView, int img) {
        linearLayout.setVisibility(View.VISIBLE);
        imageView.setImageResource(img);
    }
}