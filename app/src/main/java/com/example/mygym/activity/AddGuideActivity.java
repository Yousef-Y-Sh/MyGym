package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.databinding.ActivityAddGuideBinding;

public class AddGuideActivity extends AppCompatActivity {
    ActivityAddGuideBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.nameOfGuide.requestFocus();
        String[] content = new String[]{"بدء التقدم", "تم انجازه", "ايقاف البرنامج مؤقتا"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item1, content);
        binding.spinner.setAdapter(adapter);

        binding.plus.setOnClickListener(view -> {
            int number = Integer.parseInt(binding.countOfDay.getText().toString());
            if (number < 7) binding.countOfDay.setText((number + 1) + "");
        });
        binding.minus.setOnClickListener(view -> {
            int number = Integer.parseInt(binding.countOfDay.getText().toString());
            if (number > 1) binding.countOfDay.setText((number - 1) + "");
        });

        binding.radio1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    binding.radio2.setChecked(false);
                    binding.radio3.setChecked(false);
                    binding.groupOne.setBackgroundResource(R.color.parentSelectedColor);
                    binding.groupTwo.setBackgroundResource(R.drawable.text_input_layout_shape);
                    binding.groupThree.setBackgroundResource(R.drawable.text_input_layout_shape);
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
    }
}