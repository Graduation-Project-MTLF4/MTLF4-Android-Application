package amirahmed.com.mtlf4androidapplication.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import amirahmed.com.mtlf4androidapplication.Adapters.MainHomeAdapter;
import amirahmed.com.mtlf4androidapplication.Models.MainHomeItem;
import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Utils.MyScrollListener;


public class MainHomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main_home, container, false);

        final LinearLayout linearLayout = (LinearLayout) getActivity().findViewById(R.id.linearlaycate);

        List<MainHomeItem> rowListItem = getAllItemList();
        LinearLayoutManager lLayout = new LinearLayoutManager(getActivity());

        RecyclerView rView = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        rView.setLayoutManager(lLayout);

        rView.addOnScrollListener(new MyScrollListener(getContext()) {
            @Override
            public void onMoved(int distance) {
                linearLayout.setTranslationY(distance);
            }
        });

        MainHomeAdapter rcAdapter = new MainHomeAdapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        return view ;



    }

    private List<MainHomeItem> getAllItemList(){

        List<MainHomeItem> allItems = new ArrayList<>();
        allItems.add(new MainHomeItem("ازياء حريمي", R.drawable.aa));
        allItems.add(new MainHomeItem("احذية", R.drawable.bb));
        allItems.add(new MainHomeItem("ازياء الاطفال", R.drawable.cc));
        allItems.add(new MainHomeItem("ازياء حريمي", R.drawable.aa));
        allItems.add(new MainHomeItem("احذية", R.drawable.bb));
        allItems.add(new MainHomeItem("ازياء الاطفال", R.drawable.cc));

        return allItems;
    }


}
