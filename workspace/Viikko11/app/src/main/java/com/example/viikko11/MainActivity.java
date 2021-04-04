package com.example.viikko11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DrawerLayout dLayout;
    NavigationView navView;
    EditText writeText;
    TextView readText, displayText, displayGet;
    Switch switch2;
    EditText font, lines, width, height;
    Button button;
    RadioButton fin, eng, swe;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = MainActivity.this;

        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.navigation_view);
        button = (Button) findViewById(R.id.button);
        writeText = (EditText) findViewById(R.id.writeTextField);
        readText = (TextView) findViewById(R.id.readTextField);
        font = (EditText) findViewById(R.id.fontSize);
        lines = (EditText) findViewById(R.id.lineNumber);
        width = (EditText) findViewById(R.id.width);
        height = (EditText) findViewById(R.id.height);
        displayText = (TextView) findViewById(R.id.displayView);
        displayGet  = (EditText) findViewById(R.id.displayText);
        fin = (RadioButton) findViewById(R.id.radioFin);
        eng = (RadioButton) findViewById(R.id.radioEng);
        swe = (RadioButton) findViewById(R.id.radioSwe);
        radioGroup = findViewById(R.id.radiogroup);
        eng.setChecked(true);
        switch2 = (Switch) findViewById(R.id.switch1);
        switch2.setChecked(true);
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    System.out.println("ON");
                    writeText.setEnabled(true);
                }
                else{
                    System.out.println("OFF");
                    writeText.setEnabled(false);
                    readText.setText(writeText.getText());
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String lang = "";
                if (checkedId == R.id.radioEng){
                    lang = "en";
                }
                else if (checkedId == R.id.radioFin){
                    lang = "fi";
                }
                Resources res = context.getResources();
                Locale locale = new Locale(lang);
                Locale.setDefault(locale);
                Configuration config = res.getConfiguration();
                config.setLocale(locale);
                //config.setLayoutDirection(locale);

                Context context2 = createConfigurationContext(config);
                Resources res2 = context2.getResources();

            }
        });
    }


        public void applySettings(View v){
            if (font.getText().length() > 0){
                readText.setTextSize(Float.parseFloat(font.getText().toString()));
            }
            if (lines.getText().length() > 0){
                readText.setLines(Integer.parseInt(lines.getText().toString()));
            }
            if (width.getText().length() > 0){
                readText.setRotation(Float.parseFloat(width.getText().toString()));
            }
            if (height.getText().length() > 0){
                readText.setTranslationY(Float.parseFloat(height.getText().toString())+100);
            }
            if (displayGet.getText().length() > 0) {
                displayText.setText(displayGet.getText());
            }
            dLayout.closeDrawers();

        }

}