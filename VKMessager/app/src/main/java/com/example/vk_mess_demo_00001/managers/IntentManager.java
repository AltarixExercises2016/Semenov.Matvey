package com.example.vk_mess_demo_00001.managers;

import android.content.Context;
import android.content.Intent;

import com.example.vk_mess_demo_00001.activitys.DialogMessageActivity;
import com.example.vk_mess_demo_00001.activitys.DialogsActivity;
import com.example.vk_mess_demo_00001.activitys.FriendsActivity;
import com.example.vk_mess_demo_00001.activitys.LoginActivity;
import com.example.vk_mess_demo_00001.activitys.SettingActivity;
import com.example.vk_mess_demo_00001.activitys.StartActivity;
import com.example.vk_mess_demo_00001.activitys.UserActivity;
import com.google.gson.Gson;

/**
 * Created by matek on 10.01.2017.
 */

public class IntentManager {
//    private static IntentManager instance;
//
//    public static void init (){
//        if (instance == null){
//            instance = new IntentManager();
//        }
//    }

    public static Intent getDialogsIntent (Context context){
        Intent intent = new Intent(context, DialogsActivity.class);
        return intent;
    }

    public static Intent getSettingIntent (Context context){
        Intent intent = new Intent(context, SettingActivity.class);
        return intent;
    }

    public static Intent getUserIntent (Context context, int userId, String userJson){
        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra("userID", userId);
        intent.putExtra("userJson", userJson);
        return intent;
    }

    public static Intent getFriendIntent(Context context){
        Intent intent = new Intent(context, FriendsActivity.class);
        return intent;
    }

    public static Intent getDialogMessageIntent (Context context, int userId, int chatId, String title, String userName){
        Intent intent = new Intent(context, DialogMessageActivity.class);
        intent.putExtra("userID", userId);
        intent.putExtra("Title", title);
        intent.putExtra("userName", userName);
        intent.putExtra("ChatID", chatId);
        return intent;
    }

    public static Intent getStartIntent (Context context, boolean logout){
        Intent intent = new Intent(context, StartActivity.class);
        intent.putExtra("logout",logout);
        return intent;
    }

    public static Intent getLoginIntent (Context context, boolean logout){
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("logout",logout);
        return intent;
    }
}
