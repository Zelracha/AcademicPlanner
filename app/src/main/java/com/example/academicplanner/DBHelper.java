package com.example.academicplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //public static final String DBNAME="login.db";
    private static final String dbname="login.db";
    public DBHelper(Context context) {
        super(context, dbname, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tbllogin(username TEXT primary key, password TEXT)"); }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists tbllogin");
//onCreate(db);
    }
    public Boolean insert(String username ,String password)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("username",username);
        values.put("password",password);

        long result=db.insert("tbllogin",null,values);
        if(result==-1) {
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean checkUsername(String username)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from tbllogin where username=?",new String[] {username});
        if (cursor.getCount()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean checkUsernamepassowrd(String username, String password)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from tbllogin where username=? and password=?",new String[]

                {username,password});
        if (cursor.getCount()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }
}
