package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.database.MyDataBase;
import com.example.mygym.databinding.ActivityAddGuideBinding;
import com.example.mygym.moudle.MyGuide;

import java.util.Random;

public class AddGuideActivity extends AppCompatActivity {
    ActivityAddGuideBinding binding;
    MyDataBase db;
    String radioValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = new MyDataBase(this);

        binding.toolbar.title.setText("اضافة برنامج");
        binding.toolbar.backImg.setOnClickListener(view -> finish());

        binding.nameOfGuide.requestFocus();
        String[] content = new String[]{getString(R.string.start), getString(R.string.finish), getString(R.string.pause)};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item1, content);
        binding.spinner.setAdapter(adapter);

        binding.radio1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    binding.radio2.setChecked(false);
                    binding.radio3.setChecked(false);
                    binding.groupOne.setBackgroundResource(R.color.parentSelectedColor);
                    binding.groupTwo.setBackgroundResource(R.drawable.text_input_layout_shape);
                    binding.groupThree.setBackgroundResource(R.drawable.text_input_layout_shape);
                    radioValue = binding.radio1Val.getText().toString().trim();
                }
            }
        });
        binding.radio2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    binding.radio1.setChecked(false);
                    binding.radio3.setChecked(false);
                    binding.groupOne.setBackgroundResource(R.drawable.text_input_layout_shape);
                    binding.groupTwo.setBackgroundResource(R.color.parentSelectedColor);
                    binding.groupThree.setBackgroundResource(R.drawable.text_input_layout_shape);
                    radioValue = binding.radio2Val.getText().toString().trim();
                }
            }
        });
        binding.radio3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    binding.radio1.setChecked(false);
                    binding.radio2.setChecked(false);
                    binding.groupOne.setBackgroundResource(R.drawable.text_input_layout_shape);
                    binding.groupTwo.setBackgroundResource(R.drawable.text_input_layout_shape);
                    binding.groupThree.setBackgroundResource(R.color.parentSelectedColor);
                    radioValue = binding.radio3Val.getText().toString().trim();

                }
            }
        });
        binding.groupOne.setOnClickListener(view -> binding.radio1.setChecked(true));
        binding.groupTwo.setOnClickListener(view -> binding.radio2.setChecked(true));
        binding.groupThree.setOnClickListener(view -> binding.radio3.setChecked(true));
        binding.nameOfGuide.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                    binding.textInputLayout.setBackgroundResource(R.drawable.text_input_layout_shape_foucse);
                else
                    binding.textInputLayout.setBackgroundResource(R.drawable.text_input_layout_shape);
            }
        });
        binding.periodGuide.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                    binding.textInputLayout2.setBackgroundResource(R.drawable.text_input_layout_shape_foucse);
                else
                    binding.textInputLayout2.setBackgroundResource(R.drawable.text_input_layout_shape);
            }
        });
        binding.periodGuide.setOnKeyListener((view, i, keyEvent) -> {
            if (i == keyEvent.KEYCODE_ENTER) {
                Utils._HideKeyboard(AddGuideActivity.this, binding.periodGuide);
                binding.periodGuide.clearFocus();
                return true;
            }
            return false;
        });

        binding.btnSubmit.setOnClickListener(view -> {
            if (!Utils._valideText(binding.nameOfGuide)) {
                binding.nameOfGuide.setError("هذا الحقل مطلوب");
                binding.nameOfGuide.requestFocus();
                return;
            }
            if (!Utils._valideText(binding.periodGuide)) {
                binding.periodGuide.setError("هذا الحقل مطلوب");
                binding.periodGuide.requestFocus();
                return;
            }
            if (radioValue.isEmpty()) {
                Utils._Toast(AddGuideActivity.this, "يرجى تحديد مستوى البرنامج");
                return;
            }
            int arr[] = new int[]{R.drawable.cover_arm_1, R.drawable.cover_arm_2, R.drawable.cover_arm_3, R.drawable.cover_chest_3};
            Random random = new Random();
            int position = random.nextInt(3);
            MyGuide myGuide = new MyGuide(Utils._GetText(binding.nameOfGuide), Integer.parseInt(Utils._GetText(binding.periodGuide)), radioValue, Utils._GetText(binding.spinner), arr[position]);
            if (db.INSERT_GUIDE(myGuide)) {
                Utils._Toast(getApplicationContext(), "تم اضافة الجدول بنجاج");
                finish();
            }
        });

    }
}