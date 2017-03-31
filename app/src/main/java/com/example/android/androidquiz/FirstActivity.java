package com.example.android.androidquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FirstActivity extends AppCompatActivity {
    static final String CATEGORY = "CATEGORY";
    static final char ANDROID_CATEGORY = 'a';
    static final char GEOGRAPHY_CATEGORY = 'g';
    static final char ARDUINO_CATEGORY = 'r';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void startAndroidQuiz(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(CATEGORY, ANDROID_CATEGORY);
        startActivity(i);
    }

    public void startGeographyQuiz(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(CATEGORY, GEOGRAPHY_CATEGORY);
        startActivity(i);
    }

    public void startArduinoQuiz(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(CATEGORY, ARDUINO_CATEGORY);
        startActivity(i);
    }
}
