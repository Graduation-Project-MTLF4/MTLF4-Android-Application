package amirahmed.com.mtlf4androidapplication.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import amirahmed.com.mtlf4androidapplication.Adapters.PostAdapter;
import amirahmed.com.mtlf4androidapplication.Activities.FilterActivity;
import amirahmed.com.mtlf4androidapplication.Models.PostItem;
import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Utils.MyScrollListener;

public class PostsFragment extends Fragment {

    private List<PostItem> postItems;
    private RecyclerView rvpost;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final LinearLayout linearLayout = (LinearLayout) getActivity().findViewById(R.id.linearlaycate);

        String[] items = new String[] {"ترتيب حسب الاسم", "ترتيب حسب التاريخ", "ترتيب حسب النوع","اختر الترتيب"};
        final int listsize = items.length -1;
        Spinner spinner = (Spinner)getActivity().findViewById(R.id.sorting);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items)
        {
            @Override
            public int getCount() {
                return(listsize); // Truncate the list
            }
        };

        dataAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(dataAdapter);
        spinner.setSelection(listsize);

        ImageView filter = (ImageView) getActivity().findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext() , FilterActivity.class);
                getContext().startActivity(intent);
            }
        });


        rvpost = (RecyclerView)getActivity().findViewById(R.id.rvpost);

        rvpost.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvpost.setLayoutManager(llm);

        rvpost.addOnScrollListener(new MyScrollListener(getContext()) {
            @Override
            public void onMoved(int distance) {
                linearLayout.setTranslationY(distance);
            }
        });

        initializeData();
        initializeAdapter();
    }


    private void initializeData() {
        postItems = new ArrayList<>();
        postItems.add(new PostItem("عروض على ملابس الكاجوال", "عند زيارتك للمحل ستحصل على خصم يصل الى 20%", R.drawable.offer));
        postItems.add(new PostItem("عروض على ملابس الكاجوال", "عند زيارتك للمحل ستحصل على خصم يصل الى 20%", R.drawable.drawerpic));
    }

    private void initializeAdapter() {
        PostAdapter adapter = new PostAdapter(postItems);
        rvpost.setAdapter(adapter);
    }

}

