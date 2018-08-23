package com.asphcalc.myapplication.model;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import com.asphcalc.myapplication.R;

public class PreferencesFromXml extends PreferenceActivity {
   //public static final String Write = "nome_tappetino";

   public static final String TITOLO_PREF = "nome_tappetino";
    public static final String TITOLO_PREF2 = "nome_binder";
    public static final String TITOLO_PREF3 = "nome_toutvenant";
    public static final String TITOLO_PREF4 = "nome_tappetinomodificato";
    public static final String TITOLO_PREF5 = "nome_ps21";
    public static final String TITOLO_PREF6 = "nome_ps22";
    public static final String TITOLO_PREF7 = "nome_ps23";
    public static final String TITOLO_PREF8 = "nome_ps235";
    public static final String TITOLO_PREFspe1 = "nome_spe1";
    public static final String TITOLO_PREFspe2 = "nome_spe2";
    public static final String TITOLO_PREFspe3 = "nome_spe3";
    public static final String TITOLO_PREFspe4 = "nome_spe4";

   //public static final String USA_TITOLO_CUSTOM_PREF = "usa_titolo_custom";


    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);
 // PRIMO CICLO TAPPETINO X FAR  RISULTARE NEL SETTING IL TEXT NOME MODIFICATO NEL SUMMARY
  SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

  Preference titoloPrefs = findPreference(TITOLO_PREF);

 titoloPrefs.setTitle(prefs.getString(TITOLO_PREF, getString(R.string.Tappetino)));

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

        Preference titoloPrefs2 = findPreference(TITOLO_PREF2);

        titoloPrefs2.setTitle(prefs.getString(TITOLO_PREF2, getString(R.string.binder)));

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

        Preference titoloPrefs3 = findPreference(TITOLO_PREF3);

        titoloPrefs3.setTitle(prefs.getString(TITOLO_PREF3, getString(R.string.toutvenant)));

        titoloPrefs3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()


        {

            @Override


            public boolean onPreferenceChange(Preference prefs3, Object value)
            {
                prefs3.setTitle((CharSequence) value);
                return true;
            }
        });
        // 4 CICLO modificato
        //SharedPreferences prefs3 = PreferenceManager.getDefaultSharedPreferences(this);

        Preference titoloPrefs4 = findPreference(TITOLO_PREF4);

        titoloPrefs4.setTitle(prefs.getString(TITOLO_PREF4, getString(R.string.tappetinomodif)));

        titoloPrefs4.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()


        {

            @Override


            public boolean onPreferenceChange(Preference prefs4, Object value)
            {
                prefs4.setTitle((CharSequence) value);
                return true;
            }
        });
        // 5 CICLO peso specifico
      Preference titoloPrefs5 = findPreference(TITOLO_PREF5);
 titoloPrefs5.setTitle(prefs.getString(TITOLO_PREF5, getString(R.string.peso2_1)));
 titoloPrefs5.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
    {
        @Override
            public boolean onPreferenceChange(Preference prefs5, Object value)
            {
                prefs5.setTitle((CharSequence) value);
                return true;
            }
        });
 // 6 CICLO peso specifico
        Preference titoloPrefs6 = findPreference(TITOLO_PREF6);
        titoloPrefs6.setTitle(prefs.getString(TITOLO_PREF6, getString(R.string.peso2_2)));
        titoloPrefs6.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
        {
            @Override
            public boolean onPreferenceChange(Preference prefs6, Object value)
            {
                prefs6.setTitle((CharSequence) value);
                return true;
            }
        });
         // 7 CICLO peso specifico
        Preference titoloPrefs7 = findPreference(TITOLO_PREF7);
        titoloPrefs7.setTitle(prefs.getString(TITOLO_PREF7, getString(R.string.peso2_3)));
        titoloPrefs7.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
        {
            @Override
            public boolean onPreferenceChange(Preference prefs7, Object value)
            {
                prefs7.setTitle((CharSequence) value);
                return true;
            }
        });
        // 8 CICLO peso specifico
        Preference titoloPrefs8 = findPreference(TITOLO_PREF8);
        titoloPrefs8.setTitle(prefs.getString(TITOLO_PREF8, getString(R.string.peso2_35)));
        titoloPrefs8.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
        {
            @Override
            public boolean onPreferenceChange(Preference prefs8, Object value)
            {
                prefs8.setTitle((CharSequence) value);
                return true;
            }
        });
        // 9 CICLO spessore 1
        Preference titoloPrefs9 = findPreference(TITOLO_PREFspe1);
        titoloPrefs9.setTitle(prefs.getString(TITOLO_PREFspe1, getString(R.string.spessorepartenza)));
        titoloPrefs9.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
        {
            @Override
            public boolean onPreferenceChange(Preference prefs9, Object value)
            {
                prefs9.setTitle((CharSequence) value);
                return true;
            }
        });
        // 12 CICLO spessore 4
        Preference titoloPrefs12 = findPreference(TITOLO_PREFspe4);
        titoloPrefs12.setTitle(prefs.getString(TITOLO_PREFspe4, getString(R.string.spessorepartenza_modif)));
        titoloPrefs12.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
        {
            @Override
            public boolean onPreferenceChange(Preference prefs12, Object value)
            {
                prefs12.setTitle((CharSequence) value);
                return true;
            }
        });
         // 10 CICLO spessore 2
        Preference titoloPrefs10 = findPreference(TITOLO_PREFspe2);
        titoloPrefs10.setTitle(prefs.getString(TITOLO_PREFspe2, getString(R.string.spessorepartenza_binder)));
        titoloPrefs10.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
        {
            @Override
            public boolean onPreferenceChange(Preference prefs10, Object value)
            {
                prefs10.setTitle((CharSequence) value);
                return true;
            }
        });
        // 11 CICLO spessore 3
        Preference titoloPrefs11 = findPreference(TITOLO_PREFspe3);
        titoloPrefs11.setTitle(prefs.getString(TITOLO_PREFspe3, getString(R.string.spessorepartenza_tout)));
        titoloPrefs11.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
        {
            @Override
            public boolean onPreferenceChange(Preference prefs11, Object value)
            {
                prefs11.setTitle((CharSequence) value);
                return true;
            }
        });

    }
}
