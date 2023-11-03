package com.example.vudou.vidientu;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.vudou.vidientu.R.id.btnClick;
import static com.example.vudou.vidientu.R.id.test;

/**
 * Created by vudou on 8/2/2017.
 */

public class FinishReceiver extends BroadcastReceiver{

    private Button btn;
    private OnScreenListener listener;

    public FinishReceiver() {
    }

    public FinishReceiver(OnScreenListener listener) {
        this.listener = listener;
    }

    public FinishReceiver(Button  button) {
        btn = button;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
//        btn.setText("afajfjafll");
        Toast.makeText(context, "Screen ON", Toast.LENGTH_SHORT).show();
        listener.OnScreenOn();
    }

    public interface OnScreenListener {
        void OnScreenOn();
    }

//    public interface OnScreenListener {
//        void onScreenOn();
//    }


}
