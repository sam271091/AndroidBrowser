package com.example.androidbrowser;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView web;
    String URL;
    EditText editText;
    private Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GoToURL("https://www.google.com");


        Toast.makeText(MainActivity.this,"Warning!All urls must start with http or https!",Toast.LENGTH_LONG).show();

        goButton = (Button)findViewById(R.id.go) ;
        editText = (EditText)findViewById(R.id.URL);

        addListenerOnButton();


    }


    public void addListenerOnButton() {
      goButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              URL = editText.getText().toString();
              GoToURL(URL);
          }
      });
    }



    public void GoToURL(String url){
        web = (WebView)findViewById(R.id.webView);
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        web.loadUrl(url);
        web.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack())
            web.goBack();
        else
        super.onBackPressed();
    }
}
