package com.buaa.arvin.mobilemsg;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.buaa.arvin.mobilemsg.information.Hurd;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Mobile";
    private TextView manufacturer;
    private TextView model;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setValue();
    }

    public void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.drawer_navigation);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        mFab = (FloatingActionButton) findViewById(R.id.fab);

//        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
//        View view = layoutInflater.inflate(R.layout.drawer_header_layout, mNavigationView,true);
//        manufacturer = (TextView) view.findViewById(R.id.manufacturer);
//        model = (TextView) view.findViewById(R.id.model);

        View headerView = mNavigationView.getHeaderView(0);
        manufacturer = (TextView) headerView.findViewById(R.id.manufacturer);
        model = (TextView) headerView.findViewById(R.id.model);
    }

    public void setValue() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(mNavigationView.getMenu().findItem(R.id.drawer_system).getTitle().toString());
//        getSupportActionBar().setIcon(mNavigationView.getMenu().findItem(R.id.drawer_system).getIcon());

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                getSupportActionBar().setTitle(item.getTitle().toString());
//                getSupportActionBar().setIcon(item.getIcon());
                item.setChecked(true);
                clickItem(item);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        manufacturer.setText(Build.MANUFACTURER);
        model.setText(Build.MODEL);

        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

//        mFab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void clickItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.drawer_system:
//                    Log.d(TAG,CommonUtil.readFile());
                Log.d(TAG,
//                        SystemHelper.getOsVersion() + "\r\n" +
//                                SystemHelper.getBuildnumber() + "\r\n" +
//                                SystemHelper.getBootloader() + "\r\n" +
//                                SystemHelper.getSdkVersion() + "\r\n" +
//                                SystemHelper.getFingerprint() + "\r\n" +
//                                SystemHelper.getTimezone() + "\r\n" +
//                                SystemHelper.getDeviceUptime() + "\r\n" +
//                                SystemHelper.getVirtualMachine() + "\r\n" +
//                                SystemHelper.getVirtualMachineHeap() + "\r\n" +
//                                SystemHelper.checkForRoot() + "\r\n" +
//                                SystemHelper.checkForBusybox() + "\r\n" +
//                                SystemHelper.getRadio()
                                Hurd.context.getString(R.string.helper_available)
                );
                break;
            case R.id.drawer_device:
                break;
            case R.id.drawer_processor:
                break;
            case R.id.drawer_battery:
                break;
            case R.id.drawer_memory:
                break;
            case R.id.drawer_wifi:
                break;
            case R.id.drawer_more:
                break;
            case R.id.drawer_donate:
                break;
            case R.id.drawer_feedback:
                break;
            case R.id.drawer_setting:
                break;
            default:
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
