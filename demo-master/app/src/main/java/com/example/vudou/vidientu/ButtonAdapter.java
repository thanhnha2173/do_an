package com.example.vudou.vidientu;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vudou on 7/26/2017.
 */

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.RecyclerViewHolder>{
    private Context context;
    private ArrayList<CustomButton> listButton;

    public ButtonAdapter() {
    }

    public ButtonAdapter(Context context, ArrayList<CustomButton> listButton) {
        this.context = context;
        this.listButton = listButton;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rootView = inflater.inflate(R.layout.layout_button, parent, false);
        return new RecyclerViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.img.setImageResource(listButton.get(position).getPicRes());
        holder.txt.setText(listButton.get(position).getDecr());
    }

    @Override
    public int getItemCount() {
        return listButton.size();
    }




    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txt;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_btn_layout);
            txt = (TextView) itemView.findViewById(R.id.text_btn_layout);
        }
    }
}
