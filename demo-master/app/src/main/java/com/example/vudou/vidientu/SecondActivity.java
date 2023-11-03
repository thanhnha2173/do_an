package com.example.vudou.vidientu;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.string.no;

public class SecondActivity extends AppCompatActivity {
    Button btnClick;
    BroadcastReceiver receiver;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnClick= (Button) findViewById(R.id.btnClick);
        txt = (TextView) findViewById(R.id.txtDemo);

//        receiver = new FinishReceiver(new FinishReceiver.OnScreenListener() {
//
//            @Override
//            public void OnScreenOn() {
//                txt.setText("done");
//            }
//        });
//        registerReceiver(receiver, new IntentFilter(Intent.ACTION_SCREEN_OFF));

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Constain.FINNISH_ACT);
                sendBroadcast(i);
                finish();
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }




}
