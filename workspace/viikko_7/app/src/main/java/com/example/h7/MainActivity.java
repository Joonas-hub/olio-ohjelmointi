package com.example.h7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Context context = null;
    TextView textView;
    EditText textInput;
    EditText textInput2;
    EditText saveload;
    EditText fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textInput = (EditText) findViewById(R.id.Text);
        textInput2 = (EditText) findViewById(R.id.Text2);
        saveload = (EditText) findViewById(R.id.saveload);
        fileName = (EditText) findViewById(R.id.filename);
        context = MainActivity.this;

        textInput2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textView.setText(textInput2.getText());
            }
        });
    }

    public void hello(View v){
        System.out.println("Hello World!");
        textView.setText("Hello World!");
        //textView.setText(textInput.getText());
    }

    public void hello2(View v){
        textView.setText(textInput.getText());
    }

    public void save(View v){
        try {
            OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput(fileName.getText().toString() ,Context.MODE_PRIVATE));
            String s = "";
            s = saveload.getText().toString();
            osw.write(s);
            osw.close();
            saveload.setText("");
        } catch (IOException e){
            Log.e("IOException", "Virhe syötteessä");
        }
    }

    public void load(View v){
        try {
            InputStream in = context.openFileInput(fileName.getText().toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String s = "";

            while ((s = br.readLine()) != null){
                saveload.setText(s);
                System.out.println("asdasdaassd");
            }
            in.close();
        } catch (IOException e){
            Log.e("IOException", "Virhe syötteessä");
        }
    }


}