package com.example.vudou.vidientu;

import android.content.Context;
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

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.RecycleViewHolder>{
    private Context context;
    private ArrayList<CustomNews> listNews;

    public NewsAdapter() {
    }


    public NewsAdapter(Context context, ArrayList<CustomNews> listNews) {
        this.context = context;
        this.listNews = listNews;
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.layout_new, parent, false);
        return new RecycleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        holder.img.setImageResource(listNews.get(position).getPicRes());
        holder.title.setText(listNews.get(position).getTitle());
        holder.decr.setText(listNews.get(position).getDecr());
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public CustomNews getPosition(int position) {
        return listNews.get(position);
    }


    public class RecycleViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title, decr;
        public RecycleViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_new);
            title = (TextView) itemView.findViewById(R.id.txt_title_new);
            decr = (TextView) itemView.findViewById(R.id.txt_decr_new);
        }
    }
}
