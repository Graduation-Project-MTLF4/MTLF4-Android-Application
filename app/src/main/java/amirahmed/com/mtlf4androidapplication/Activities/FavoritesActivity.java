package amirahmed.com.mtlf4androidapplication.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import amirahmed.com.mtlf4androidapplication.Adapters.FavoritesAdapter;
import amirahmed.com.mtlf4androidapplication.Models.PostItem;
import amirahmed.com.mtlf4androidapplication.R;

public class FavoritesActivity extends AppCompatActivity {

    public static List<PostItem> postItems2 = new ArrayList<>();
    private RecyclerView rvpost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_favorites);

        rvpost = (RecyclerView) findViewById(R.id.rvpost);

        rvpost.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvpost.setLayoutManager(llm);

        //initializeData();
        initializeAdapter();

    }

    /*private void initializeData() {
        postItems2 = new ArrayList<>();
        //postItems2.add(new PostItem("عروض على ملابس الكاجوال", "عند زيارتك للمحل ستحصل على خصم يصل الى 20%", R.drawable.offer,true));
        //postItems2.add(new PostItem("عروض على ملابس الكاجوال", "عند زيارتك للمحل ستحصل على خصم يصل الى 20%", R.drawable.drawerpic,false));
    }*/

    private void initializeAdapter() {
        FavoritesAdapter adapter = new FavoritesAdapter(postItems2);
        rvpost.setAdapter(adapter);
    }
}
