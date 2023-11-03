package com.example.vudou.vidientu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vudou on 7/26/2017.
 */

public class TestAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<CustomButton> listButton;

    public TestAdapter(Context context, ArrayList<CustomButton> listButton) {
        this.context = context;
        this.listButton = listButton;
    }

    public TestAdapter() {
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<CustomButton> getListButton() {
        return listButton;
    }

    public void setListButton(ArrayList<CustomButton> listButton) {
        this.listButton = listButton;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rootView = inflater.inflate(R.layout.layout_button, parent, false);
        ImageView img = (ImageView) convertView.findViewById(R.id.img_btn_layout);
        TextView txt = (TextView) convertView.findViewById(R.id.text_btn_layout);
        img.setImageResource(listButton.get(position).getPicRes());
        txt.setText(listButton.get(position).getDecr());
        return rootView;
    }
}
