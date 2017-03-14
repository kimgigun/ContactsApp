package com.hanbit.contactsapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hb2004 on 2017-03-08.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    final static String DATABASE_NAME="kk.db";
    final static Integer DATABASE_VERSION=2;
    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.getWritableDatabase();
    };

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Member ("+
                " _id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "phone TEXT," +
                "age TEXT," +
                "address TEXT," +
                "salary TEXT);");
     /*for(int i=0;i<10;i++){
            db.execSQL(String.format("INSERT INTO Member(name,phone,age,address,salary) " +
                    "VALUES('%s','%s','%s','%s','%s');","홍길동"+i,"010-0000-000"+i,"2"+i,"서울",(i+1)+"00"));
        }*/
    //더미데이터*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS Member");
        onCreate(db);
    }


}
