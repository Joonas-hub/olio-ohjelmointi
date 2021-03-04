package com.example.viikko_8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    BottleDispenser BD = BottleDispenser.getInstance();
    TextView moneyTextView;
    TextView addMoneyDisplay;
    TextView header;
    Spinner spinner;
    SeekBar seekBar;
    int selection = 0;
    Context context = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        moneyTextView = findViewById(R.id.money);
        addMoneyDisplay = findViewById(R.id.addMoneyDisplay);
        addMoneyDisplay.setText("0.00 €");
        header = findViewById(R.id.textView);
        seekBar = findViewById(R.id.seekBar);

        spinner = findViewById(R.id.spinner);
        ArrayList<Bottle> bottleArray = BD.getBottleArray();
        ArrayList<String> nameArray = new ArrayList<>();
        for (Bottle i : bottleArray){
            nameArray.add(i.getName() + "\t" + i.getSize() + " l" + "\t\t" + i.getPrice() + " €");
        }
        ArrayAdapter ada = new ArrayAdapter(this, android.R.layout.simple_spinner_item, nameArray);
        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ada);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                addMoneyDisplay.setText(String.valueOf(progress) + " €");
                int x = seekBar.getThumb().getBounds().left + 500;
                addMoneyDisplay.setX(x);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

   public void addMoney(View v){
        BD.addMoney(seekBar.getProgress());
        String moneyStr = String.format("%.2f", (BD.getMoney()));
        moneyTextView.setText(moneyStr + " €");
        seekBar.setProgress(0);
        header.setText("Welcome!");
   }
   public void returnMoney(View v){
        BD.returnMoney();
        moneyTextView.setText("0.00 €");
   }


   public void buy(View V){
        int buy = BD.buyBottle(selection);
        if (buy == 0) {
            String moneyStr = String.format("%.2f", (BD.getMoney()));
            moneyTextView.setText(moneyStr + " €");
            header.setText("Enjoy!");
        }
        else if (buy == 1){
            header.setText("Out of stock!");
        }
        else if (buy == 2){
            header.setText("Add more money!");
        }
   }

   public void receipt(View v){
           try {
               OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput("receipt.txt" ,Context.MODE_PRIVATE));
               String s = "";
               s = "RECEIPT\n" + BD.getLastPurchase();
               osw.write(s);
               osw.close();
               header.setText("Receipt saved");
           } catch (IOException e){
               Log.e("IOException", "Virhe syötteessä");
           }

   }
}









