package com.asphcalc.myapplication.model;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.asphcalc.myapplication.R;

public class TrasportFragment extends Fragment {
    private EditText number1;
    private EditText number2;
    private EditText number3;
    private TextView ris25;
    private TextView ris31;
    private TextView ris40;
    private TextView via25;
    private TextView via31;
    private TextView via40;
    private EditText materiale;
    private EditText viaggi;
    private EditText testopref;
    private Button clickme;
    private ImageView condividi;
    private TextView testo88;
    private String tappetinonew = "Tapettino";
    private Context c;

    private String portata25new = "25";
    private String portata31new = "31";
    private String portata40new = "40";

    // variabili per i calcoli
    private float num1 = 0;
    private float num2 = 0;
    private float num3 = 0;
    private float mat = 0;
    private int via = 0;
    private float r25 = 0;
    private float r31 = 0;
    private float r40 = 0;
    private float v25 = 0;
    private float v31 = 0;
    private float v40 = 0;

   public TrasportFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_trasport, container, false);



        c = this.getActivity().getApplicationContext();
        tappetinonew = PreferencesUtils.getString(c, R.string.pref_tappetino, "Tapettino");
        portata25new = PreferencesUtils.getString(c, R.string.pref_portata25, "25");
        portata31new = PreferencesUtils.getString(c, R.string.pref_portata31, "31");
        portata40new = PreferencesUtils.getString(c, R.string.pref_portata40, "40");


       // tappetinonew2 = PreferencesUtils.getString(c, R.string.TITOLO_PREF, "Tapettino");



        //testo88 = (TextView)rootView.findViewById(R.id.testo88);
        number1 = (EditText)rootView.findViewById(R.id.number1);
        number2 = (EditText)rootView.findViewById(R.id.number2);
        number3 = (EditText)rootView.findViewById(R.id.number3);
        via25 = (TextView)rootView.findViewById(R.id.risultato);
        via31 = (TextView)rootView.findViewById(R.id.via31);
        via40 = (TextView)rootView.findViewById(R.id.via40);
        ris25 = (TextView)rootView.findViewById(R.id.ris25);
        ris31 = (TextView)rootView.findViewById(R.id.ris31);
        ris40 = (TextView)rootView.findViewById(R.id.ris40);
        materiale = (EditText)rootView.findViewById(R.id.materiale);
        viaggi = (EditText)rootView.findViewById(R.id.viaggi);

        clickme = (Button)rootView.findViewById(R.id.clickme);



        number1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        number2.setImeOptions(EditorInfo.IME_ACTION_DONE);
        number3.setImeOptions(EditorInfo.IME_ACTION_DONE);
        materiale.setImeOptions(EditorInfo.IME_ACTION_DONE);
        viaggi.setImeOptions(EditorInfo.IME_ACTION_DONE);
        // pulsante in attesa e pronto a lanciare la funzione calculate()

        //testo88.setText(tappetinonew);

        number1.setText(portata25new);
        number2.setText(portata31new);
        number3.setText(portata40new);


        // PREMI IL PULSANTE E INVIA IL TOAST
        clickme.setOnClickListener(new Button.OnClickListener() {
            public void onClick (View v){ calculate();
                // chiudere la tastiera virtuale


                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(number1.getWindowToken(), 0);
            }

            // funzione calculate che somma num1+num2 presi dalle
            // EditText chiamate number1 e number2
            // e riporta il risultato, tot, nella TextView total
            private void calculate() {

                String numberzero = materiale.getText().toString();

                if (numberzero.equals("")) {
                    ris25.setText("0");
                    ris31.setText("0");
                    ris40.setText("0");
                    via25.setText("0");
                    via31.setText("0");
                    via40.setText("0");


                    Toast.makeText(getActivity().getApplicationContext(), R.string.ToastTrasporto, Toast.LENGTH_LONG).show();
                }


                else {
                    num1= Float.parseFloat(number1.getText().toString());
                    num2= Float.parseFloat(number2.getText().toString());
                    num3= Float.parseFloat(number3.getText().toString());
                    mat= Float.parseFloat(materiale.getText().toString());
                    via= Integer.parseInt(viaggi.getText().toString());

                    r25=(mat/num1);
                    r31=(mat/num2);
                    r40=(mat/num3);

                    String troncator25 = String.format("%.1f", r25);//valoretotale è il risultato delle mie operazioni
                    ris25.setText(""+troncator25);// e funzione, ho notato anche che arrotonda

                    String troncator31 = String.format("%.1f", r31);//valoretotale è il risultato delle mie operazioni
                    ris31.setText(""+troncator31);// e funzione, ho notato anche che arrotonda

                    String troncator40 = String.format("%.1f", r40);//valoretotale è il risultato delle mie operazioni
                    ris40.setText(""+troncator40);// e funzione, ho notato anche che arrotonda


                    v25=(r25/via);
                    v31=(r31/via);
                    v40=(r40/via);

                    //****  STRINGA VECCHIA X VISUALIZZARE TUTTI I DECIMALI
                    // risultato.setText(Float.toString(tot));



                    //testo nuovo x arrotondare e visualizzare solo 2 decimali
                    String troncato = String.format("%.1f", v25);//valoretotale è il risultato delle mie operazioni
                    via25.setText(""+troncato);// e funzione, ho notato anche che arrotonda

                    String troncato2 = String.format("%.1f", v31);//valoretotale è il risultato delle mie operazioni
                    via31.setText("" + troncato2);// e funzione, ho notato anche che arrotonda

                    String troncato3 = String.format("%.1f", v40);//valoretotale è il risultato delle mie operazioni
                    via40.setText(""+troncato3);// e funzione, ho notato anche che arrotonda


                    Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

// Vibrate for 300 milliseconds
                    mVibrator.vibrate(200);

                    Toast.makeText(getActivity().getApplicationContext(), R.string.toasttrasporto, Toast.LENGTH_LONG).show();


                }





// **************************prova immagine bottone************************





            }
        } );


        return rootView;
    }
}
