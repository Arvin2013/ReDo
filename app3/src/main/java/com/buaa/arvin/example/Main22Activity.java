package com.buaa.arvin.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Main22Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_weixin_top_right);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }

    public void tip (View view){
        Toast.makeText(Main22Activity.this, "ssdfs", Toast.LENGTH_SHORT).show();
    }

}
