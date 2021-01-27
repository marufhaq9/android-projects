package com.maruf.banglaquran;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class HomeFragment extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle SavedInstanceState) {
            super.onCreate(SavedInstanceState);
            if (InitApplication.getInstance().isNightModeEnabled()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            setContentView(R.layout.fragment_home);
        }
}