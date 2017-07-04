package amirahmed.com.mtlf4androidapplication.Fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import amirahmed.com.mtlf4androidapplication.Activities.FilterActivity;
import amirahmed.com.mtlf4androidapplication.Adapters.PostAdapter;
import amirahmed.com.mtlf4androidapplication.Models.PostItem;
import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Utils.TinyDB;

public class PostsFragment extends Fragment {

    public static List<PostItem> postItems;
    private RecyclerView rvpost;

    public static String count,countDisplay;

    int countPlus;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TinyDB tinydb = new TinyDB(getContext());

        count = tinydb.getString("count");

        countPlus = Integer.parseInt(count)+1;

        countDisplay = String.valueOf(countPlus);

        tinydb.putString("count",countDisplay);


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



        initializeData(tinydb);
        initializeAdapter();
    }


    private void initializeData(TinyDB tinydb) {
        postItems = new ArrayList<>();

        if(tinydb.getString("filter").equals("1"))
        {

            if(tinydb.getString("confirm").equals("confirm2"))
            {
                postItems.add(new PostItem(tinydb.getString("postname"), tinydb.getString("postdesc"),R.drawable.jeans,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            }

            postItems.add(new PostItem("عروض على ملابس الكاجوال الرجالى", "عند زيارتك للمحل ستحصل على خصم يصل الى 20%", R.drawable.offer,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("احدث صيحات الشباب", "عند زيارتك للمحل ستحصل على خصم يصل الى 20%", R.drawable.drawerpic,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("عروض مميذة على الجينز", "عند زيارتك للمحل ستحصل على خصم يصل الى 30%", R.drawable.jeans,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("قمصان رجالى بجميع المقاسات", "عند زيارتك للمحل ستحصل على خصم يصل الى 30%", R.drawable.omsaan,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));

        } else if(tinydb.getString("filter").equals("2"))
        {

            if(tinydb.getString("confirm").equals("confirm2"))
            {
                postItems.add(new PostItem(tinydb.getString("postname"), tinydb.getString("postdesc"),R.drawable.jeans,count,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            }
            postItems.add(new PostItem("جواكت من الجلود الطبيعية و يوجد جميع الالوان بأسعار منافسة", "عند زيارتك للمحل ستحصل على خصم يصل الى 15%", R.drawable.jackets,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("تيشرتات كاجوال شبابى بألوان مختلفة", "عند زيارتك للمحل ستحصل على خصم يصل الى 15%", R.drawable.clothes,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("جزم رجالى كلاسيكية لهواه الاناقة", "عند زيارتك للمحل ستحصل على خصم يصل الى 35%", R.drawable.shoes,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("احزية حريمى بأشكال مختلفة", "عند زيارتك للمحل ستحصل على خصم يصل الى 35%", R.drawable.shoeswomen,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("مستلزمات و اكسسوارات للمحجبات", "عند زيارتك للمحل ستحصل على خصم يصل الى 50%", R.drawable.hijab,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("ملابس شبابية للبنات العصريات", "عند زيارتك للمحل ستحصل على خصم يصل الى 50%", R.drawable.girls,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("قمصان رجالى بجميع المقاسات", "عند زيارتك للمحل ستحصل على خصم يصل الى 30%", R.drawable.omsaan,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));

        } else if(tinydb.getString("filter").equals("3"))
        {

            if(tinydb.getString("confirm").equals("confirm2"))
            {
                postItems.add(new PostItem(tinydb.getString("postname"), tinydb.getString("postdesc"),R.drawable.jeans,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            }
            postItems.add(new PostItem("جواكت من الجلود الطبيعية و يوجد جميع الالوان بأسعار منافسة", "عند زيارتك للمحل ستحصل على خصم يصل الى 15%", R.drawable.jackets,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("تيشرتات كاجوال شبابى بألوان مختلفة", "عند زيارتك للمحل ستحصل على خصم يصل الى 15%", R.drawable.clothes,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("جزم رجالى كلاسيكية لهواه الاناقة", "عند زيارتك للمحل ستحصل على خصم يصل الى 35%", R.drawable.shoes,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("قمصان رجالى بجميع المقاسات", "عند زيارتك للمحل ستحصل على خصم يصل الى 30%", R.drawable.omsaan,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));

        }else if(tinydb.getString("filter").equals("4"))
        {
            if(tinydb.getString("confirm").equals("confirm2"))
            {
                postItems.add(new PostItem(tinydb.getString("postname"), tinydb.getString("postdesc"),R.drawable.jeans,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            }
            postItems.add(new PostItem("عروض على ملابس الكاجوال الرجالى", "عند زيارتك للمحل ستحصل على خصم يصل الى 20%", R.drawable.offer,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("احدث صيحات الشباب", "عند زيارتك للمحل ستحصل على خصم يصل الى 20%", R.drawable.drawerpic,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("عروض مميذة على الجينز", "عند زيارتك للمحل ستحصل على خصم يصل الى 30%", R.drawable.jeans,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("قمصان رجالى بجميع المقاسات", "عند زيارتك للمحل ستحصل على خصم يصل الى 30%", R.drawable.omsaan,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("مستلزمات و اكسسوارات للمحجبات", "عند زيارتك للمحل ستحصل على خصم يصل الى 50%", R.drawable.hijab,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("ملابس شبابية للبنات العصريات", "عند زيارتك للمحل ستحصل على خصم يصل الى 50%", R.drawable.girls,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));

        } else
        {
            if(tinydb.getString("confirm").equals("confirm2"))
            {
                postItems.add(new PostItem(tinydb.getString("postname"), tinydb.getString("postdesc"),R.drawable.jeans,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            }
            postItems.add(new PostItem("عروض على ملابس الكاجوال الرجالى", "عند زيارتك للمحل ستحصل على خصم يصل الى 20%", R.drawable.offer,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("احدث صيحات الشباب", "عند زيارتك للمحل ستحصل على خصم يصل الى 20%", R.drawable.drawerpic,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("عروض مميذة على الجينز", "عند زيارتك للمحل ستحصل على خصم يصل الى 30%", R.drawable.jeans,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("قمصان رجالى بجميع المقاسات", "عند زيارتك للمحل ستحصل على خصم يصل الى 30%", R.drawable.omsaan,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("جواكت من الجلود الطبيعية و يوجد جميع الالوان بأسعار منافسة", "عند زيارتك للمحل ستحصل على خصم يصل الى 15%", R.drawable.jackets,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("تيشرتات كاجوال شبابى بألوان مختلفة", "عند زيارتك للمحل ستحصل على خصم يصل الى 15%", R.drawable.clothes,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("جزم رجالى كلاسيكية لهواه الاناقة", "عند زيارتك للمحل ستحصل على خصم يصل الى 35%", R.drawable.shoes,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("احزية حريمى بأشكال مختلفة", "عند زيارتك للمحل ستحصل على خصم يصل الى 35%", R.drawable.shoeswomen,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("مستلزمات و اكسسوارات للمحجبات", "عند زيارتك للمحل ستحصل على خصم يصل الى 50%", R.drawable.hijab,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
            postItems.add(new PostItem("ملابس شبابية للبنات العصريات", "عند زيارتك للمحل ستحصل على خصم يصل الى 50%", R.drawable.girls,countDisplay,tinydb.getBoolean("valuefav"),tinydb.getBoolean("valuelike")));
        }

    }

    private void initializeAdapter() {
        PostAdapter adapter = new PostAdapter(postItems);
        rvpost.setAdapter(adapter);
    }

    public Bitmap getBitmapImage(String string)
    {
        byte[] imageBytes = Base64.decode(string, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        return decodedImage;
    }

}

