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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.asphcalc.myapplication.R;

public class VerifyFragment extends Fragment {

    // prova somma demo
    private EditText number1;
    private EditText number2;
    private EditText number3;
    private TextView risultato;
    private Button clickme;
    private Button btninv;
    private ImageView condividi;
    private Spinner spinner;
    private TextView testomat;
    private EditText number4;
    // variabili per i calcoli
    private int num1 = 0;
    private float num2 = 0;
    private float num3 = 0;
    private float tot=0;
    private float num4=0;
    private String pesosp;
    private String pesospecif21new ="2.1";
    private String pesospecif22new ="2.2";
    private String pesospecif23new ="2.3";
    private String pesospecif235new ="2.35";
    private String unitamisuranew = "Ton.";
    private Context c;
    private TextView textview8;
    private String tappetinonuovo="Tappetino";
    private String bindernuovo="Binder";
    private String toutvenantnuovo="Tout-Venant";
    private String tappetinomodificatonuovo="Tappetino Mod.";


    public VerifyFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_verify2, container, false);


        c = this.getActivity().getApplicationContext();
        unitamisuranew = PreferencesUtils.getString(c, R.string.pref_unitamisura, "Ton.");
        pesospecif21new = PreferencesUtils.getString(c, R.string.pref_pesospec21, "2.1");
        pesospecif22new = PreferencesUtils.getString(c, R.string.pref_pesospec22, "2.2");
        pesospecif23new = PreferencesUtils.getString(c, R.string.pref_pesospec23, "2.3");
        pesospecif235new = PreferencesUtils.getString(c, R.string.pref_pesospec235, "2.35");
        tappetinonuovo = PreferencesUtils.getString(c, R.string.pref_tappetino, "Tappetino");
        bindernuovo = PreferencesUtils.getString(c, R.string.pref_binder, "Binder");
        toutvenantnuovo = PreferencesUtils.getString(c, R.string.pref_toutvenant, "Tout-Venant");
        tappetinomodificatonuovo = PreferencesUtils.getString(c, R.string.pref_tappetimodificato, "Tappetino mod.");




        textview8 = (TextView)rootView.findViewById(R.id.textView8);
        number1 = (EditText)rootView.findViewById(R.id.number1);
        number2 = (EditText)rootView.findViewById(R.id.number2);
        number3 = (EditText)rootView.findViewById(R.id.number3);
        // ok
        risultato = (TextView)rootView.findViewById(R.id.risultato);
        clickme = (Button)rootView.findViewById(R.id.clickme);
        testomat = (TextView)rootView.findViewById(R.id.testomat);
        condividi = (ImageView)rootView.findViewById(R.id.condividi2);

        number1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        number2.setImeOptions(EditorInfo.IME_ACTION_DONE);
        number3.setImeOptions(EditorInfo.IME_ACTION_DONE);

        // pulsante in attesa e pronto a lanciare la funzione calculate()

        textview8.setText(unitamisuranew+" x MC.");
        //PROVA SPINNER


        final Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);

        //e il listener che verra' eseguito quando l'utente seleziona un elemento





        String materiali3[] = {tappetinonuovo,bindernuovo,toutvenantnuovo,tappetinomodificatonuovo};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,materiali3);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> adapter, View view,int pos, long id ) {
                final String selected = (String)adapter.getItemAtPosition(pos);
                //Toast.makeText(
                //      getApplicationContext(),
                //   "hai selezionato "+selected ,
                // Toast.LENGTH_LONG
                // ).show();

                testomat.setText((selected));

                //CAMBIO PESO SPECIFICO

                if (selected.equals (tappetinonuovo)){
                    number3.setText((pesospecif23new));
                    risultato.setText(R.string.ricalcola);
                    //number3.setText(("23"));
                }

                else if (selected.equals(bindernuovo)){
                    number3.setText((pesospecif22new));
                    risultato.setText(R.string.ricalcola);
                }
                else if (selected.equals(toutvenantnuovo)){
                    number3.setText((pesospecif21new));
                    risultato.setText(R.string.ricalcola);
                }

                else if (selected.equals(tappetinomodificatonuovo)){
                    number3.setText((pesospecif235new));
                    risultato.setText(R.string.ricalcola);
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
                String numberzero2 = number2.getText().toString();

                if (numberzero.equals("")) {
                    risultato.setText("0");
                    Toast.makeText(getActivity().getApplicationContext(), R.string.toastarea, Toast.LENGTH_LONG).show();
                }




                else if (numberzero2.equals("")) {
                    risultato.setText("0");
                    Toast.makeText( getActivity().getApplicationContext(), R.string.toasttonelate,Toast.LENGTH_LONG).show();
                }

                else {
                    num1=Integer.parseInt(number1.getText().toString());
                    num2=Float.parseFloat(number2.getText().toString());
                    num3=Float.parseFloat(number3.getText().toString());


                    tot=(num2/num3/num1*100);
                    //****  STRINGA VECCHIA X VISUALIZZARE TUTTI I DECIMALI
                    //risultato.setText(Float.toString(tot));


                    //testo nuovo x arrotondare e visualizzare solo 2 decimali
                    String troncato = String.format ("%.2f", tot);//valoretotale è il risultato delle mie operazioni
                    risultato.setText(""+troncato);// e funzione, ho notato anche che arrotonda

                    Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

// Vibrate for 300 milliseconds
                    mVibrator.vibrate(200);

                    Toast.makeText( getActivity().getApplicationContext(), R.string.toastcondividi,Toast.LENGTH_LONG).show();
                    condividi.setVisibility(View.VISIBLE);

                }

            }



            {



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
                final Intent Intent =  new  Intent ();
                Intent.setType("text/plain");
                Intent . setAction(Intent.ACTION_SEND);

                Intent . putExtra(Intent.EXTRA_TEXT,getResources().getString(R.string.toastlospessore) + " " + testomat.getText()+" "+
                        getResources().getString(R.string.e)+ " "+ risultato.getText() +" " +getResources().getString(R.string.centimetro));
                startActivity(Intent.createChooser(Intent, getString(R.string.share_message)));



            }


        } );


        return rootView;
        }
        }

