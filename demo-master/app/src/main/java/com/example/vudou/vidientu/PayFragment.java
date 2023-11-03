package com.example.vudou.vidientu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.*;

/**
 * Created by vudou on 7/26/2017.
 */

public class PayFragment extends Fragment {
    ArrayList<CustomButton> listButton;
    RecyclerView recyclerView;
    ButtonAdapter buttonAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pay, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleView_fgPay);

        listButton = new ArrayList<>();
        addButton();

        buttonAdapter = new ButtonAdapter(getActivity(), listButton);
        buttonAdapter.setHasStableIds(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        recyclerView.setAdapter(buttonAdapter);

        return rootView;
    }

    void addButton() {
        listButton.add(new CustomButton(R.drawable.btn_chuyentien, getResources().getString(R.string.tranfer)));
        listButton.add(new CustomButton(R.drawable.btn_naptien, getResources().getString(R.string.recharge_cash)));
        listButton.add(new CustomButton(R.drawable.btn_muathe, getResources().getString(R.string.buy_m_card)));
        listButton.add(new CustomButton(R.drawable.btn_formal, getResources().getString(R.string.change_card_to_cash)));
        listButton.add(new CustomButton(R.drawable.btn_visa, getResources().getString(R.string.visa_service)));
        listButton.add(new CustomButton(R.drawable.btn_naptien, getResources().getString(R.string.recharge_mobile)));
        listButton.add(new CustomButton(R.drawable.btn_drawmoney, getResources().getString(R.string.draw_cash)));
        listButton.add(new CustomButton(R.drawable.btn_hoadon, getResources().getString(R.string.pay_bill)));
        listButton.add(new CustomButton(R.drawable.btn_thanhtoan, getResources().getString(R.string.pay_bill_sta)));
    }

}
