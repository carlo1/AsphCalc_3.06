package com.asphcalc.myapplication.model;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import com.asphcalc.myapplication.R;

public class PreferencesFromXml_trasporto extends PreferenceActivity {
   //public static final String Write = "nome_tappetino";

   public static final String TITOLO_PREF_25 = "nome_25";
    public static final String TITOLO_PREF_31= "nome_31";
    public static final String TITOLO_PREF_40 = "nome_40";


    //public static final String USA_TITOLO_CUSTOM_PREF = "usa_titolo_custom";


    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_trasporto);
        // PRIMO CICLO TAPPETINO X FAR  RISULTARE NEL SETTING IL TEXT NOME MODIFICATO NEL SUMMARY
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Preference titoloPrefs = findPreference(TITOLO_PREF_25);

        titoloPrefs.setTitle(prefs.getString(TITOLO_PREF_25, getString(R.string.n_25)));

        titoloPrefs.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()


        {

            @Override


            public boolean onPreferenceChange(Preference prefs, Object value)
            {
                prefs.setTitle((CharSequence) value);
                return true;
            }
        });

        // 2 CICLO BINDER
        // SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(this);

        Preference titoloPrefs2 = findPreference(TITOLO_PREF_31);

        titoloPrefs2.setTitle(prefs.getString(TITOLO_PREF_31, getString(R.string.n_31)));

        titoloPrefs2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()


        {

            @Override


            public boolean onPreferenceChange(Preference prefs2, Object value)
            {
                prefs2.setTitle((CharSequence) value);
                return true;
            }
        });

        // 3 CICLO tout-venant
        //SharedPreferences prefs3 = PreferenceManager.getDefaultSharedPreferences(this);

        Preference titoloPrefs3 = findPreference(TITOLO_PREF_40);

        titoloPrefs3.setTitle(prefs.getString(TITOLO_PREF_40, getString(R.string.n_40)));

        titoloPrefs3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()


        {

            @Override


            public boolean onPreferenceChange(Preference prefs3, Object value)
            {
                prefs3.setTitle((CharSequence) value);
                return true;
            }
        });

    }
}
