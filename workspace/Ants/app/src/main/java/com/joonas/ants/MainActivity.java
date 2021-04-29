package com.joonas.ants;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linearLayout = findViewById(R.id.linearLayout);
        //CustomView customView = new CustomView(this);
        //linearLayout.addView(customView);
    }
}