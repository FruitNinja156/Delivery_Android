package com.example.apppppp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper{

    public static final String DBNAME = "DoorDashDB1.db";

    public DBHelper(Context context) {
        super(context, "DoorDashDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE DoorDash(name VARCHAR, lname VARCHAR, phno INTEGER, email VARCHAR,passw VARHAR, username VARCHAR);");
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS DoorDash");
    }
    public Boolean insertData(String name, String lname, String phno,String email, String passw, String username){
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("lname", lname);
        contentValues.put("phno", phno);
        contentValues.put("email", email);
        contentValues.put("passw", passw);
        contentValues.put("username", username);
        long result = db.insert("DoorDash", null, contentValues);
        if (result ==-1) return false;
        else
            return true;
    }

    public Boolean checkUser(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM DoorDash WHERE username =?",new String[] {username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkUserandPass (String username, String passw){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM DoorDash WHERE username =? and passw =? ", new String[]{username, passw});
        if (cursor.getCount()> 0)
            return true;
        else
            return false;
    }
}
