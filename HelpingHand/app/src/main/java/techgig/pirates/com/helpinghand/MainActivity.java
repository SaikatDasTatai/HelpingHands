package techgig.pirates.com.helpinghand;

import android.content.Intent;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import techgig.pirates.com.helpinghand.fragments.LocationSearchFragment;
import techgig.pirates.com.helpinghand.fragments.dummy.DummyContent;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,LocationSearchFragment.OnListFragmentInteractionListener{
Button mSearchButton ;
ProgressBar mSearchProgress;
FrameLayout mSearchResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initializeLayoutVariables();
        setupEventListeners();

    }
   private final long DELAYED_SECONDS =3000;
    private void setupEventListeners() {
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchResult.setVisibility(View.GONE);
                mSearchProgress.setVisibility(View.VISIBLE);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {

                     mSearchResult.setVisibility(View.VISIBLE);
                     setupLocationFragment();
                     mSearchProgress.setVisibility(View.GONE);
                    }
                }, DELAYED_SECONDS);
            }
        });
    }

    private void initializeLayoutVariables() {
        mSearchButton = findViewById(R.id.searchButton);
        mSearchProgress = findViewById(R.id.requestBar);
        mSearchResult = findViewById(R.id.hhframelayout);

    }

    private void setupLocationFragment(){
        LocationSearchFragment myf = new LocationSearchFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.hhframelayout, myf);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startInternalActivity(ProfileActivity.class);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_blood) {
            startInternalActivity(MainActivity.class);

        }  else if (id == R.id.nav_manage) {
            startInternalActivity(ProfileActivity.class);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void startInternalActivity(Class mainActivityClass) {
        Intent newactivity = new Intent(getApplicationContext(),mainActivityClass);
        startActivity(newactivity);

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
