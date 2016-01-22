package com.buaa.arvin.demo.util;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.buaa.arvin.demo.R;

/**
 * Created by yangmu on 2015/12/14.
 */
public class CommonUtil {

    private static FloatingActionButton mFab;

    public static void toast(Context context, String showContent, int showTime/*LENGTH_SHORT = 0,LENGTH_LONG = 1*/) {
        Toast.makeText(context, showContent, showTime).show();
    }

    public static void show(View view, final String msg, int showTime/*LENGTH_SHORT = -1,LENGTH_LONG = 0*/) {
        final Snackbar mSnackbar;
        mSnackbar = Snackbar.make(view, msg, showTime);
        mSnackbar.setAction(R.string.close, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSnackbar.dismiss();
            }
        }).show();
    }

    public static void Go2AnotherActivity(Context context,Class cls){
        Intent intent = new Intent();
        intent.setClass(context,cls);
        context.startActivity(intent);
//        mFab.show();
    }

}
