package com.buaa.arvin.mobilemsg.hurd.information;

import android.content.Intent;

import com.buaa.arvin.mobilemsg.R;
import com.buaa.arvin.mobilemsg.information.Hurd;

/**
 * Created by yangmu on 2016/1/8.
 */
public class BatteryHelper {

    public static String getChargeLevel(Intent paramIntent){
        return Integer.toString(paramIntent.getIntExtra("level",0))+"%";
    }

    public static String getChargeSource(Intent paramIntent){
        switch (paramIntent.getIntExtra("plugged",1)){
            case 3:
                break;
            case 2:
                return Hurd.context.getString(R.string.hello_blank_fragment);
        }
        return "";
    }


}
