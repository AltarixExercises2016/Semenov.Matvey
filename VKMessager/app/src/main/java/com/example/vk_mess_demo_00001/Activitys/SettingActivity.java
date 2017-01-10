package com.example.vk_mess_demo_00001.activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.vk_mess_demo_00001.R;
import com.example.vk_mess_demo_00001.managers.IntentManager;
import com.example.vk_mess_demo_00001.managers.PreferencesManager;

public class SettingActivity extends AppCompatActivity {
    PreferencesManager preferencesManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Settings");
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Switch photouser = (Switch) findViewById(R.id.switch1);
        Switch photochat = (Switch) findViewById(R.id.switch3);
        Switch online = (Switch) findViewById(R.id.switch2);
        Button button = (Button) findViewById(R.id.button);
        preferencesManager = PreferencesManager.getInstance();


        photouser.setChecked(preferencesManager.getSettingPhotoUserOn());
        photochat.setChecked(preferencesManager.getSettingPhotoChatOn());
        online.setChecked(preferencesManager.getSettingOnline());


        photouser.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferencesManager.setSettingPhotoUserOn(isChecked);
            }
        });
        photochat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferencesManager.setSettingPhotoChatOn(isChecked);
            }
        });
        online.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferencesManager.setSettingOnline(isChecked);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferencesManager.setToken("");
                startActivity(IntentManager.getStartIntent(SettingActivity.this,true));
                SettingActivity.this.finish();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
