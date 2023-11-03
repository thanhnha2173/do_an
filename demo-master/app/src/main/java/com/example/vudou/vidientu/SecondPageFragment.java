package com.example.vudou.vidientu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by vudou on 7/26/2017.
 */

public class SecondPageFragment extends Fragment {
    ImageView img;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_page, container, false);
        img = (ImageView) rootView.findViewById(R.id.img_fgPage);
        img.setImageResource(R.drawable.img_home);
        return rootView;
    }
}
