package com.example.lenovo.work5;

import android.content.Intent;
import android.net.Uri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
//访问浏览器
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button b1;                         //访问按钮
    private EditText u_url;
    private String urlHead="https://";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        b1= (Button) findViewById(R.id.b1);
        u_url= (EditText) findViewById(R.id.u_url);
        b1.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b1:
                //设置intent
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_VIEW);
                String url= u_url.getText().toString();
                sendIntent.setData(Uri.parse(urlHead+url));  //设置数据
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);                //传递intent启动
                }
                break;

        }
    }
}