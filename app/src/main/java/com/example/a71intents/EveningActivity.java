package com.example.a71intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class EveningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening);
        EditText timeEvening = (EditText) findViewById(R.id.evening_time);

        Intent intent = this.getIntent();
        String currentTime = intent.getStringExtra("currentTime");
        timeEvening.setText(currentTime);
    }


}
