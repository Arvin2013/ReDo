//package com.buaa.arvin.mobilemsg.hurd.information;
//
//import android.os.Environment;
//import android.os.StatFs;
//
//import java.text.DecimalFormat;
//
///**
// * Created by yangmu on 2016/1/8.
// */
//public class MemoryHelper {
//
//    private static long externalAvailable;
//    private static long externalTotal;
//    private static String gigaBytes;
//    private static long internalAvailable;
//    private static long internalTotal;
//    private static String megaBytes;
//    private static long ramAvailable;
//    private static long ramTotal;
//
//    public static String getExternalAvailable(){
//        return ;
//    }
//
//    public static String getToolsInternalAvailable(){
//        StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
//        return setGigabyteForm(localStatFs.getBlockSize() * localStatFs.getAvailableBlocks()/1073741824.0D);
//    }
//
//    public static String setGigabyteForm(double paramDouble){
//        return new DecimalFormat("0.00").format(paramDouble);
//    }
//
//}
