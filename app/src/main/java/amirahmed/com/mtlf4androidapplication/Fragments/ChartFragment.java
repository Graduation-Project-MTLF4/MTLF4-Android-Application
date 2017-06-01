package amirahmed.com.mtlf4androidapplication.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import amirahmed.com.mtlf4androidapplication.R;

public class ChartFragment extends Fragment {


    public ChartFragment()
    {
        //Empty Constrictor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chart, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        LineChart lineChart = (LineChart) getActivity().findViewById(R.id.chart);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(60f, 0));
        entries.add(new Entry(100f, 1));
        entries.add(new Entry(125f, 2));
        entries.add(new Entry(80f, 3));
        entries.add(new Entry(77f, 4));
        entries.add(new Entry(102f, 5));
        entries.add(new Entry(58f, 6));
        entries.add(new Entry(57f, 7));
        entries.add(new Entry(35f, 8));
        entries.add(new Entry(40f, 9));
        entries.add(new Entry(30f, 10));
        entries.add(new Entry(58f, 11));


        LineDataSet dataset = new LineDataSet(entries, "مجموع عدد الاعلانات");

        ArrayList<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        labels.add("August");
        labels.add("September");
        labels.add("October");
        labels.add("November");
        labels.add("December");

        LineData data = new LineData(labels, dataset);
        dataset.setColor(Color.BLUE); //ColorTemplate.COLORFUL_COLORS
        //dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);

        lineChart.setData(data);
        lineChart.animateY(2000);



        //---------------------------------------------------------------------------------------------

        LineChart lineChart2 = (LineChart) getActivity().findViewById(R.id.chart2);

        ArrayList<Entry> entries2 = new ArrayList<>();
        entries2.add(new Entry(60f, 0));
        entries2.add(new Entry(100f, 1));
        entries2.add(new Entry(125f, 2));
        entries2.add(new Entry(80f, 3));
        entries2.add(new Entry(77f, 4));
        entries2.add(new Entry(102f, 5));
        entries2.add(new Entry(58f, 6));
        entries2.add(new Entry(57f, 7));
        entries2.add(new Entry(35f, 8));
        entries2.add(new Entry(40f, 9));
        entries2.add(new Entry(30f, 10));
        entries2.add(new Entry(58f, 11));


        LineDataSet dataset2 = new LineDataSet(entries2, "مجموع عدد المشاهدات / التعليقات");

        ArrayList<String> labels2 = new ArrayList<>();
        labels2.add("January");
        labels2.add("February");
        labels2.add("March");
        labels2.add("April");
        labels2.add("May");
        labels2.add("June");
        labels2.add("July");
        labels2.add("August");
        labels2.add("September");
        labels2.add("October");
        labels2.add("November");
        labels2.add("December");

        LineData data2 = new LineData(labels2, dataset2);
        dataset2.setColor(Color.BLUE); //ColorTemplate.COLORFUL_COLORS
        //dataset.setDrawCubic(true);
        dataset2.setDrawFilled(true);

        lineChart2.setData(data2);
        lineChart2.animateY(2000);


    }

}
