package com.haobi.ottodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    private TextView tv_message;
    private Button bt_jump;
    //otto同样需要注册和取消注册、订阅事件
    private Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_message = (TextView)findViewById(R.id.tv_message);
        bt_jump = (Button)findViewById(R.id.bt_jump);
        bt_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        //通过OttoBus得到Bus对象
        bus = OttoBus.getInstance();
        //调用Bus的register方法来注册和取消注册
        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //调用Bus的unregister方法来注册和取消注册
        bus.unregister(this);
    }

    //订阅事件
    @Subscribe
    public void setContent(BusData data){
        //使用textView来显示接收到的消息
        tv_message.setText(data.getMessage());
    }
}
