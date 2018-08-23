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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.asphcalc.myapplication.R;



public class area2Fragment extends Fragment {

    private EditText numlar;
    private EditText numlun;
    private EditText numalt;
    private TextView textviewparziale;
    private TextView textviewtotale;
    private TextView textviewparziale2;
    private TextView textviewconta;
    private Button buttoncal;
    private ImageButton buttonagg;
    private ImageButton buttonazz;
    private Button btnret;
    private Button btntra;
    private Button btncer;
    private TextView testo_nomearea;

    private float num1 = 0;
    private float num2 = 0;
    private float tot1=0;
    private float tot12=0;
    private float tot2=0;
    private float num_raggio=0;
    private float num3 = 0;
    private int con1=0;

    public area2Fragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_area_new, container, false);

        numlar = (EditText)rootView.findViewById(R.id.numlar);
        numlun = (EditText)rootView.findViewById(R.id.numlun);
        numalt = (EditText)rootView.findViewById(R.id.numbase);
        textviewparziale = (TextView)rootView.findViewById(R.id.textViewparziale);
        textviewtotale = (TextView)rootView.findViewById(R.id.textViewtotale);
        textviewparziale2 = (TextView)rootView.findViewById(R.id.textViewparziale2);
        buttoncal = (Button)rootView.findViewById(R.id.button_calc);
        buttonagg = (ImageButton)rootView.findViewById(R.id.button_add);
        buttonazz = (ImageButton)rootView.findViewById(R.id.button_cest);
        textviewconta = (TextView)rootView.findViewById(R.id.textView_Sez);
        btnret =  (Button)rootView.findViewById(R.id.btn_verde_rect);
        btntra =  (Button)rootView.findViewById(R.id.btn_verde_trap);
        btncer =  (Button)rootView.findViewById(R.id.btn_verde_cerchio);
        testo_nomearea = (TextView)rootView.findViewById(R.id.tipo_area);
        numlar.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        numlun.setImeOptions(EditorInfo.IME_ACTION_DONE);
        numalt.setImeOptions(EditorInfo.IME_ACTION_DONE);
        numalt.setVisibility(View.INVISIBLE);
        btnret.setBackground(getResources().getDrawable(R.drawable.button_verde_pressed_rectangle));

        // quando si clicca su forma area


        btnret.setOnClickListener(new Button.OnClickListener() {
            public void onClick (View v){ calculate_rectangle();
                // chiudere la tastiera virtuale

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(numlun.getWindowToken(), 0);
            }



            private void calculate_rectangle() {
            testo_nomearea.setText("Rettangolo");
            numlar.setHint("Larghezza");
            numlun.setHint("Lunghezza");
            numalt.setHint("");
                numlun.setText("");
                numlar.setText("");
                numalt.setText("");
            numlar.setEnabled(true);
            numlun.setEnabled(true);
            numalt.setEnabled(false);
            numlun.setVisibility(View.VISIBLE);
            numalt.setVisibility(View.INVISIBLE);
            numlar.setImeOptions(EditorInfo.IME_ACTION_NEXT);
            numlun.setImeOptions(EditorInfo.IME_ACTION_DONE);
            btnret.setBackground(getResources().getDrawable(R.drawable.button_verde_pressed_rectangle));
            btntra.setBackground((getResources().getDrawable(R.drawable.button_verde_trapez)));
            btncer.setBackground((getResources().getDrawable(R.drawable.button_verde_cerchio)));

            }
        });

        btntra.setOnClickListener(new Button.OnClickListener() {
            public void onClick (View v){ calculate_trapezio();
                // chiudere la tastiera virtuale

                  InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                  imm.hideSoftInputFromWindow(numlun.getWindowToken(), 0);
            }



            private void calculate_trapezio() {
                testo_nomearea.setText("Trapezio");
                numlar.setHint("Base Minore");
                numlun.setHint("Base Maggiore");
                numalt.setHint("Altezza");
                numlun.setText("");
                numlar.setText("");
                numalt.setText("");
                numlar.setEnabled(true);
                numlun.setEnabled(true);
                numalt.setEnabled(true);
                numlar.setImeOptions(EditorInfo.IME_ACTION_NEXT);
                numlun.setImeOptions(EditorInfo.IME_ACTION_NEXT);
                numalt.setImeOptions(EditorInfo.IME_ACTION_DONE);
                numlun.setVisibility(View.VISIBLE);
                numalt.setVisibility(View.VISIBLE);
                btnret.setBackground((getResources().getDrawable(R.drawable.button_verde_rectangle)));
                btntra.setBackground((getResources().getDrawable(R.drawable.button_verde_pressed_traspez)));
                btncer.setBackground((getResources().getDrawable(R.drawable.button_verde_cerchio)));

            }
        });

        btncer.setOnClickListener(new Button.OnClickListener() {
            public void onClick (View v){ calculate_cerchio();
                // chiudere la tastiera virtuale

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(numlun.getWindowToken(), 0);
            }



            private void calculate_cerchio() {
                testo_nomearea.setText("Cerchio");
                numlar.setHint("Raggio");
                numlun.setHint("");
                numalt.setHint("");
                numlun.setText("");
                numlar.setText("");
                numalt.setText("");
                numlun.setVisibility(View.INVISIBLE);
                numalt.setVisibility(View.INVISIBLE);
                numlar.setEnabled(true);
                numlun.setEnabled(false);
                numalt.setEnabled(false);
                numlar.setImeOptions(EditorInfo.IME_ACTION_DONE);


                btnret.setBackground((getResources().getDrawable(R.drawable.button_verde_rectangle)));
                btntra.setBackground((getResources().getDrawable(R.drawable.button_verde_trapez)));
                btncer.setBackground((getResources().getDrawable(R.drawable.button_verde_pressed_cerchio)));


            }
        });
      // calcola

        buttoncal.setOnClickListener(new Button.OnClickListener() {
            public void onClick (View v){ calculate();
                // chiudere la tastiera virtuale

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(numlun.getWindowToken(), 0);
            }


            private void calculate() {

                String numberzero = numlar.getText().toString();
                String numberzero2 = numlun.getText().toString();
                 String numberzero3 = numalt.getText().toString();
                String codice_area = testo_nomearea.getText().toString();

           if(codice_area.equals("Trapezio")) {

                 // *******************     Trapezio
                if (numberzero.equals("")) {

                    Toast.makeText(getActivity().getApplicationContext(), R.string.toast_lar, Toast.LENGTH_LONG).show();
                }

                else if (numberzero2.equals("")){

                    Toast.makeText(getActivity().getApplicationContext(), R.string.toast_lun, Toast.LENGTH_LONG).show();
                }
                else if (numberzero3.equals("")){
                     //   rifare il toast
                    Toast.makeText(getActivity().getApplicationContext(), R.string.toast_alt, Toast.LENGTH_LONG).show();
                }


                else {
                    num1= Float.parseFloat(numlar.getText().toString());
                    num2= Float.parseFloat(numlun.getText().toString());
                    num3= Float.parseFloat(numalt.getText().toString());
                    tot1=((num1+num2)/2*num3);
                    tot2=(tot2+tot1);
                    con1=(con1+1);

                    String troncato = String.format("%.2f", tot1);//valoretotale è il risultato delle mie operazioni
                    textviewparziale.setText(""+troncato);// e funzione, ho notato anche che arrotonda

                    String troncato2 = String.format("%.0f", tot2);//valoretotale è il risultato delle mie operazioni
                    textviewtotale.setText(""+troncato2);// e funzione, ho notato anche che arrotonda

                    Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    mVibrator.vibrate(200);
                    buttonagg.setEnabled(true);
                    buttoncal.setEnabled(false);
                    buttonagg.setVisibility(View.VISIBLE);
                    buttoncal.setVisibility(View.INVISIBLE);
                   // buttoncal.setEnabled(false);

                    textviewconta.setText("Sez."+con1+" ");


                } }
                // Cerchio **********************************************
          else if (codice_area.equals("Cerchio")) {


                if (numberzero.equals("")) {

                    Toast.makeText(getActivity().getApplicationContext(), R.string.toast_raggio, Toast.LENGTH_LONG).show();
                }


                else {
                    num1= Float.parseFloat(numlar.getText().toString());

                    num_raggio= (3.14f);
                    tot1=(num1*num1*num_raggio);
                    tot2=(tot2+tot1);
                    con1=(con1+1);

                    String troncato = String.format("%.2f", tot1);//valoretotale è il risultato delle mie operazioni
                    textviewparziale.setText(""+troncato);// e funzione, ho notato anche che arrotonda

                    String troncato2 = String.format("%.0f", tot2);//valoretotale è il risultato delle mie operazioni
                    textviewtotale.setText(""+troncato2);// e funzione, ho notato anche che arrotonda

                    Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    mVibrator.vibrate(200);
                    buttonagg.setEnabled(true);
                    buttoncal.setEnabled(false);
                    buttonagg.setVisibility(View.VISIBLE);
                    buttoncal.setVisibility(View.INVISIBLE);
                    // buttoncal.setEnabled(false);

                    textviewconta.setText("Sez."+con1+" ");


                } }

                  // Se no riponde prima applica la Formula x il Rettangolo
           else {


               if (numberzero.equals("")) {

                   Toast.makeText(getActivity().getApplicationContext(), R.string.toast_lar, Toast.LENGTH_LONG).show();
               }

               else if (numberzero2.equals("")){

                   Toast.makeText(getActivity().getApplicationContext(), R.string.toast_lun, Toast.LENGTH_LONG).show();
               }


               else {
                   num1= Float.parseFloat(numlar.getText().toString());
                   num2= Float.parseFloat(numlun.getText().toString());
                   tot1=(num1*num2);
                   tot2=(tot2+tot1);
                   con1=(con1+1);

                   String troncato = String.format("%.2f", tot1);//valoretotale è il risultato delle mie operazioni
                   textviewparziale.setText(""+troncato);// e funzione, ho notato anche che arrotonda

                   String troncato2 = String.format("%.0f", tot2);//valoretotale è il risultato delle mie operazioni
                   textviewtotale.setText(""+troncato2);// e funzione, ho notato anche che arrotonda

                   Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                   mVibrator.vibrate(200);
                   buttonagg.setEnabled(true);
                   buttoncal.setEnabled(false);
                   buttonagg.setVisibility(View.VISIBLE);
                   buttoncal.setVisibility(View.INVISIBLE);
                   // buttoncal.setEnabled(false);

                   textviewconta.setText("Sez."+con1+" ");


               } }



            }
        });


        //// da sistemare

        //Intent Passadati = new Intent(this, Pagina4.class);
        //String pkg = getPackageName();

        //Passo i dati all'Intent figlio tramite la funzione putExtra
        //Passadati.putExtra("Test1",textviewtotale.getText().toString());


        // quando si clicca su aggiungi
        buttonagg.setOnClickListener(new Button.OnClickListener() {
            public void onClick (View v){ calculate2();
                // chiudere la tastiera virtuale

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(numlun.getWindowToken(), 0);
            }



            private void calculate2() {
                String codice_area = testo_nomearea.getText().toString();

                numlun.setText("");
                numlar.setText("");
                numalt.setText("");
                // num1=Float.parseFloat(numlar.getText().toString());
                // num2=Float.parseFloat(numlun.getText().toString());
                tot12=(tot1);

                String troncato12 = String.format("%.2f", tot12);//valoretotale è il risultato delle mie operazioni
              //  textviewparziale2.setText(num1+" * "+num2+" = "+""+troncato12);// e funzione, ho notato anche che arrotonda
                textviewparziale2.setText(codice_area+" = "+""+troncato12+" Sez. "+con1);// e funzione, ho notato anche che arrotonda



                Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                mVibrator.vibrate(200);

                textviewparziale.setText("0");
                buttonagg.setEnabled(false);
                buttoncal.setEnabled(true);
                buttonagg.setVisibility(View.INVISIBLE);
                buttoncal.setVisibility(View.VISIBLE);


            }
        });



        // quando si clicca su azzera
        buttonazz.setOnClickListener(new Button.OnClickListener() {
            public void onClick (View v){ calculate3();
                // chiudere la tastiera virtuale

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(numlun.getWindowToken(), 0);
            }



            private void calculate3() {

                //num1=Float.parseFloat(numlar.getText().toString());
                //num2=Float.parseFloat(numlun.getText().toString());

                num1=(0);
                num2=(0);
                tot1=(0);
                tot2=(0);
                numlun.setText("");
                numlar.setText("");
                numalt.setText("");
                con1=(0);
                textviewparziale.setText("0");
                textviewtotale.setText("0");
                textviewparziale2.setText("0");
                textviewconta.setText("0");
                Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                mVibrator.vibrate(200);
                buttonagg.setEnabled(false);
                buttoncal.setEnabled(true);
                buttonagg.setVisibility(View.INVISIBLE);
                buttoncal.setVisibility(View.VISIBLE);
            }
        });

        return rootView;
    }
}

