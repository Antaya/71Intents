package com.example.a71intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button SynchronizationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:ss");
        Calendar c = Calendar.getInstance();

        int minutes = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR);
        String currentDateTime = hour + ":" + minutes;

        Intent intent = new Intent(Intent.ACTION_SYNC);
//вставьте обработку условий по времени
        if (hour >= 6 && hour <= 13) {
            intent.setData(Uri.parse("http://morning"));
        }

        if (hour == 14) {
            intent.setData(Uri.parse("http://afternoon "));
        }

        if (hour >= 15 && hour <= 24 || hour >= 0 && hour <= 5) {
            intent.setData(Uri.parse("http://evening "));
        }

        Toast.makeText(this, currentDateTime, Toast.LENGTH_SHORT).show();

        //intent.putExtra("Time", currentDateTime);
        startActivity(intent);

    }
}
