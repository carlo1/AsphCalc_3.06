package com.asphcalc.myapplication.model;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.asphcalc.myapplication.R;


public class ContactFragment extends Fragment {
    private ImageButton btnmail;
    private EditText provatesto;

    public ContactFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_contattaci, container, false);





        btnmail = (ImageButton)rootView.findViewById(R.id.Buttonmail);




            btnmail.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    inviare();

                }


                private void inviare() {


                    Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(200);//80 represents the milliseconds (the duration of the vibration)


                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{"ufficiotecnico@allaraspa.it", "agest.carlo@gmail.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, "AsphCalc Richiesta di Contatto");
                    i.putExtra(Intent.EXTRA_TEXT, "Scrivi Mail");
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {

                        //Activity activity = getActivity();
                        //Toast.makeText(activity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        // Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity().getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();


                    }
                }


            });



            return rootView;

    }



}



