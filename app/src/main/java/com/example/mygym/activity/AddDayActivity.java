package com.example.mygym.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mygym.R;

public class AddDayActivity extends AppCompatActivity {
    com.example.mygym.databinding.ActivityAddDayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_day);
    }
}