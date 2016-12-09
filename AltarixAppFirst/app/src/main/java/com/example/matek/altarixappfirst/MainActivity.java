package com.example.matek.altarixappfirst;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.rad_button, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        final SharedPreferences setting = getSharedPreferences("mysettings", Context.MODE_PRIVATE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        boolean checkColor = setting.getBoolean("colorOn", false);
        boolean checkPicture = setting.getBoolean("pictureOn", false);
        if (checkColor) {
            toolbar.setBackgroundColor(Color.GREEN);
        }else {
            toolbar.setBackgroundColor(Color.BLUE);
        }
        LinearLayout container = (LinearLayout) findViewById(R.id.container);

        if (checkPicture) {
            if (container.getChildCount()==0) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.yoda);
                container.addView(imageView);
            }
        }else{
            if (container.getChildCount()==1){
                container.removeViewAt(0);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings:
                Intent intent =new Intent(this,SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.action_about:
                Intent intent1 =new Intent(this,AboutActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
