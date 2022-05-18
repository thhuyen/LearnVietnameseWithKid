package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {


    public static final String DBNAME = "Login.db";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    // truy can khong tra ket qua: CREATE, INSERT, UPDATE, DELETE...
    public void QueryData(String sql)
    {
        SQLiteDatabase database = getWritableDatabase(); // ca viet dc va doc duoc
        database.execSQL(sql);
    }

    // truy van tra ket qua: SELECT (tra du lieu dang con tro, con tro duyet trong DB de tra ve ket qua)
    public Cursor GetData(String sql)
    {
        SQLiteDatabase database = getReadableDatabase(); // chi doc duoc khong viet duoc
        return database.rawQuery(sql, null); // tra ve database
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    // hàm insert data
    public Boolean insertData(String username, String password, String name, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);
        values.put("name",name);
        values.put("email", email);


        long result = db.insert("users",null,values);
        if (result == -1) return false;
        else
            return true;
    }

    // hàm check username
    public Boolean checkUsername (String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?",new String[] {username});
        if (cursor.getCount() > 0)      // đã tồn tại 1 tài khoản
            return true;
        else
            return false;
    }

    // hàm check account
    public Boolean checkAccount (String username, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? and password=?",new String[] {username,password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
