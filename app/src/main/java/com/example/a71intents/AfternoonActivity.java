package com.example.a71intents;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class AfternoonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afternoon);
        EditText timeAfternoon = (EditText) findViewById(R.id.afternoon_time);

        Intent intent = this.getIntent();
        String currentTime = intent.getStringExtra("currentTime");
        timeAfternoon.setText(currentTime);
    }

}
