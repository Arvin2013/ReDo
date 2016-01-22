package com.buaa.arvin.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void click(View view) {
        Intent intent = new Intent(Main2Activity.this, Main22Activity.class);
        startActivity(intent);
    }

    public void choose(View view) {
        Intent intent = new Intent(Main2Activity.this, Main222Activity.class);
        startActivity(intent);
    }


}
