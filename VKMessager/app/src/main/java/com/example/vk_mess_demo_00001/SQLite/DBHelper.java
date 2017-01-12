package com.example.vk_mess_demo_00001.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=4;
    public static final String DATABASE_NAME = "dialogsDb";
    public static final String TABLE_DIALOGS = "dialogs";
    public static final String TABLE_USERS = "users";
    public static final String TABLE_FRIENDS = "friends";

    public static final String KEY_ID = "_id";
    public static final String KEY_ID_USER = "id";
    public static final String KEY_OBJ = "json";

    private static DBHelper instance;


    public static void init(Context context){
        if(instance == null) {
            instance = new DBHelper(context);
        }
    }

    public static DBHelper getInstance(){
        return instance;
    }

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_DIALOGS+"("+KEY_ID
        + " integer,"+KEY_OBJ+" text,"+KEY_ID_USER+" integer"+")");
        db.execSQL("create table "+TABLE_USERS+"("+KEY_ID
                + " integer,"+KEY_OBJ+" text,"+KEY_ID_USER+" integer"+")");
        db.execSQL("create table "+TABLE_FRIENDS+"("+KEY_ID
                + " integer,"+KEY_OBJ+" text,"+KEY_ID_USER+" integer"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_DIALOGS);
        db.execSQL("drop table if exists "+TABLE_USERS);
        db.execSQL("drop table if exists "+TABLE_FRIENDS);
        onCreate(db);
    }
}
