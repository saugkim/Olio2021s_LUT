package org.lut.week11s;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingFragment extends PreferenceFragmentCompat {

    public static final String PREF_LIST_LAN = "pref_list_language";
    //public static final String PREF_EDITTEXT_DISPLAY = "pref_edittext_display";

    SharedPreferences sharedPreferences;
    SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setPreferencesFromResource(R.xml.preference_setting, rootKey);

        sharedPreferences = getPreferenceScreen().getSharedPreferences();

        onSharedPreferenceChangeListener = (sharedPreferences, s) -> {
            if (s.equals(PREF_LIST_LAN)) {
                Preference pref = findPreference(s);
                if (pref != null)
                    pref.setSummary(sharedPreferences.getString(s, ""));
            }
        };
    }

    @Override
    public void onResume() {
        super.onResume();
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);

        Preference pref = findPreference(PREF_LIST_LAN);
        if (pref != null)
            pref.setSummary(sharedPreferences.getString(PREF_LIST_LAN, "_"));
    }

    @Override
    public void onPause() {
        super.onPause();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

}
