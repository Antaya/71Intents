package com.example.a71intents;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class MorningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);
        EditText timeMorning = (EditText) findViewById(R.id.morning_time);

        Intent intent = this.getIntent();
        String currentTime = intent.getStringExtra("currentTime");
        timeMorning.setText(currentTime);
    }

}
