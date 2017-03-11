package com.hanbit.contactsapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hb2004 on 2017-03-10.
 */

public abstract class QueryFactory {
    SQLiteDatabase db;
    SQLiteOpenHelper helper;
    Context context;

    public QueryFactory(Context context){
        this.context=context;
        helper=new DatabaseHelper(context);


    }

    public abstract SQLiteDatabase getDatabase();
}
