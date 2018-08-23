package com.asphcalc.myapplication.model;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.asphcalc.myapplication.R;

public class WorkProgressFragment extends Fragment {
    private EditText number1;
    private EditText number2;
    private EditText number3;
    private EditText number5;
    private TextView risultato;
    private Button clickme;
    private Button btninv;
    private ImageButton condividi2;
    private ImageView condividi;
    private Spinner spinner;
    private TextView testomat;
    private EditText number4;
    // variabili per i calcoli
    private int num1 = 0;
    private float num2 = 0;
    private float num3 = 0;
    private float num5 = 0;
    private float tot=0;
    private float num4=0;
    private String pesosp;
    private TextView textView7;
    private String tappetinonuovo="Tappetino";
    private String bindernuovo="Binder";
    private String toutvenantnuovo="Tout-Venant";
    private String tappetinomodificatonuovo="Tappetino Mod.";

    public WorkProgressFragment(){}
    private String unitamisuranew = "Ton.";
    private Context c;
     private TextView textum;
    private TextView textview8;
    private String pesospecif21new ="2.1";
    private String pesospecif22new ="2.2";
    private String pesospecif23new ="2.3";
    private String pesospecif235new ="2.35";
    private String spessore1new = "3";
    private String spessore2new = "5";
    private String spessore3new = "10";
    private String spessore4new = "4";
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_workprogress, container, false);

        c = this.getActivity().getApplicationContext();
        tappetinonuovo = PreferencesUtils.getString(c, R.string.pref_tappetino, "Tappetino");
        bindernuovo = PreferencesUtils.getString(c, R.string.pref_binder, "Binder");
        toutvenantnuovo = PreferencesUtils.getString(c, R.string.pref_toutvenant, "Tout-Venant");
        tappetinomodificatonuovo = PreferencesUtils.getString(c, R.string.pref_tappetimodificato, "Tappetino mod.");

        unitamisuranew = PreferencesUtils.getString(c, R.string.pref_unitamisura, "Ton.");
        pesospecif21new = PreferencesUtils.getString(c, R.string.pref_pesospec21, "2.1");
        pesospecif22new = PreferencesUtils.getString(c, R.string.pref_pesospec22, "2.2");
        pesospecif23new = PreferencesUtils.getString(c, R.string.pref_pesospec23, "2.3");
        pesospecif235new = PreferencesUtils.getString(c, R.string.pref_pesospec235, "2.35");
        spessore1new =PreferencesUtils.getString(c, R.string.pref_spessore1, "3");
        spessore2new =PreferencesUtils.getString(c, R.string.pref_spessore2, "5");
        spessore3new =PreferencesUtils.getString(c, R.string.pref_spessore3, "10");
        spessore4new =PreferencesUtils.getString(c, R.string.pref_spessore4, "4");




        textview8 = (TextView)rootView.findViewById(R.id.textView8);
        textum = (TextView)rootView.findViewById(R.id.textum);
        number1 = (EditText)rootView.findViewById(R.id.number1);
        number2 = (EditText)rootView.findViewById(R.id.number2);
        number3 = (EditText)rootView.findViewById(R.id.number3);
        number4 = (EditText)rootView.findViewById(R.id.number4);
        number5 = (EditText)rootView.findViewById(R.id.number5);
        risultato = (TextView)rootView.findViewById(R.id.risultato);
        clickme = (Button)rootView.findViewById(R.id.clickme);
        testomat = (TextView)rootView.findViewById(R.id.testomat);
        textView7 = (TextView)rootView.findViewById(R.id.textView7);
        condividi = (ImageView)rootView.findViewById(R.id.condividi2);

       // funzione + inerire il tasto fine nella calcolatrice
        number1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        number2.setImeOptions(EditorInfo.IME_ACTION_DONE);
        number3.setImeOptions(EditorInfo.IME_ACTION_DONE);
        number5.setImeOptions(EditorInfo.IME_ACTION_DONE);
        // pulsante in attesa e pronto a lanciare la funzione calculate()


        textview8.setText(unitamisuranew+" x MC.");
        textum.setText(getResources().getString(R.string.toastwork_misura)+" "+unitamisuranew+" ( B )");
        //PROVA SPINNER
        final Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);


        String materiali3[] = {tappetinonuovo,bindernuovo,toutvenantnuovo,tappetinomodificatonuovo};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,materiali3);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);





        //e il listener che verra' eseguito quando l'utente seleziona un elemento

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapter, View view,int pos, long id ) {
                final String selected = (String)adapter.getItemAtPosition(pos);
                //Toast.makeText(
                //      getApplicationContext(),
                //   "hai selezionato "+selected ,
                // Toast.LENGTH_LONG
                // ).show();

               // testomat.setText((selected));

                //CAMBIO PESO SPECIFICO

                if (selected.equals (tappetinonuovo)){
                    number3.setText((pesospecif23new));
                    number2.setText((spessore1new));
                    risultato.setText(R.string.ricalcola);
                 //   testomat.setText(tappetinonuovo);
                }
               //  codice x recuperare il valore uguale alla stringa
               // else if (selected.equals(getResources().getString(R.string.binder))){
                else if (selected.equals(bindernuovo)){
                    number3.setText((pesospecif22new));
                    number2.setText((spessore2new));
                    risultato.setText(R.string.ricalcola);
                   // testomat.setText(bindernuovo);
                }
                else if (selected.equals(toutvenantnuovo)){
                    number3.setText((pesospecif21new));
                    number2.setText((spessore3new));
                    risultato.setText(R.string.ricalcola);
                  //  testomat.setText(toutvenantnuovo);

                }

                else if (selected.equals(tappetinomodificatonuovo)){
                    number3.setText((pesospecif235new));
                    number2.setText((spessore4new));
                    risultato.setText(R.string.ricalcola);
                 //   testomat.setText(tappetinomodificatonuovo);
                }
                else {
                    number3.setText(("2"));
                }

                //nome = "Tappetino";int c = ...;


            }

            public void onNothingSelected(AdapterView<?> arg0) {}
        });


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

        String numberzero = number1.getText().toString();
        String numberzero1 = number5.getText().toString();
        if (numberzero.equals("")) {
            risultato.setText("Ricalcola");
            Toast.makeText(getActivity().getApplicationContext(), R.string.toastvalore, Toast.LENGTH_LONG).show();
        }


        else if (numberzero1.equals("")) {
            risultato.setText("Ricalcola");
            Toast.makeText(getActivity().getApplicationContext(), R.string.toastvalore, Toast.LENGTH_LONG).show();
        }

        else {
            num1= Integer.parseInt(number1.getText().toString());
            num2= Float.parseFloat(number2.getText().toString());
            num3= Float.parseFloat(number3.getText().toString());
            num5= Float.parseFloat(number5.getText().toString());


            tot=(num1/num3/num2/num5*100);


            //****  STRINGA VECCHIA X VISUALIZZARE TUTTI I DECIMALI
            //risultato.setText(Float.toString(tot));


            //testo nuovo x arrotondare e visualizzare solo 2 decimali
            String troncato = String.format("%.1f", tot);//valoretotale è il risultato delle mie operazioni
            risultato.setText(""+troncato);// e funzione, ho notato anche che arrotonda

            Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

// Vibrate for 300 milliseconds
            mVibrator.vibrate(200);




          //  ottobre 2015 ******************    bottone x condividere il risultato ************************
           // Toast.makeText(getActivity().getApplicationContext(), R.string.toastcondividi, Toast.LENGTH_LONG).show();
           // condividi.setVisibility(View.VISIBLE);

        }





// **************************prova immagine bottone************************



        condividi.setOnClickListener(new Button.OnClickListener() {
            public void onClick (View v){ condividere();

            }

        });

    }




    private void condividere() {
        // spinner = (Spinner) findViewById(R.id.spinner);
        //String item = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), item, Toast.LENGTH_LONG).show();

        Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

// Vibrate for 300 milliseconds




        mVibrator.vibrate(200);
        final Intent Intent =  new android.content.Intent();
        Intent.setType("text/plain");
        Intent . setAction(Intent.ACTION_SEND);

        //Intent . putExtra(Intent.EXTRA_TEXT," Servono " + ""+ testomat.getText() +"tonnelate "+ risultato.getText ());
        Intent . putExtra(Intent.EXTRA_TEXT,getResources().getString(R.string.toastservono) + " " + risultato.getText() +" " +unitamisuranew+" "+getResources().getString(R.string.toasttonnellate_di)+" " + testomat.getText() );
        startActivity(Intent.createChooser(Intent, getString(R.string.share_message)));


    }
   } );


            return rootView;
    }
}
