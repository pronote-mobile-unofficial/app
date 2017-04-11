package com.maeen.fliife.school.profiles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProfileDatabase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Profiles.db";
    public static ProfileDatabase instance;

    private ProfileDatabase(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static ProfileDatabase getInstance(Context c) {
        instance = instance == null ? new ProfileDatabase(c) : instance;
        return instance;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE profiles (" +
                "username VARCHAR(100)" +
                "password VARCHAR(100)" +
                "url VARCHAR(200) )");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

