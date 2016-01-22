package com.buaa.arvin.mobilemsg.information;

import android.content.Context;

import com.buaa.arvin.mobilemsg.R;
import com.buaa.arvin.mobilemsg.hurd.information.SystemHelper;

/**
 * Created by yangmu on 2015/12/31.
 */
public class Hurd {
    public static final long GB = 1073741824L;
    public static final long MB = 1048576L;
    public static String TAG = "Hurd";
    public static Context context;
    public static String errodCode;
    public static String cpuStopped;

    public static void  prepareInformation(Context paramContext){
        context = paramContext;
        errodCode = paramContext.getString(R.string.helper_unavailable);
        cpuStopped = paramContext.getString(R.string.cpu_cores_stopped);
        SystemHelper.init();
    }
}
