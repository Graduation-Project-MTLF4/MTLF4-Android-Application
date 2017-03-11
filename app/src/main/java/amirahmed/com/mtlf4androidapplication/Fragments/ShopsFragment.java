package amirahmed.com.mtlf4androidapplication.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import amirahmed.com.mtlf4androidapplication.Adapters.ShopsListAdapter;
import amirahmed.com.mtlf4androidapplication.Models.ShopItem;
import amirahmed.com.mtlf4androidapplication.R;

public class ShopsFragment extends Fragment {

    private List<ShopItem> shop;
    private RecyclerView rvshop;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shops, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        rvshop = (RecyclerView) getActivity().findViewById(R.id.rvshop);

        rvshop.setHasFixedSize(true);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvshop.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //rvshop.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {

        shop = new ArrayList<>();
        shop.add(new ShopItem("زارا للملابس الجاهزة"));
        shop.add(new ShopItem("شركة الملابس الحديثة"));
        shop.add(new ShopItem("راضى لبواقى التصدير"));
        shop.add(new ShopItem("اكسسوارات الاول"));
        shop.add(new ShopItem("احزية العباسية"));

    }

    private void initializeAdapter() {

        ShopsListAdapter adapter = new ShopsListAdapter(shop);
        rvshop.setAdapter(adapter);

    }
}
