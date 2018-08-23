package com.asphcalc.myapplication.model;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.asphcalc.myapplication.R;

import java.util.Random;

public class CalMaterFragment extends Fragment {

    private EditText number1;
    private EditText number2;
    private EditText number3;
    private TextView risultato;
    private Button clickme;
    private Button btninv;
    private ImageButton condividi2;
    private ImageView condividi;
    private ImageView notifica;

    // variabili x v3.0
    private ImageView apri;
    private ImageView chiudi;
    private GridLayout scheda2;

    private Spinner spinner;
    private TextView testomat;
    private TextView testoscheda;
    private EditText number4;
    // variabili per i calcoli
    private int num1 = 0;
    private float num2 = 0;
    private float num3 = 0;
    private float tot=0;
    private float num4=0;
    private String pesosp;
    private TextView textView7;
    private String tappetinonuovo="Tappetino";
    private String bindernuovo="Binder";
    private String toutvenantnuovo="Tout-Venant";
    private String tappetinomodificatonuovo="Tappetino Mod.";
    private String vero1;

    public CalMaterFragment(){}
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

    // A integer, that identifies each notification uniquely
    public static final int NOTIFICATION_ID = 1;



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_calmateriale, container, false);

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





        // v. 2.xx
        textview8 = (TextView)rootView.findViewById(R.id.textView8);

        textum = (TextView)rootView.findViewById(R.id.textum);
        number1 = (EditText)rootView.findViewById(R.id.number1);
        number2 = (EditText)rootView.findViewById(R.id.number2);
        number3 = (EditText)rootView.findViewById(R.id.number3);

        risultato = (TextView)rootView.findViewById(R.id.risultato);
        clickme = (Button)rootView.findViewById(R.id.clickme);
        testomat = (TextView)rootView.findViewById(R.id.testomat);
        testoscheda = (TextView)rootView.findViewById(R.id.testoscheda);
        textView7 = (TextView)rootView.findViewById(R.id.textView7);
        condividi = (ImageView)rootView.findViewById(R.id.condividi2);
        notifica = (ImageView)rootView.findViewById(R.id.notifica);

        // ver 3.0
        apri = (ImageView)rootView.findViewById(R.id.apri);
        chiudi = (ImageView)rootView.findViewById(R.id.chiudi);
        scheda2 = (GridLayout)rootView.findViewById(R.id.scheda2);

       // funzione + inerire il tasto fine nella calcolatrice
        number1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        number2.setImeOptions(EditorInfo.IME_ACTION_DONE);
        number3.setImeOptions(EditorInfo.IME_ACTION_DONE);



        // pulsante in attesa e pronto a lanciare la funzione calculate()


        textview8.setText(unitamisuranew+" x MC.");
        textum.setText(unitamisuranew);
        //PROVA SPINNER
        final Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);


        String materiali3[] = {tappetinonuovo,bindernuovo,toutvenantnuovo,tappetinomodificatonuovo};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,materiali3);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);





        //e il listener che verra' eseguito quando l'utente seleziona un elemento

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapter, View view, int pos, long id) {
                final String selected = (String) adapter.getItemAtPosition(pos);
                //Toast.makeText(
                //      getApplicationContext(),
                //   "hai selezionato "+selected ,
                // Toast.LENGTH_LONG
                // ).show();

                testomat.setText((selected));

                //CAMBIO PESO SPECIFICO

                if (selected.equals(tappetinonuovo)) {
                    number3.setText((pesospecif23new));
                    number2.setText((spessore1new));
                    //risultato.setText(R.string.ricalcola);
                    testomat.setText(tappetinonuovo);
                    testoscheda.setText(tappetinonuovo);
                    //number1.setText("");
                }
                //  codice x recuperare il valore uguale alla stringa
                // else if (selected.equals(getResources().getString(R.string.binder))){
                else if (selected.equals(bindernuovo)) {
                    number3.setText((pesospecif22new));
                    number2.setText((spessore2new));
                    //risultato.setText(R.string.ricalcola);
                    testomat.setText(bindernuovo);
                    testoscheda.setText(bindernuovo);
                    // number1.setText("");

                } else if (selected.equals(toutvenantnuovo)) {
                    number3.setText((pesospecif21new));
                    number2.setText((spessore3new));
                    //risultato.setText(R.string.ricalcola);
                    testomat.setText(toutvenantnuovo);
                    testoscheda.setText(toutvenantnuovo);
                    //number1.setText("");


                } else if (selected.equals(tappetinomodificatonuovo)) {
                    number3.setText((pesospecif235new));
                    number2.setText((spessore4new));
                    // risultato.setText(R.string.ricalcola);
                    testomat.setText(tappetinomodificatonuovo);
                    testoscheda.setText(tappetinomodificatonuovo);
                    // number1.setText("");

                } else {
                    number3.setText(("2"));
                }

                //nome = "Tappetino";int c = ...;


            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });






        // PREMI IL PULSANTE ROSSO E INVIA IL TOAST
        clickme.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculate();
                // chiudere la tastiera virtuale
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(number1.getWindowToken(), 0);
            }


            // funzione calculate che somma num1+num2 presi dalle
            // EditText chiamate number1 e number2
            // e riporta il risultato, tot, nella TextView total
            private void calculate() {
                // ver 2.xx funzionante x calcoloare con bottone rosso
                //String numberzero = number1.getText().toString();

                //if (numberzero.equals("")) {
                //    risultato.setText("Ricalcola");
                //   Toast.makeText(getActivity().getApplicationContext(), R.string.toastarea, Toast.LENGTH_SHORT).show();
                //} else {
                //   num1 = Integer.parseInt(number1.getText().toString());
                //   num2 = Float.parseFloat(number2.getText().toString());
                //   num3 = Float.parseFloat(number3.getText().toString());


                // tot = (num1 * num2 * num3 / 100);
                //****  STRINGA VECCHIA X VISUALIZZARE TUTTI I DECIMALI
                //risultato.setText(Float.toString(tot));


                // testo nuovo x arrotondare e visualizzare solo 2 decimali
                // String troncato = String.format("%.0f", tot);//valoretotale è il risultato delle mie operazioni
                // risultato.setText("" + troncato);// e funzione, ho notato anche che arrotonda
                String numerovalorevero = clickme.getText().toString();
                if (numerovalorevero.equals("")) {

                    clickme.setText(".");
                    notifica.setVisibility(View.VISIBLE);
                    Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    mVibrator.vibrate(50);
                    Toast.makeText(getActivity().getApplicationContext(), R.string.toastcondividi, Toast.LENGTH_SHORT).show();
                    clickme.setBackgroundResource(R.drawable.bottone_rosso_piumeno);


                    //prova di timer (ma non interrompe il ciclo)
                    // SystemClock.sleep(300);
                    condividi.setVisibility(View.VISIBLE);

                } else {

                    clickme.setText("");

                    //Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    //mVibrator.vibrate(200);
                    //Toast.makeText(getActivity().getApplicationContext(), R.string.toastcondividi, Toast.LENGTH_SHORT).show();
                    condividi.setVisibility(View.INVISIBLE);
                    notifica.setVisibility(View.INVISIBLE);
                    clickme.setBackgroundResource(R.drawable.bottone_rosso_piu);

                }
                ;


            }


        });
// ver 3.0 scheda apri chiudi
        apri.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                aprire();
            }

            private void aprire() {
                apri.setVisibility(View.INVISIBLE);
                chiudi.setVisibility(View.VISIBLE);
                scheda2.setVisibility(View.VISIBLE);
                }
                                    });


        chiudi.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                chiudere();
            }

            private void chiudere() {
                apri.setVisibility(View.VISIBLE);
                chiudi.setVisibility(View.INVISIBLE);
                scheda2.setVisibility(View.INVISIBLE);
            }
        });

// **************************notifica bottone************************
        notifica.setOnClickListener(new Button.OnClickListener() {

                    public void onClick(View v) {
                        notificare();

                    }



            private void notificare() {
                Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                mVibrator.vibrate(200);
// Use NotificationCompat.Builder to set up our notification.
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());

//icon appears in device notification bar and right hand corner of notification
                builder.setSmallIcon(R.drawable.work_ab);

// This intent is fired when notification is clicked
                //i **************** richiama una pagina internet
                //i Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/"));
                //i PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);

                //********** //o codice che al clik esce dalla notifica //a aggiung bottone **************
                Intent intent1 = new Intent(getActivity(), CalMaterFragment.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                PendingIntent pending1 = PendingIntent.getActivity(getActivity(), 0, intent1, 0);
                builder.setContentIntent(pending1);
                //a    .addAction(R.drawable.ic_launcher, "Lancia", pending1)
                builder.build();
// Set the intent that will fire when the user taps the notification.
                //i builder.setContentIntent(pendingIntent);
                //  ********* codice da internet ****************


                // notification.setLatestEventInfo(context, title, message, intent);
                // notification.flags |= Notification.FLAG_AUTO_CANCEL;

// Large icon appears on the left of the notification
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.work_b));

// Content title, which appears in large type at the top of the notification
                builder.setContentTitle("AsphCalc Pro");

// Content text, which appears in smaller text below the title
                builder.setContentText(getResources().getString(R.string.area) + " " + num1 + " - " + getResources().getString(R.string.spessore) + " " + num2);
                builder.setContentText(testomat.getText() + " " + getResources().getString(R.string.spessore) + " " + num2);

// The subtext, which appears under the text on newer devices.
// This will show-up in the devices with Android 4.2 and above only
                builder.setSubText(getResources().getString(R.string.area) + " " + num1 + "  -  " + unitamisuranew + " " + risultato.getText());

                NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

// Will display the notification in the notification bar
                Random random = new Random();
                int m = random.nextInt(9999 - 1000) + 1000;

                // notificationManager.notify(Unique_Integer_Number, builder.build());
                notificationManager.notify(m, builder.build());
                notifica.setVisibility(View.INVISIBLE);
                condividi.setVisibility(View.INVISIBLE);
                clickme.setBackgroundResource(R.drawable.bottone_rosso_piu);
                clickme.setText("");

            }

        });





// **************************edittext evento senza bottone number 1************************
       number1.addTextChangedListener(new TextWatcher() {
                                          @Override
                                          public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                          }

                                          @Override
                                          public void onTextChanged(CharSequence s, int start, int before, int count) {

                                          }

                                          @Override
                                          public void afterTextChanged(Editable s) {
                                              String numberzero = number1.getText().toString();
                                              String numberzero2 = number2.getText().toString();
                                              String numberzero3 = number3.getText().toString();

                                              if (numberzero.equals("")) {
                                                  risultato.setText("Ricalcola");
                                                  Toast.makeText(getActivity().getApplicationContext(), R.string.toastarea, Toast.LENGTH_SHORT).show();
                                              } else if (numberzero2.equals("")) {
                                                  risultato.setText("Ricalcola");
                                                  Toast.makeText(getActivity().getApplicationContext(), R.string.toastarea, Toast.LENGTH_SHORT).show();
                                              } else if (numberzero3.equals("")) {
                                                  risultato.setText("Ricalcola");
                                                  Toast.makeText(getActivity().getApplicationContext(), R.string.toastarea, Toast.LENGTH_SHORT).show();

                                              } else {


                                                  num1 = Integer.parseInt(number1.getText().toString());
                                                  num2 = Float.parseFloat(number2.getText().toString());
                                                  num3 = Float.parseFloat(number3.getText().toString());


                                                  tot = (num1 * num2 * num3 / 100);
                                                  //****  STRINGA VECCHIA X VISUALIZZARE TUTTI I DECIMALI
                                                  //risultato.setText(Float.toString(tot));


                                                  //testo nuovo x arrotondare e visualizzare solo 2 decimali
                                                  String troncato = String.format("%.0f", tot);//valoretotale è il risultato delle mie operazioni
                                                  risultato.setText("" + troncato);// e funzione, ho notato anche che arrotonda

                                                  Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

                                                  mVibrator.vibrate(50);

                                              }

                                          }
                                      }

       );




// **************************edittext evento senza bottone number 2************************
        number2.addTextChangedListener(new TextWatcher() {
                                           @Override
                                           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                           }

                                           @Override
                                           public void onTextChanged(CharSequence s, int start, int before, int count) {

                                           }

                                           @Override
                                           public void afterTextChanged(Editable s) {
                                               String numberzero = number1.getText().toString();
                                               String numberzero2 = number2.getText().toString();
                                               String numberzero3 = number3.getText().toString();

                                               if (numberzero.equals("")) {
                                                   risultato.setText("Ricalcola");
                                                   Toast.makeText(getActivity().getApplicationContext(), R.string.toastarea, Toast.LENGTH_SHORT).show();
                                               } else if (numberzero2.equals("")) {
                                                   risultato.setText("Ricalcola");
                                                   Toast.makeText(getActivity().getApplicationContext(), R.string.toastarea, Toast.LENGTH_SHORT).show();
                                               } else if (numberzero3.equals("")) {
                                                   risultato.setText("Ricalcola");
                                                   Toast.makeText(getActivity().getApplicationContext(), R.string.toastarea, Toast.LENGTH_SHORT).show();

                                               } else {


                                                   num1 = Integer.parseInt(number1.getText().toString());
                                                   num2 = Float.parseFloat(number2.getText().toString());
                                                   num3 = Float.parseFloat(number3.getText().toString());


                                                   tot = (num1 * num2 * num3 / 100);
                                                   //****  STRINGA VECCHIA X VISUALIZZARE TUTTI I DECIMALI
                                                   //risultato.setText(Float.toString(tot));


                                                   //testo nuovo x arrotondare e visualizzare solo 2 decimali
                                                   String troncato = String.format("%.0f", tot);//valoretotale è il risultato delle mie operazioni
                                                   risultato.setText("" + troncato);// e funzione, ho notato anche che arrotonda

                                                   Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

                                                   mVibrator.vibrate(50);

                                               }

                                           }
                                       }

        );

// **************************edittext evento senza bottone number 3************************
            number3.addTextChangedListener(new

                                                   TextWatcher() {
                                                       @Override
                                                       public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                                       }

                                                       @Override
                                                       public void onTextChanged(CharSequence s, int start, int before, int count) {

                                                       }

                                                       @Override
                                                       public void afterTextChanged(Editable s) {
                                                           String numberzero = number1.getText().toString();
                                                           String numberzero2 = number2.getText().toString();
                                                           String numberzero3 = number3.getText().toString();

                                                           if (numberzero.equals("")) {
                                                               risultato.setText("Ricalcola");
                                                               Toast.makeText(getActivity().getApplicationContext(), R.string.toastarea, Toast.LENGTH_SHORT).show();
                                                           } else if (numberzero2.equals("")) {
                                                               risultato.setText("Ricalcola");
                                                               Toast.makeText(getActivity().getApplicationContext(), R.string.toastarea, Toast.LENGTH_SHORT).show();
                                                           } else if (numberzero3.equals("")) {
                                                               risultato.setText("Ricalcola");
                                                               Toast.makeText(getActivity().getApplicationContext(), R.string.toastarea, Toast.LENGTH_SHORT).show();

                                                           } else {


                                                               num1 = Integer.parseInt(number1.getText().toString());
                                                               num2 = Float.parseFloat(number2.getText().toString());
                                                               num3 = Float.parseFloat(number3.getText().toString());


                                                               tot = (num1 * num2 * num3 / 100);
                                                               //****  STRINGA VECCHIA X VISUALIZZARE TUTTI I DECIMALI
                                                               //risultato.setText(Float.toString(tot));


                                                               //testo nuovo x arrotondare e visualizzare solo 2 decimali
                                                               String troncato = String.format("%.0f", tot);//valoretotale è il risultato delle mie operazioni
                                                               risultato.setText("" + troncato);// e funzione, ho notato anche che arrotonda

                                                               Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

                                                               mVibrator.vibrate(50);

                                                           }

                                                       }
                                                   }

            );

// **************************condividi bottone************************
            condividi.setOnClickListener(new Button.OnClickListener()

            {
                public void onClick(View v) {
                    condividere();

                }

                ;


                private void condividere() {
                    // spinner = (Spinner) findViewById(R.id.spinner);
                    //String item = parent.getItemAtPosition(position).toString();
                    //Toast.makeText(parent.getContext(), item, Toast.LENGTH_LONG).show();

                    Vibrator mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

// Vibrate for 300 milliseconds


                    mVibrator.vibrate(200);
                    final Intent Intent = new android.content.Intent();
                    Intent.setType("text/plain");
                    Intent.setAction(Intent.ACTION_SEND);

                    //Intent . putExtra(Intent.EXTRA_TEXT," Servono " + ""+ testomat.getText() +"tonnelate "+ risultato.getText ());
                    Intent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.toastservono) + " " + risultato.getText() + " " + unitamisuranew + " " + getResources().getString(R.string.toasttonnellate_di) + " " + testomat.getText());
                    startActivity(Intent.createChooser(Intent, getString(R.string.share_message)));
                    condividi.setVisibility(View.INVISIBLE);
                    notifica.setVisibility(View.INVISIBLE);
                    clickme.setBackgroundResource(R.drawable.bottone_rosso_piu);
                    clickme.setText("");



                }


            });





        // dialogo box personalizzato ver 3.0 def (non apre la tastiera)

        number1.setOnClickListener(new TextView.OnClickListener() {
                                        public void onClick(View v) {
                                            dialogo();
                                        }

                                        private void dialogo() {

                                            LayoutInflater li = LayoutInflater.from(getActivity());
                                            View promptsView = li.inflate(R.layout.fragment_value, null);
                                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

                                            //xml
                                            alertDialogBuilder.setView(promptsView);
                                            final EditText userinput = (EditText) promptsView
                                                    .findViewById(R.id.editTextDialogUserInput);
                                            // ****************** prova a riportare il testo gia scritto ok funziona
                                            //userinput.setFocusable(true);


                                            userinput.setText(number1.getText());

                                            //userinput.setFocusableInTouchMode(true);
                                            // con i due parametri accesi il cursore si trova alla fine del testo ma la tastiera e' chiusa
                                            // con 1 solo (selectALl si seleziona il testo ma non si apre la tastiera
                                            //userinput.requestFocus();
                                            userinput.setSelectAllOnFocus(true);
                                            userinput.setActivated(true);

                                            alertDialogBuilder.setCancelable(false);


                                            alertDialogBuilder.setPositiveButton("Calc", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    number1.setText(userinput.getText());
                                                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                                    imm.hideSoftInputFromWindow(userinput.getWindowToken(), 0);
                                                }
                                            });
                                            alertDialogBuilder.setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                                    imm.hideSoftInputFromWindow(userinput.getWindowToken(), 0);

                                                    dialog.cancel();


                                                }

                                            });

                                            // crea dialogo
                                            AlertDialog alertDialog = alertDialogBuilder.create();
                                            alertDialog.show();

                                        }

                                    }
        );



        // 2 dialog box

        number2.setOnClickListener(new EditText.OnClickListener() {
            public void onClick(View v) {
                dialogo();}
            private void dialogo()  {
                LayoutInflater li = LayoutInflater.from(getActivity());
                View promptsView = li.inflate(R.layout.fragment_value_n2, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

                //xml
                alertDialogBuilder.setView(promptsView);
                final EditText userinput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);
                // prova a riportare il testo gia scritto
                userinput.setText(number2.getText());
                // seleziona il testo subito ma non apre la tastiera
                userinput.setSelectAllOnFocus(true);
                userinput.setActivated(true);
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Calc", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        number2.setText(userinput.getText());
                    }


                });
                alertDialogBuilder.setNegativeButton("Annulla",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }

                });

                // create dialogo
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


            }
        });

        number3.setOnClickListener(new EditText.OnClickListener() {
            public void onClick(View v) {
                dialogo();}
            private void dialogo()  {
                LayoutInflater li = LayoutInflater.from(getActivity());
                View promptsView = li.inflate(R.layout.fragment_value_n2, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

                //xml
                alertDialogBuilder.setView(promptsView);
                final EditText userinput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);
                // prova a riportare il testo gia scritto
                userinput.setText(number3.getText());
                userinput.setSelectAllOnFocus(true);
                userinput.setActivated(true);


                // set dialog
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Calc", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        number3.setText(userinput.getText());
                        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(userinput.getWindowToken(), 0);
                    }


                });
                alertDialogBuilder.setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();

                    }

                });

                // create dialogo
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();



            }
        });

        return rootView;
    }



}
