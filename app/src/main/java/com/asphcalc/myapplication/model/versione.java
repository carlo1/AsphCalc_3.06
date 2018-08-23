package com.asphcalc.myapplication.model;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.asphcalc.myapplication.R;

/**
 * Created by carlo on 20/01/2015.
 */
public class versione extends Activity implements View.OnClickListener{
    private Button btnvota;
    private Button esci;
    private Button button_sitech;
    private WebView webView;
    private Button button_terracalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Info");
        setContentView(R.layout.dialogo2);

       button_sitech = (Button)findViewById(R.id.button_sitech);
       btnvota = (Button)findViewById(R.id.btnvota);
       esci = (Button) findViewById(R.id.esci);
       button_terracalc = (Button)findViewById(R.id.button_terracalc);

        button_terracalc.setOnClickListener(this);
        button_sitech.setOnClickListener(this);
        btnvota.setOnClickListener(this);
        esci.setOnClickListener(this);
    }

    @Override
   public void onClick(View v) {
       switch (v.getId()) {
           case R.id.btnvota:

               Toast.makeText(getApplicationContext(), R.string.ToastInternet, Toast.LENGTH_LONG).show();
               WebView myWebView = (WebView) findViewById(R.id.webView);
               myWebView.loadUrl("http://play.google.com/store/apps/details?id=com.asphcalc.myapplication");

               break;
           case R.id.button_sitech:
               Toast.makeText(getApplicationContext(), R.string.ToastInternet, Toast.LENGTH_LONG).show();
               WebView myWebView2 = (WebView) findViewById(R.id.webView);
               myWebView2.loadUrl("http://sitech-italia.it");


               break;
           case R.id.button_terracalc:
               Toast.makeText(getApplicationContext(), R.string.ToastInternet, Toast.LENGTH_LONG).show();
               WebView myWebView3 = (WebView) findViewById(R.id.webView);
               myWebView3.loadUrl("http://play.google.com/store/apps/details?id=com.asphcalc.terracalc");


               break;
            case R.id.esci:
               // tornare alla 1 pagina come appena avviata app
               //  Intent main = new Intent(versione.this, MainActivity.class)
               //    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               //   startActivity(main);
               // x tornare dove eri prima
                 finish();

              break;


        }
    }




}




