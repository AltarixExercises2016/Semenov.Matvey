package com.example.matek.altarixappfirst;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle(R.string.action_settings);
        Switch switchColor = (Switch) findViewById(R.id.switch1);
        Switch switchPicture = (Switch) findViewById(R.id.switch2);
        final SharedPreferences setting = getSharedPreferences("mysettings", Context.MODE_PRIVATE);
        switchColor.setChecked(setting.getBoolean("colorOn",false));
        switchPicture.setChecked(setting.getBoolean("pictureOn",false));
        switchColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SharedPreferences.Editor editor = setting.edit();
                    editor.putBoolean("colorOn",isChecked);
                    editor.apply();
            }
        });
        switchPicture.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = setting.edit();
                editor.putBoolean("pictureOn",isChecked);
                editor.apply();
            }
        });
    }
}
