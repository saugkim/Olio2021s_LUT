package org.lut.week11;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreferenceCompat;

import java.util.prefs.Preferences;

public class EditableSettingFragment extends PreferenceFragmentCompat {

    public static final String PREF_LIST_COLOR = "pref_list_color";
    public static final String PREF_EDITTEXT_SIZE = "pref_edittext_size";
    public static final String PREF_EDITTEXT_WIDTH = "pref_edittext_width";
    public static final String PREF_EDITTEXT_HEIGHT = "pref_edittext_height";

    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;

    SharedPreferences sharedPreferences;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.edit_text_options, rootKey);

        sharedPreferences = getPreferenceScreen().getSharedPreferences();


        preferenceChangeListener = (sharedPreferences, s) -> {

            if (s.equals(PREF_LIST_COLOR)) {
                Preference pref1 = findPreference(s);
                pref1.setSummary(sharedPreferences.getString(s, ""));
            }

            if (s.equals(PREF_EDITTEXT_SIZE)) {
                Preference pref = findPreference(s);
                pref.setSummary("Text size: " + sharedPreferences.getString(s, ""));
            }
            if (s.equals(PREF_EDITTEXT_WIDTH)) {
                Preference pref = findPreference(s);
                pref.setSummary("Field Width: " + sharedPreferences.getString(s, ""));
            }
            if (s.equals(PREF_EDITTEXT_HEIGHT)) {
                Preference pref = findPreference(s);
                pref.setSummary("Field Height: " + sharedPreferences.getString(s, ""));
            }
        };
    }

    @Override
    public void onResume() {
        super.onResume();
        sharedPreferences.registerOnSharedPreferenceChangeListener(preferenceChangeListener);

        loadValue(sharedPreferences);
    }

    public void loadValue(SharedPreferences sharedPreferences) {
        Preference pref_color = findPreference(PREF_LIST_COLOR);
        pref_color.setSummary(sharedPreferences.getString(PREF_LIST_COLOR, ""));
        Preference pref_size = findPreference(PREF_EDITTEXT_SIZE);
        pref_size.setSummary(sharedPreferences.getString(PREF_EDITTEXT_SIZE, ""));
        Preference pref_width = findPreference(PREF_EDITTEXT_WIDTH);
        pref_width.setSummary(sharedPreferences.getString(PREF_EDITTEXT_WIDTH, ""));
        Preference pref_height = findPreference(PREF_EDITTEXT_HEIGHT);
        pref_height.setSummary(sharedPreferences.getString(PREF_EDITTEXT_HEIGHT, ""));
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(preferenceChangeListener);
    }

}

/*
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        Toast error = Toast.makeText(getContext(), "Please select a number.", Toast.LENGTH_SHORT);

        String sizeKey = getString(R.string.pref_size_key);
        if (preference.getKey().equals(sizeKey)) {
            String stringSize = (String) newValue;
            try {
                float size = Float.parseFloat(stringSize);

            } catch (NumberFormatException nfe) {
                error.show();
                return false;
            }
        }
        return true;
    }
    // The below method sets the Preference Summary as per selected.
    private void setPreferenceSummary(Preference preference, String value) {
        if (preference instanceof ListPreference) {
            // For list preferences, figure out the label of the selected value
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(value);
            if (prefIndex >= 0) {
                // Set the summary to that label
                listPreference.setSummary(listPreference.getEntries()[prefIndex]);
            }
        } else if (preference instanceof EditTextPreference) {
            // For EditTextPreferences, set the summary to the value's simple string representation.
            preference.setSummary(value);
        }
    }*/


