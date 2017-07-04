package amirahmed.com.mtlf4androidapplication.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import amirahmed.com.mtlf4androidapplication.Adapters.StatisticsAdapter;
import amirahmed.com.mtlf4androidapplication.Models.StatisticsItem;
import amirahmed.com.mtlf4androidapplication.R;

public class StatisticsFragment extends Fragment {

    private List<StatisticsItem> statisticsItems;
    private RecyclerView rvstatstics;

    public StatisticsFragment()
    {
        //Empty Constrictor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statstics, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        rvstatstics = (RecyclerView)getActivity().findViewById(R.id.rvstatstics);

        rvstatstics.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvstatstics.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        statisticsItems = new ArrayList<>();
        Random random = new Random();
        int Low = 1;
        int High = 10;
        int total = High - Low;


        statisticsItems.add(new StatisticsItem("تصفيات الملابس الشتوى",String.valueOf(random.nextInt(total+Low)),String.valueOf(random.nextInt(total+Low)),String.valueOf(random.nextInt(total+Low)),String.valueOf(random.nextInt(total+Low)),String.valueOf(random.nextInt(total+Low))));
        statisticsItems.add(new StatisticsItem("اجدد الملابس الصيفى متاحة الان",String.valueOf(random.nextInt(total+Low)),String.valueOf(random.nextInt(total+Low)),String.valueOf(random.nextInt(total+Low)),String.valueOf(random.nextInt(total+Low)),String.valueOf(random.nextInt(total+Low))));
    }

    private void initializeAdapter() {
        StatisticsAdapter adapter = new StatisticsAdapter(statisticsItems);
        rvstatstics.setAdapter(adapter);
    }

}
