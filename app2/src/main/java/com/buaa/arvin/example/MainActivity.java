package com.buaa.arvin.example;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.buaa.arvin.zlistview.R;
import com.buaa.arvin.zlistview.widget.ZListView;

public class MainActivity extends AppCompatActivity {

    private ZListView listView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTbAndFab();

        listView = (ZListView) findViewById(R.id.listview);
        listView.setAdapter(new ListViewAdapter(this));

        listView.setXListViewListener(new ZListView.IXListViewListener() {

            @Override
            public void onRefresh() {

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        listView.stopRefresh();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        listView.stopLoadMore();
                    }
                }, 1000);

            }
        });
        listView.setPullLoadEnable(true);
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

    public void initTbAndFab() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
