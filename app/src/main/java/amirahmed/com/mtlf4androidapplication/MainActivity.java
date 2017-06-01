package amirahmed.com.mtlf4androidapplication;

import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import amirahmed.com.mtlf4androidapplication.Activities.AddPost1;
import amirahmed.com.mtlf4androidapplication.Activities.FavoritesActivity;
import amirahmed.com.mtlf4androidapplication.Activities.MyProfileActivity;
import amirahmed.com.mtlf4androidapplication.Activities.StatsticsActivity;
import amirahmed.com.mtlf4androidapplication.Fragments.MainHomeFragment;
import amirahmed.com.mtlf4androidapplication.Fragments.NavigationFragment;
import amirahmed.com.mtlf4androidapplication.Fragments.PostsFragment;
import amirahmed.com.mtlf4androidapplication.Fragments.ShopsFragment;
import amirahmed.com.mtlf4androidapplication.Utils.NavigationDrawerCallbacks;


public class MainActivity extends AppCompatActivity implements NavigationDrawerCallbacks {


    private DrawerLayout dl;
    private NavigationFragment drawerFragment;
    private Toolbar mToolbar;
    private TabLayout tabLayout;
    private ActionBarDrawerToggle mDrawerToggle;


    ImageView img2;
    TextView midname;


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setLogo(R.drawable.mainlogo);

        midname = (TextView) findViewById(R.id.midname);
        img2 = (ImageView) findViewById(R.id.imgcatenotification);

        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , AddPost1.class);
                startActivity(intent);
            }
        });

        final SharedPreferences mypref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        final String userID = (mypref.getString("KeyID","1"));


        if(userID.equals("1"))
        {
            midname.setText("المفضلة");
            img2.setImageResource(R.drawable.ic_favorite_black_24dp);
            fab.setVisibility(View.GONE);
        }else if (userID.equals("2"))
        {
            midname.setText("الاحصائيات");
            img2.setImageResource(R.drawable.ic_timeline_black_24dp);
            fab.setVisibility(View.VISIBLE);
        }


        drawerFragment = (NavigationFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
        dl = (DrawerLayout) findViewById(R.id.drawer);
        drawerFragment.setUpDrawer(R.id.fragment_drawer, dl, mToolbar);



        mDrawerToggle = new ActionBarDrawerToggle(this, dl, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);


                invalidateOptionsMenu();
            }
        };

        dl.setDrawerListener(mDrawerToggle);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        viewPager.setCurrentItem(1);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        ImageView img = (ImageView) findViewById(R.id.imgcateprofile);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , MyProfileActivity.class);
                startActivity(intent);
            }
        });


        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userID.equals("1"))
                {
                    Intent intent = new Intent(MainActivity.this , FavoritesActivity.class);
                    startActivity(intent);
                }else if(userID.equals("2"))
                {
                    Intent intent = new Intent(MainActivity.this , StatsticsActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    private static View getToolbarLogoView(Toolbar mToolbar) {

        //check if contentDescription previously was set
        boolean hadContentDescription = android.text.TextUtils.isEmpty(mToolbar.getLogoDescription());
        String contentDescription = String.valueOf(!hadContentDescription ? mToolbar.getLogoDescription() : "logoContentDescription");
        mToolbar.setLogoDescription(contentDescription);
        ArrayList<View> potentialViews = new ArrayList<View>();
        //find the view based on it's content description, set programatically or with android:contentDescription
        mToolbar.findViewsWithText(potentialViews,contentDescription, View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
        //Nav icon is always instantiated at this point because calling setLogoDescription ensures its existence
        View logoIcon = null;
        if(potentialViews.size() > 0){
            logoIcon = potentialViews.get(0);
        }
        //Clear content description if not previously present
        if(hadContentDescription)
            mToolbar.setLogoDescription(null);
        return logoIcon;

    }

    // Navigation Drawer Navigation Method
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments


    }



    @Override
    public void onBackPressed() {
        if (dl.isDrawerOpen(GravityCompat.START))
            dl.closeDrawer(GravityCompat.START);
        else
        {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ShopsFragment(), "");
        adapter.addFragment(new MainHomeFragment(), "");
        adapter.addFragment(new PostsFragment(), "");
        adapter.notifyDataSetChanged();
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tabLayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }

        Typeface type = Typeface.createFromAsset(this.getAssets(),"fonts/HacenTunisiaBold.ttf");

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(R.string.shops);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_add_shopping_cart_white_24dp, 0);
        tabLayout.getTabAt(2).setCustomView(tabOne);

        tabOne.setTypeface(type);

        TextView  tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText(R.string.mainHome);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_home_white_24dp, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);
        tabLayout.setAnimation(new AlphaAnimation(Animation.ABSOLUTE, Animation.RELATIVE_TO_PARENT));

        tabTwo.setTypeface(type);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText(R.string.offers);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_loyalty_white_24dp, 0);
        tabLayout.getTabAt(0).setCustomView(tabThree);

        tabThree.setTypeface(type);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
