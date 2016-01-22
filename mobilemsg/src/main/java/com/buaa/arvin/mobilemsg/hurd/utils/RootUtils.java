package com.buaa.arvin.mobilemsg.hurd.utils;

import com.buaa.arvin.mobilemsg.hurd.Config;

import java.io.File;

/**
 * Created by yangmu on 2016/1/12.
 */
public class RootUtils {
    private static final String KEY_BUSYBOX = "busybox";
    private static final String KEY_SU = "su";

    private static boolean doesFileExists(String paramString) {
        boolean bool = false;
        String[] arrayOfString = Config.ROOT_AND_BUSYBOX;
        int i = arrayOfString.length;
        for (int j = 0; ; j++) {
            if (j < i) {
                String str = arrayOfString[j];
                bool = new File(str + "/" + paramString).exists();
                if (!bool) ;
            } else {
                return bool;
            }
        }
    }

    public static boolean isBusyBoxAvailable(){
        return doesFileExists("busybox");
    }

    public static boolean isRootAvailable(){
        return doesFileExists("su");
    }
}
