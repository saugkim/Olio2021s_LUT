package org.lut.week11s;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String PREF_EDITTEXT_DISPLAY = "pref_edittext_display";
    public static final String PREF_LIST_LAN = "pref_list_language";

    SharedPreferences sharedPreferences;
    SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;

    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;
    TextView textView;
    Toolbar toolbar;

//locale => https://www.youtube.com/watch?v=zj_iKcc0lo0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tvDisplayText);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView = findViewById(R.id.layout_navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        onSharedPreferenceChangeListener = (sharedPreferences, s) -> {
            if (s.equals(PREF_EDITTEXT_DISPLAY)) {
                displayText(sharedPreferences);
            }
            if (s.equals(PREF_LIST_LAN)) {
                String selectedLan = sharedPreferences.getString(PREF_LIST_LAN, "");
                setLocale(this, getLocalCode(selectedLan));

                Intent refresh = new Intent(this, MainActivity.class);
                startActivity(refresh);
            }
        };
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);

        displayText(sharedPreferences);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void setLocale(Activity activity, String lanCode) {
        Locale locale = new Locale(lanCode);
        Locale.setDefault(locale);

        Resources resources = activity.getBaseContext().getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

    public String getLocalCode(String lan) {
        String ret;

        switch (lan) {
            case "FIN":
                ret = "fi";
                break;
            case "FRA":
                ret = "fr";
                break;
            case "GER":
                ret = "de";
                break;
            case "ESP":
                ret = "es";
                break;
            default:
                ret = "en";
                break;
        }

        return ret;
    }

    private void displayText(SharedPreferences sharedPreferences) {
        textView.setText(sharedPreferences.getString(PREF_EDITTEXT_DISPLAY, ""));
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
                    displayText(sharedPreferences);
                }
            }

        } else if (id == R.id.settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SettingFragment()).commit();
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}