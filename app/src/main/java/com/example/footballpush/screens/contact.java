package com.example.footballpush.screens;

import android.os.Bundle;

import com.example.footballpush.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class contact extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_page);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
