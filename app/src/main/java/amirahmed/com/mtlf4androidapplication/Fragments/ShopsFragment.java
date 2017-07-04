package amirahmed.com.mtlf4androidapplication.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import amirahmed.com.mtlf4androidapplication.Adapters.ShopsListAdapter;
import amirahmed.com.mtlf4androidapplication.Models.ShopItem;
import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Utils.MyScrollListener;

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


        final LinearLayout linearLayout = (LinearLayout) getActivity().findViewById(R.id.linearlaycate);

        rvshop = (RecyclerView) getActivity().findViewById(R.id.rvshop);

        rvshop.setHasFixedSize(true);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvshop.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //rvshop.setLayoutManager(llm);

        rvshop.addOnScrollListener(new MyScrollListener(getContext()) {
            @Override
            public void onMoved(int distance) {
                linearLayout.setTranslationY(distance);
            }
        });

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {

        shop = new ArrayList<>();
        shop.add(new ShopItem("زارا للملابس الجاهزة",R.drawable.zara,"100"));
        shop.add(new ShopItem("شركة الملابس الحديثة",R.drawable.wear,"206"));
        shop.add(new ShopItem("محلات فاشون الحديثة" ,R.drawable.fasion,"45"));
        shop.add(new ShopItem("المتحدة للملابس الجاهزة",R.drawable.aliop,"56"));
        shop.add(new ShopItem("سلسلة محلات هولستر" ,R.drawable.holster,"277"));
        shop.add(new ShopItem("احزية جاب" ,R.drawable.gap,"277"));

    }

    private void initializeAdapter() {

        ShopsListAdapter adapter = new ShopsListAdapter(shop);
        rvshop.setAdapter(adapter);

    }
}
