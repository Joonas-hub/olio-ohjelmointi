package com.joonas.harjoitusty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    Button dietOkButton, entryViewButton, graphViewButton;
    EntryManager entryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        File filePath = MainActivity.this.getFilesDir();
        entryManager = EntryManager.getInstance(filePath);
        dietOkButton = findViewById(R.id.dietEntryOKButton);
        entryViewButton = findViewById(R.id.newEntryView);
        graphViewButton = findViewById(R.id.graphView);


        View.OnClickListener fragmentButtonListener = new View.OnClickListener(){
            // Listener for fragment change buttons.
            @Override
            public void onClick(View v) {
                Fragment fragment;
                if (v == findViewById(R.id.newEntryView)){
                    fragment = new EntryFragment();
                }
                else{
                    fragment = new LogFragment();
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragmentWindow, fragment);
                transaction.commit();
            }
        };

        entryViewButton.setOnClickListener(fragmentButtonListener);
        graphViewButton.setOnClickListener(fragmentButtonListener);
    }

   public void dietEntry(String meatInputText, String vegInputText) {
        // Creates a new diet entry from user inputs and writes it to the log.
       if (meatInputText.length() == 0) {
           meatInputText = "0";
       }
       if (vegInputText.length() == 0) {
           vegInputText = "0";
       }
       System.out.println("Starting entry");
       entryManager.saveDietEntry(Float.parseFloat(meatInputText)/1000, Float.parseFloat(vegInputText)/1000);
       Toast.makeText(getApplicationContext(), "Entry saved", Toast.LENGTH_SHORT).show();
   }
   public void onStart(){
        // Calls dietEntry method. Reads user inputs sent by EntryFragment.
       super.onStart();
       try {
           String meatInputText = getIntent().getExtras().get("meat").toString();
           String vegInputText = getIntent().getExtras().get("veg").toString();
           dietEntry(meatInputText, vegInputText);
       }catch (NullPointerException e){
            e.printStackTrace();
       }
   }
}