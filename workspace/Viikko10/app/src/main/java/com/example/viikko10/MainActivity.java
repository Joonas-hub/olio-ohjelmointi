package com.example.viikko10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    TextView addressView;
    WebView web;
    ArrayList<String> addressList = new ArrayList<>();
    ListIterator itr = addressList.listIterator();
    String lastMove = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addressView = findViewById(R.id.address);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
    }

    public void goButton(View v){
        if (itr.hasNext()){
            itr.next();
        }
         while (itr.hasNext()){
            itr.next();
            itr.remove();
        }

        String url = addressView.getText().toString();
        if (url.equals("index.html")){
            web.loadUrl("file:///android_asset/index.html");
        }
        else {
            url = "http://" + url;
            web.loadUrl(url);
            itr.add(url);
            lastMove = "next";
        }
    }

    public void refresh(View v){
        String url = web.getUrl();
        web.loadUrl(url);

    }

    public void evaluateJS(View v){
        web.evaluateJavascript("javascript:shoutOut()",null);
    }
    public void resetJS(View v){
        web.evaluateJavascript("javascript:initialize()",null);
    }

    public void nextPage(View v){
        if (itr.hasNext()){
            if (lastMove.equals("previous")){
                itr.next();
            }
            web.loadUrl((String) itr.next());
            lastMove = "next";
        }
    }
    public void previousPage(View v){
        if (itr.hasPrevious()){
            if (lastMove.equals("next")){
                itr.previous();
            }
            web.loadUrl((String) itr.previous());
            lastMove = "previous";
        }
    }
}