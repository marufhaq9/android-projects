package com.maruf.banglaquran;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.ResourcesCompat;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity {
    SwitchCompat aSwitch;
    RadioButton radioButton;
    RadioGroup radioGroup;
    TextView textView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                if (InitApplication.getInstance().isNightModeEnabled()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                setContentView(R.layout.activity_settings);
                context = this;

                aSwitch = findViewById(R.id.switch1);

                radioGroup = findViewById(R.id.radioGroup);

                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                    aSwitch.setChecked(true);

                aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            InitApplication.getInstance().setIsNightModeEnabled(true);
                            Intent intent = getIntent();
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            //finish();
                            startActivity(intent);

                        } else {
                            InitApplication.getInstance().setIsNightModeEnabled(false);
                            Intent intent = getIntent();
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            //finish();
                            startActivity(intent);
                        }


                    }
                });




                //aSwitch.setTextOn("On");
                //aSwitch.setTextOff("Off");
                // check current state of a Switch (true or false).
        /*final boolean switchstate = aSwitch.isChecked();
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switchstate==true){
                    setTheme(R.style.AppTheme);
                }
            }
        });*/

            }

    public void onclickbuttonMethod(View v){
        //int selectedId = radioGroup.getCheckedRadioButtonId();
        //radioButton = findViewById(selectedId);
        SettingsClass settingsClass = new SettingsClass();
        textView = findViewById(R.id.sample);
        boolean checked = ((RadioButton) v).isChecked();
        switch(v.getId()) {
            case R.id.radio1:
                //textView.setTypeface(typeface1);
                settingsClass.SettingClass("medina)");
                break;
            case R.id.radio2:
                settingsClass.SettingClass("fonts)");
                break;
            case R.id.radio3:
                settingsClass.SettingClass("ResourcesCompat.getFont(context, R.font.saleem)");
                break;
                case R.id.default_activity_button:
                    Toast.makeText(getApplicationContext(),"No Button Selected!!",Toast.LENGTH_SHORT).show();
                    break;
        }
    }

            @Override
            public void onBackPressed() {
                super.onBackPressed();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        }

