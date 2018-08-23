package com.asphcalc.myapplication.model;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import com.asphcalc.myapplication.R;

public class PreferencesFromXml_unita extends PreferenceActivity {
   //public static final String Write = "nome_tappetino";
   public static final String TITOLO_PREF_UNITA = "nome_unitamisura";


   //public static final String USA_TITOLO_CUSTOM_PREF = "usa_titolo_custom";


    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_unita);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Preference titoloPrefs = findPreference(TITOLO_PREF_UNITA);

        titoloPrefs.setTitle(prefs.getString(TITOLO_PREF_UNITA, getString(R.string.peso)));

        titoloPrefs.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()


        {

            @Override


            public boolean onPreferenceChange(Preference prefs, Object value) {
                prefs.setTitle((CharSequence) value);
                return true;



            }



            });
    }
}
