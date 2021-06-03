package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;

import java.util.ArrayList;


public class Text_view extends AppCompatActivity {
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_view);
        res = findViewById(R.id.text);
        Intent intent = getIntent();
        res.setText(intent.getStringExtra("res"));
    }
}