package com.hanbit.contactsapp.dao;

import android.content.Context;

/**
 * Created by hb2004 on 2017-03-10.
 */

public abstract class DetailQuery extends QueryFactory{
    public  DetailQuery(Context context,Boolean isSelect) {
        super(context);
    }

    public DetailQuery(Context context) {
        super(context);
    }

    public abstract Object detail(String sql);
}
