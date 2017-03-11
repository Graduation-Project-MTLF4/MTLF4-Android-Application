package amirahmed.com.mtlf4androidapplication.Fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import amirahmed.com.mtlf4androidapplication.Adapters.ParentAdapter;
import amirahmed.com.mtlf4androidapplication.Models.ChildList;
import amirahmed.com.mtlf4androidapplication.Models.ParentList;
import amirahmed.com.mtlf4androidapplication.R;

public class NavigationFragment extends Fragment {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;


    //variables
    private RecyclerView mRecyclerView;
    private ParentAdapter mAdapter;
    private List<ParentList> parentLists;



    //private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    //private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    //private boolean mUserLearnedDrawer;
    //private int mCurrentSelectedPosition = 0;
    //private boolean mFromSavedInstanceState;
    //private View mFragmentContainerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }*/
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.drawerList);
        getGenres();
        mAdapter = new ParentAdapter(parentLists);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);

        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, R.string.drawer_open, R.string.drawer_close);

    }





    public void setUpDrawer(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) return;
                /*if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
                    sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
                }

               getActivity().invalidateOptionsMenu();*/
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (!isAdded()) return;
               //getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                // Do something of Slide of Drawer
            }
        };
        // this drawer layout is linked with ActionBarDrawerToggle
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // sync the state of Navigation Drawer with the help of Runnable
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });


       /* if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(mFragmentContainerView);
        }


        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });*/

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    public ActionBarDrawerToggle getActionBarDrawerToggle() {

        return mDrawerToggle;
    }

    /*@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Forward the new configuration the drawer toggle component.
        mDrawerToggle.onConfigurationChanged(newConfig);
    }*/



    public void getGenres() {
        parentLists = new ArrayList<>();
        //List<ChildList> artists = new ArrayList<>(3);
        List<ChildList> artists2 = new ArrayList<>(3);
        List<ChildList> artists3 = new ArrayList<>(3);

        parentLists.add(new ParentList("تسجيل الدخول", null,R.color.trans));
        parentLists.add(new ParentList("مستخدم جديد", null,R.color.trans));
        parentLists.add(new ParentList("حسابى", null,R.color.trans));
        parentLists.add(new ParentList("الازياء الرجالى", artists2,R.drawable.man));
        parentLists.add(new ParentList("الازياء الحريمى", artists3,R.drawable.rsz_woman));


        artists2.add(new ChildList("الملابس الرجالى",getResources().getDrawable(R.drawable.man)));
        artists2.add(new ChildList("الاحزية الرجالى",getResources().getDrawable(R.drawable.man)));
        artists2.add(new ChildList("مشاهدة الكل",null));

        artists3.add(new ChildList("الملابس الحريمى",getResources().getDrawable(R.drawable.rsz_woman)));
        artists3.add(new ChildList("الاحزية الحريمى",getResources().getDrawable(R.drawable.rsz_woman)));
        artists3.add(new ChildList("مشاهدة الكل",null));

    }

}
