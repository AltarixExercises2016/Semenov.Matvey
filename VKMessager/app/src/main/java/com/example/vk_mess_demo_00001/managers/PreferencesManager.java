package com.example.vk_mess_demo_00001.managers;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.ref.WeakReference;


public class PreferencesManager {

    private static WeakReference<Context> context;
    private static PreferencesManager instance;
    private SharedPreferences tokenPrefs;
    private SharedPreferences settingsPref;
    private SharedPreferences userIdPref;
    private SharedPreferences userGsonPref;

    public static String TOKEN = "token";
    public static String SETTINGS = "mysettings";
    public static String USERID = "uid";
    public static String USERGSON = "uidgson";

    public static void init (Context context){
        instance = new PreferencesManager(context);
    }

    private PreferencesManager(Context context){
        this.context = new WeakReference<>(context);
        initPrefs();
    }

    private void initPrefs(){
        if(tokenPrefs == null)
            tokenPrefs = context.get().getSharedPreferences(TOKEN, Context.MODE_PRIVATE);
        if(settingsPref == null)
            settingsPref = context.get().getSharedPreferences(SETTINGS, Context.MODE_PRIVATE);
        if(userIdPref == null)
            userIdPref = context.get().getSharedPreferences(USERID, Context.MODE_PRIVATE);
        if(userGsonPref == null)
            userGsonPref = context.get().getSharedPreferences(USERGSON, Context.MODE_PRIVATE);
    }

    public static PreferencesManager getInstance(){
        return instance;
    }

    public  int getUserID (){
        return userIdPref.getInt("uid_int",0);
    }

    public String getUserGson (){
        return userGsonPref.getString("uidgson_string", "");
    }

    public String getToken (){
        return tokenPrefs.getString("token_string", "");
    }

    public boolean getSettingPhotoUserOn (){
        return settingsPref.getBoolean("photouserOn",true);
    }

    public boolean getSettingPhotoChatOn (){
        return settingsPref.getBoolean("photochatOn",true);
    }

    public boolean getSettingOnline() {
        return settingsPref.getBoolean("onlineOn",true);
    }

    public void setUserID (int uid){
        SharedPreferences.Editor editor = userIdPref.edit();
        editor.putInt("uid_int",uid);
        editor.apply();
    }

    public void setUserGson (String gson){
        SharedPreferences.Editor editor = userGsonPref.edit();
        editor.putString("uidgson_string",gson);
        editor.apply();
    }

    public void setToken (String token){
        SharedPreferences.Editor editor = tokenPrefs.edit();
        editor.putString("token_string",token);
        editor.apply();
    }

    public void setSettingPhotoUserOn (boolean isChecked){
        SharedPreferences.Editor editor = settingsPref.edit();
        editor.putBoolean("photouserOn",isChecked);
        editor.apply();
    }

    public void setSettingPhotoChatOn (boolean isChecked){
        SharedPreferences.Editor editor = settingsPref.edit();
        editor.putBoolean("photochatOn",isChecked);
        editor.apply();
    }

    public void setSettingOnline(boolean isChecked) {
        SharedPreferences.Editor editor = settingsPref.edit();
        editor.putBoolean("onlineOn",isChecked);
        editor.apply();
    }
}
