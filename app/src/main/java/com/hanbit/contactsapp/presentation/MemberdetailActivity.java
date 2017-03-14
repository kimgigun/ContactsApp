package com.hanbit.contactsapp.presentation;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hanbit.contactsapp.R;
import com.hanbit.contactsapp.dao.DetailQuery;
import com.hanbit.contactsapp.domain.MemberBean;
import com.hanbit.contactsapp.service.DetailService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberdetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberdetail);
        Context context=MemberdetailActivity.this;
        Intent intent = this.getIntent();
        final String id = intent.getExtras().getString("id");
        Map<String, String> map = new HashMap<>();
        map.put("id",id);
        final MemberDetail mDetail = new MemberDetail(context);
        List<Button> buttons=new ArrayList<>();
        buttons.add((Button)findViewById(R.id.btDial));
        buttons.add((Button)findViewById(R.id.btGoList));
        buttons.add((Button)findViewById(R.id.btGoUpdate));
        Toast.makeText(MemberdetailActivity.this, map.get("id"), Toast.LENGTH_LONG).show();
        DetailService service = new DetailService() {
            @Override
            public Object findOne(Map<?, ?> map) {
                MemberBean temp = (MemberBean) mDetail.findOne(
                        "SELECT _id AS id,name,phone,age,address,salary " +
                                " FROM Member WHERE _id = '" + map.get("id") + "';");
                return temp;
            }
        };
        final MemberBean member = (MemberBean) service.findOne(map);
        TextView tvId = (TextView) findViewById(R.id.tvId);
        tvId.setText(member.getId());
        TextView tvName = (TextView) findViewById(R.id.tvName);
        tvName.setText(member.getName());
        TextView tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvPhone.setText(member.getPhone());
        TextView tvAge = (TextView) findViewById(R.id.tvAge);
        tvAge.setText(member.getAge());
        TextView tvAddress = (TextView) findViewById(R.id.tvAddress);
        tvAddress.setText(member.getAddress());
        TextView tvSalary = (TextView) findViewById(R.id.tvSalary);
        tvSalary.setText(member.getSalary());
        /*map.clear();*/ //클리어가능
        map.put("phoneNo",member.getPhone());
        new ButtonObserver(context,buttons,map).onClick(findViewById(android.R.id.content));


      /*  // Toast.makeText(MemberdetailActivity.this,member.getName(),Toast.LENGTH_LONG).show();
        findViewById(R.id.btDial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + member.getPhone()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        findViewById(R.id.btCall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.btGoUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MemberdetailActivity.this, "ID is " + id, Toast.LENGTH_LONG).show();
                startActivity(new Intent(MemberdetailActivity.this, MemberaddActivity.class));
            }
        });*/

    }

    class MemberDetail extends DetailQuery{

        public MemberDetail(Context context) {
            super(context);
        }



        @Override
        public Object findOne(String sql) {
            MemberBean bean=null;
            SQLiteDatabase db=super.getDatabase();
            Cursor cursor=db.rawQuery(sql,null);

            if(cursor!=null){
                if(cursor.moveToNext()){
                    bean=new MemberBean();
                    bean.setId(cursor.getString(cursor.getColumnIndex("id")));
                    bean.setName(cursor.getString(cursor.getColumnIndex("name")));
                    bean.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                    bean.setAge(cursor.getString(cursor.getColumnIndex("age")));
                    bean.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                    bean.setSalary(cursor.getString(cursor.getColumnIndex("salary")));
                }
            }
            return bean;
    }
}
class ButtonObserver implements View.OnClickListener{
    Context context;
    Map<String, String>map;
    List<Button>buttons;
    public ButtonObserver(Context context,List<Button>buttons,Map<String, String>map){
        this.context=context;
        this.buttons=buttons;
        this.map=map;
        for(Button b:buttons){
            b.setOnClickListener(this);
        }
    }



        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.btGoList:
                    intent =new Intent(MemberdetailActivity.this,MemberlistActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btDial:
                    Toast.makeText(MemberdetailActivity.this, "콜콜", Toast.LENGTH_SHORT).show();
                    intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+map.get("phoneNo")));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    break;
                case R.id.btCall:
                    Toast.makeText(MemberdetailActivity.this, "콜콜", Toast.LENGTH_SHORT).show();
                    intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + map.get("getPhone")));
                    if(ActivityCompat.checkSelfPermission(MemberdetailActivity.this, Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(MemberdetailActivity.this,new String[]{
                                Manifest.permission.CALL_PHONE
                        },2);
                    }
                    break;
                case R.id.btGoUpdate:
                    intent=new Intent(context,MemberupdateActivity.class);
                    intent.putExtra("id",map.get("id"));
                    startActivity(intent);
           /*                 Toast.makeText(MemberdetailActivity.this, "ID is " + id, Toast.LENGTH_LONG).show();
                            *//*startActivity(new Intent(MemberdetailActivity.this, MemberaddActivity.class));*/
                    break;
            }
        }


    }
    public void onCall(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:010-1234-5678"));
        startActivity(intent);
    }
}