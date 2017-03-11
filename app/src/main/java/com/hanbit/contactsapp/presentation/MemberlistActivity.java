package com.hanbit.contactsapp.presentation;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hanbit.contactsapp.R;
import com.hanbit.contactsapp.dao.ListQuery;
import com.hanbit.contactsapp.domain.MemberBean;
import com.hanbit.contactsapp.service.ListService;

import java.util.ArrayList;

public class MemberlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberlist);
        final MemberBean member=new MemberBean();
        final ArrayList<?>list=new ArrayList<>();
        findViewById(R.id.btGo).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final MemberList mlist=new MemberList(MemberlistActivity.this);
                ListService serivce=new ListService() {

                    @Override
                    public ArrayList<?> list() {
                        return mlist.list("SELECT _id AS id,name,phone,age,address,salary FROM Member;");
                    }
                };
                ArrayList<?>list=serivce.list();
                Toast.makeText(MemberlistActivity.this, list.get(0).toString(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MemberlistActivity.this, MemberdetailActivity.class);
                intent.putExtra("id",list.get(0).toString());
             //   startActivity(intent);
            }
        });

    }
    class MemberList extends ListQuery {
        public MemberList(Context context){
            super(context);
        }

        public ArrayList<?> list(String sql){
            ArrayList<MemberBean> list=new ArrayList<>();
            SQLiteDatabase db=this.getDatabase();
            Cursor cursor=db.rawQuery(sql,null);
            MemberBean bean=null;
            if(cursor!=null){
                if(cursor.moveToFirst()){
                    do{
                        bean=new MemberBean();
                        bean.setId(cursor.getString(cursor.getColumnIndex("id")));
                        bean.setName(cursor.getString(cursor.getColumnIndex("name")));
                        bean.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                        bean.setAge(cursor.getString(cursor.getColumnIndex("age")));
                        bean.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                        bean.setSalary(cursor.getString(cursor.getColumnIndex("salary")));
                        list.add(bean);
                    }while(cursor.moveToNext());
                }
            }
            return list;
        }

    }
}
