package org.lut.week11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//https://www.youtube.com/watch?v=bjYstsO1PgI
//https://www.youtube.com/watch?v=ILgoCBeh8Zo
//Android Studio - Creating Sidebar Navigation Drawer - Over Action Bar - Part - 1
//Navigation Drawer with Fragments Part 1 - MENU AND ACTIVITY THEME - Android Studio Tutorial
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String PREF_SWITCH_EDITABLE = "pref_switch_editable";
    public static final String PREF_LIST_COLOR = "pref_list_color";
    public static final String PREF_EDITTEXT_SIZE = "pref_edittext_size";
    public static final String PREF_EDITTEXT_WIDTH = "pref_edittext_width";
    public static final String PREF_EDITTEXT_HEIGHT = "pref_edittext_height";

    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;

    SharedPreferences sharedPreferences;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle mToggle;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        PreferenceManager.setDefaultValues(this, R.xml.edit_text_options, false);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        loadEditablePreference(sharedPreferences);
        loadColorFromPreference(sharedPreferences);
        loadTextSizeFromPreference(sharedPreferences);
        changeWidth(sharedPreferences.getString(PREF_EDITTEXT_WIDTH, ""));
        changeHeight(sharedPreferences.getString(PREF_EDITTEXT_HEIGHT, ""));

        preferenceChangeListener = (sharedPreferences, s) -> {
            if(s.equals(PREF_SWITCH_EDITABLE)) {
                switchEditableStatus(sharedPreferences.getBoolean(s, true));
            }

            if (s.equals(PREF_LIST_COLOR)){
                String colorName = sharedPreferences.getString(s, "");
                changeTextColor(colorName);
            }
            if (s.equals(PREF_EDITTEXT_SIZE)) {
                String fontSize = sharedPreferences.getString(s, "");
                changeTextSize(fontSize);
            }
            if (s.equals(PREF_EDITTEXT_WIDTH)) {
                String width = sharedPreferences.getString(s, "");
                changeWidth(width);
            }
            if (s.equals(PREF_EDITTEXT_HEIGHT)) {
                String height = sharedPreferences.getString(s, "");
                changeHeight(height);
            }
        };
        sharedPreferences.registerOnSharedPreferenceChangeListener(preferenceChangeListener);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Open, R.string.Close);

        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView = findViewById(R.id.drawer_nav);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(preferenceChangeListener);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                    loadEditablePreference(sharedPreferences);
                    loadColorFromPreference(PreferenceManager.getDefaultSharedPreferences(this));
                    loadTextSizeFromPreference(PreferenceManager.getDefaultSharedPreferences(this));
                    changeHeight(sharedPreferences.getString(PREF_EDITTEXT_HEIGHT, ""));
                    changeWidth(sharedPreferences.getString(PREF_EDITTEXT_WIDTH, ""));
                }
            }
            //Toast.makeText(this,"HOME", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.editable) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new EditableSettingFragment()).commit();

        } else if (id == R.id.setting) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SettingFragment()).commit();

            System.out.println("Setting");
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadEditablePreference(SharedPreferences sharedPreferences) {
        Log.d("Pref_val", String.valueOf(sharedPreferences.getBoolean(PREF_SWITCH_EDITABLE, true)));
        switchEditableStatus(sharedPreferences.getBoolean(PREF_SWITCH_EDITABLE, true));
    }
    private void loadColorFromPreference(SharedPreferences sharedPreferences) {
        Log.d("Pref_val",sharedPreferences.getString(PREF_LIST_COLOR, getString(R.string.pref_color_value_red)));
        changeTextColor(sharedPreferences.getString(PREF_LIST_COLOR, getString(R.string.pref_color_value_red)));
    }

    private void loadTextSizeFromPreference(SharedPreferences sharedPreferences) {
        Log.d("Pref_val", sharedPreferences.getString(PREF_EDITTEXT_SIZE,""));
        changeTextSize(sharedPreferences.getString(PREF_EDITTEXT_SIZE, ""));
    }

    private void showInTextView(String text){
        textView.setText(text);
    }

    private void switchEditableStatus(boolean editable) {
        editText.setEnabled(editable);
        editText.setFocusable(editable);

        if (!editable){
            showInTextView(editText.getText().toString());
        }
    }

    private void changeTextSize(String font_size) {
        float size = Float.parseFloat(font_size);
        textView.setTextSize(size);
    }

    private void changeWidth(String width) {
        int size = Integer.parseInt(width);
        textView.setWidth(size);
    }

    private void changeHeight(String height) {
        int size = Integer.parseInt(height);
        textView.setHeight(size);
    }

    private void changeTextColor(String pref_color_value) {
        Log.d("Pref_val", pref_color_value);
        if (pref_color_value.equals("RED")) {
            textView.setTextColor(Color.RED);
        } else if(pref_color_value.equals("GREEN")) {
            textView.setTextColor(Color.GREEN);
        } else {
            textView.setTextColor(Color.BLUE);
        }
    }
}

//https://www.youtube.com/watch?v=H4TbRo_pxgU
/*
        preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
                if (s.equals(PREF_LIST_COLOR)){
                    String colorName = sharedPreferences.getString(s, "");
                    changeTextColor(colorName);
                }
                if (s.equals(PREF_EDITTEXT_SIZE)) {
                    String fontSize = sharedPreferences.getString(s, "");
                    changeTextSize(fontSize);
                }
                if(s.equals(PREF_SWITCH_EDITABLE)) {
                    switchEditableStatus(sharedPreferences.getBoolean(s, true));
                }
            }
        };
        */