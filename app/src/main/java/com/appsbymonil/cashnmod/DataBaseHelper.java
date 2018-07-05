package com.appsbymonil.cashnmod;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp 15 on 11/19/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Record.db";
    public static final String TABLE_NAME = "Record_Table";


    public static final String COL_1= "NAME";
    public static final String COL_2= "USERNAME";
    public static final String COL_3= "EMAIL";
    public static final String COL_4= "CONTACT";
    public static final String COL_5= "GENDER";
    public static final String COL_6= "COUNTRY";
    public static final String COL_7 = "PASSWORD";

    public DataBaseHelper(Context context){
        super(context , DATABASE_NAME , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table" + TABLE_NAME + "(NAME INTEGER PRIMARY KEY AUTOINCREMENT , USERNAME TEXT , EMAIL TEXT , CONTACT INTEGER , GENDER TEXT , COUNTRY TEXT , PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
    }
    public boolean insertData(String name , String username , String email , String contact , String gender , String country , String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, username);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, contact);
        contentValues.put(COL_5, gender);
        contentValues.put(COL_6, country);
        contentValues.put(COL_7 , password);
        long result = db.insert(TABLE_NAME , null , contentValues);
        db.close();

        if(result == -1){
            return false;
        }
        else{
            return true ;
        }

    }

 /*   public Cursor getLoginDet(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select PASSWORD FROM" + TABLE_NAME +"WHERE ")
    }*/

}
