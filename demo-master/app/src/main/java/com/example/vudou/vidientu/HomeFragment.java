package com.example.vudou.vidientu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.SupportActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vudou on 7/26/2017.
 */

public class HomeFragment extends Fragment {
    ViewPager viewPager;
    ArrayList<Fragment> listFragment;
    ArrayList<CustomButton> listButton;
    ArrayList<CustomNews> listNews;
    MyPagerAdapter pagerAdapter;
    ButtonAdapter buttonAdapter;
    NewsAdapter newsAdapter;
    RecyclerView cvButton, cvNews;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        setContructor(rootView);
        createViewPaper();
        createListButton();
        setListNews();
        return rootView;
    }

    void setContructor(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_fgHome);
        cvButton = (RecyclerView) view.findViewById(R.id.recyclerViewButton_fgHome);
        cvNews = (RecyclerView) view.findViewById(R.id.recyclerViewNews_fgHome);
    }

    public void createViewPaper() {
        listFragment = new ArrayList<>();
        listButton = new ArrayList<>();
        listNews = new ArrayList<>();

        listFragment.add(new FirstPageFragment());
        listFragment.add(new SecondPageFragment());

        pagerAdapter = new MyPagerAdapter(this.getChildFragmentManager(), listFragment);
        viewPager.setAdapter(pagerAdapter);
    }

    public void createListButton() {
        listButton.add(new CustomButton(R.drawable.btn_aboutus, getResources().getString(R.string.about_us)));
        listButton.add(new CustomButton(R.drawable.btn_drawmoney, getResources().getString(R.string.draw_cash)));
        listButton.add(new CustomButton(R.drawable.btn_formal, getResources().getString(R.string.excharge)));
        listButton.add(new CustomButton(R.drawable.btn_service, getResources().getString(R.string.service)));
        listButton.add(new CustomButton(R.drawable.btn_addmoney, getResources().getString(R.string.send_cash)));

        buttonAdapter = new ButtonAdapter(getActivity(), listButton);
        buttonAdapter.setHasStableIds(true);

        cvButton.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        cvButton.setAdapter(buttonAdapter);
    }

    public void setListNews() {
        listNews.add(new CustomNews(R.drawable.pic_mbank, getResources().getString(R.string.title1), getResources().getString(R.string.decr1)));
        listNews.add(new CustomNews(R.drawable.pic_share, getResources().getString(R.string.title2), getResources().getString(R.string.decr2)));
        listNews.add(new CustomNews(R.drawable.pic_valentine, getResources().getString(R.string.title3), getResources().getString(R.string.decr3)));

        newsAdapter = new NewsAdapter(getActivity(), listNews);
        newsAdapter.setHasStableIds(true);

        cvNews.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        cvNews.setAdapter(newsAdapter);
    }
}


