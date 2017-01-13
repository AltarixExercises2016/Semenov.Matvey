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

import static com.example.vk_mess_demo_00001.App.frwdMessages;

public class IntentManager {


    public static Intent getDialogsIntent (Context context, boolean frwdMessDetector, boolean clearStack){
        Intent intent = new Intent(context, DialogsActivity.class);
        if (clearStack){
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra("frwd",frwdMessDetector);
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

    public static Intent getFriendIntent(Context context,int userId, boolean clearStack){
        Intent intent = new Intent(context, FriendsActivity.class);
        if (clearStack){
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra("userID",userId);
        return intent;
    }

    public static Intent getDialogMessageIntent (Context context, int userId, int chatId, String title, String userName, boolean frwdMessDetector){
        Intent intent = new Intent(context, DialogMessageActivity.class);
        intent.putExtra("userID", userId);
        intent.putExtra("Title", title);
        intent.putExtra("userName", userName);
        intent.putExtra("ChatID", chatId);
        if (!frwdMessDetector){
            frwdMessages.clear();
        }
        return intent;
    }

    public static Intent getStartIntent (Context context, boolean logout,boolean clearStack){
        Intent intent = new Intent(context, StartActivity.class);
        intent.putExtra("logout",logout);
        if (clearStack){
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        return intent;
    }

    public static Intent getLoginIntent (Context context, boolean logout){
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("logout",logout);
        return intent;
    }
}
