package com.asphcalc.myapplication.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.asphcalc.myapplication.R;

/**
 * Created by carlo on 20/01/2015.
 */
public class dialogo_impostazioni extends Activity implements View.OnClickListener{
    private Button btnvota;
    private Button btn_materiale;
    private Button esci;
    private Button btn_unita;
    private Button btn_trasporto;
    private Button button_sitech;
    private WebView webView;
    private Button button_terracalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Setting");
        setContentView(R.layout.fragment_dialogo_impostazioni);
        //button_sitech = (Button)findViewById(R.id.button_sitech);
      // btnvota = (Button)findViewById(R.id.btnvota);
        btn_materiale = (Button)findViewById(R.id.btn_materiale);
        btn_unita = (Button)findViewById(R.id.btn_unita);
        btn_trasporto = (Button)findViewById(R.id.btn_trasporto);
        esci = (Button) findViewById(R.id.esci);
        //button_terracalc = (Button)findViewById(R.id.button_terracalc);


        esci.setOnClickListener(this);
        btn_trasporto.setOnClickListener(this);
        btn_unita.setOnClickListener(this);
        btn_materiale.setOnClickListener(this);
    }

    @Override
   public void onClick(View v) {
       switch (v.getId()) {
           case R.id.btn_materiale:

               startActivity(new Intent(this,PreferencesFromXml.class));


               break;
           case R.id.btn_unita:
               startActivity(new Intent(this, PreferencesFromXml_unita.class));

               break;
           case R.id.btn_trasporto:
               startActivity(new Intent(this, PreferencesFromXml_trasporto.class));


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




