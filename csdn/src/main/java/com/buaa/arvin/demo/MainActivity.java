package com.buaa.arvin.demo;

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

import com.buaa.arvin.demo.util.CommonUtil;

public class MainActivity extends AppCompatActivity {

    public String TAG = "MainAc";

    private int navigationItemId;

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private FloatingActionButton mFab;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreat");

        initView();
        viewConfig();

    }

    /**
     * 初始化各种控件
     */
    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.drawer_navigation);
        mTextView = (TextView) findViewById(R.id.content_view);
    }
    /**
     * 各类控件取值,赋值
     */
    private void viewConfig() {
        //ToolBar
        setSupportActionBar(mToolbar);
        //navigation
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mTextView.setText(menuItem.getTitle());
                menuItem.setChecked(true);
                actionNavigation(menuItem);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        //添加ToolBar左变那个“三”图案
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

        //浮动按钮
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtil.Go2AnotherActivity(MainActivity.this,FabButtonActivity.class);
            }
        });
    }

    /**
     * Navigation'MenuItem 操作
     * @param menuItem
     */
    private void actionNavigation(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.drawer_apps:
                //显示子Item
                setItemInvisible(R.id.drawer_myapps,true);
                setItemInvisible(R.id.drawer_mymusic,false);
                break;
            case R.id.drawer_entertainment:
                //隐藏
                setItemInvisible(R.id.drawer_myapps,false);
                setItemInvisible(R.id.drawer_mymusic,false);
                break;
            case R.id.drawer_music:
                //隐藏
                setItemInvisible(R.id.drawer_mymusic,true);
                setItemInvisible(R.id.drawer_myapps, false);
                break;
            case R.id.feedback:
                //隐藏
                setItemInvisible(R.id.drawer_myapps,false);
                setItemInvisible(R.id.drawer_mymusic,false);
                break;
            default:
                break;
        }
    }

    /**
     * 设置隐藏的Item 显示与再次隐藏
     * @param value
     */
    private void setItemInvisible(int navigationItemId,boolean value){
        mNavigationView.getMenu().findItem(navigationItemId).setVisible(value);
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
        // as you specify a parent activity in AndroidManifest.xml
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onPostResume() {
        Log.d(TAG, "onPostResume");
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart");
        super.onRestart();
    }
}
