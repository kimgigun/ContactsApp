package com.hanbit.contactsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btGO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btGO= (Button) findViewById(R.id.btGo);
        btGO.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this,"go 버튼 클릭",Toast.LENGTH_LONG).show();
    }
}
