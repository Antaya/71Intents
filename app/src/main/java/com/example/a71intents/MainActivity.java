package com.example.a71intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private String currentTime;
    private int hour;
    private String choiceUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentTime = getFormattedTime();

    }

    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_SYNC);
        intent.putExtra("currentTime", currentTime);
        intent.setData(Uri.parse(getUriString()));
        startActivity(intent);

    }


    public String getFormattedTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return dateFormatter.format(calendar.getTime());
    }

    public String getUriString() {
        currentTime = getFormattedTime();
        int hour = Integer.parseInt(currentTime.substring(0, 2));
        String uriString = "";
        //вставьте обработку условий по времени
        if (hour >= 6 && hour <= 13) {
            uriString = "http://morning";

            //intent.setData(Uri.parse("http://morning"));
        }

        if (hour == 14) {
            uriString = "http://afternoon";

            //intent.setData(Uri.parse("http://afternoon"));

        }

        if (hour >= 15 && hour <= 24 || hour >= 0 && hour <= 5) {
            uriString = "http://evening";
            // intent.setData(Uri.parse("http://evening"));
        }
        return uriString;
    }


}

