package com.example.mygym.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddDayActivity extends AppCompatActivity {
    ActivityAddDayBinding binding;
    Bundle bundle;
    MyGuide parentIntentCollection;
    List<Guide> selectedList;
    private boolean falg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddDayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();
        selectedList = new ArrayList<>();
        binding.toolbar.title.setText("اضافة يوم تدريبي");
        binding.toolbar.backImg.setOnClickListener(view -> finish());
        binding.toolbar.save.setVisibility(View.VISIBLE);

        if (bundle.getParcelable(Utils.__INTENTCOLLECTION) != null) {
            parentIntentCollection = bundle.getParcelable(Utils.__INTENTCOLLECTION);
        }
        binding.toolbar.save.setOnClickListener(view -> {
            if (!Utils._valideText(binding.nameOfDay)) {
                binding.nameOfDay.setError("هذا الحقل مطلوب");
                return;
            }
        });
        onClickItem();

    }

    void onClickItem() {
        binding.chest.setOnClickListener(view -> goIntent(Utils.__CHESTGUIDS));
        binding.shoulders.setOnClickListener(view -> goIntent(Utils.__SHOULDERSGUIDS));
        binding.back.setOnClickListener(view -> goIntent(Utils.__BACKGUIDS));
        binding.legs.setOnClickListener(view -> goIntent(Utils.__LEGSGUIDS));
        binding.stomach.setOnClickListener(view -> goIntent(Utils.__STOMACHGUIDS));
        binding.baycep.setOnClickListener(view -> goIntent(Utils.__BAYCEPSGUIDS));
        binding.triceps.setOnClickListener(view -> goIntent(Utils.__TRICEPSGUIDS));
        binding.forearms.setOnClickListener(view -> goIntent(Utils.__FOREAMRMSGUIDS));
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

        KeyboardVisibilityEvent.setEventListener(AddDayActivity.this, new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                if (!isOpen) binding.nameOfDay.clearFocus();
            }
        });
    }

    private void goIntent(String type) {
        GuideIntent guideIntent = new GuideIntent(selectedList);
        Intent intent = new Intent(getApplicationContext(), SelectGuideActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("list", guideIntent);
        startActivityForResult(intent, 222);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == 222) {
                GuideIntent guideIntent = data.getParcelableExtra(Utils._DATA);
                shortImageController(guideIntent.getList());
                if (selectedList.isEmpty()) {
                    selectedList.addAll(guideIntent.getList());
                } else {
                    for (int i = 0; i <= guideIntent.getList().size() - 1; i++) {
                        falg = false;
                        for (int j = 0; j <= selectedList.size() - 1; j++) {
                            if (guideIntent.getList().get(i).getImage().equals(selectedList.get(j).getImage())) {
                                falg = true;
                            }
                        }
                        if (!falg) {
                            selectedList.add(guideIntent.getList().get(i));
                        }
                    }
                }
            }
        }
    }


    void shortImageController(List<Guide> list) {
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

    void inflateShortImage(LinearLayout linearLayout, ImageView imageView, int img) {
        linearLayout.setVisibility(View.VISIBLE);
        imageView.setImageResource(img);
    }

}
