package com.buaa.arvin.mobilemsg.hurd.information;

import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import com.buaa.arvin.mobilemsg.R;
import com.buaa.arvin.mobilemsg.hurd.utils.RootUtils;
import com.buaa.arvin.mobilemsg.information.Hurd;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangmu on 2015/12/31.
 */
public class SystemHelper {

    private static FingerprintManager fingerprintManager;
    private static PackageManager packageManager;
    private static TelephonyManager telephonyManager;

    public static void funArray(){
        String[] array = {"getOsVersion","getIdentifierId","getIdentifierImei","getIdentifierImsi","getIdentifierSerial","getIdentifierSimSerial","getManufacturer","getModel","getBuildnumber","getBaseOs","getBootloader","getRadio","getSdkVersion","getFingerprint","getTimezone","getDeviceUptime","getSecurityPatch","getVirtualMachine","getVirtualMachineHeap","getCodename","checkForFingerprint","checkForRoot","checkSimState","checkForBusybox"};

    }
    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }
    public static String getIdentifierId(){
        return Settings.Secure.getString(Hurd.context.getContentResolver(),"android_id");
    }
    public static String getIdentifierImei(){
        if (!checkSimState())
            return telephonyManager.getDeviceId();
        return Hurd.errodCode;
    }
    public static String getIdentifierImsi(){
        if (!checkSimState())
            return telephonyManager.getSubscriberId();
        return Hurd.errodCode;
    }
    public static String getIdentifierSerial(){
        if (!checkSimState())
            return Build.SERIAL;
        return Hurd.errodCode;
    }
    public static String getIdentifierSimSerial(){
        if (!checkSimState())
            return telephonyManager.getSimSerialNumber();
        return Hurd.errodCode;
    }

    public static String getManufacturer(){
        return Build.MANUFACTURER;
    }
    public static String getModel(){
        return Build.MODEL;
    }
    public static String getBuildnumber() {
        return Build.ID;
    }

    public static  String getBaseOs(){
        return Build.VERSION.BASE_OS;
    }
    public static String getBootloader() {
        return Build.BOOTLOADER;
    }

    public static String getRadio(){
        if(!checkSimState()){
            return Build.getRadioVersion();
        }
        return Hurd.errodCode;
    }

    public static String getSdkVersion() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public static String getFingerprint() {
        return Build.FINGERPRINT;
    }

    public static String getTimezone() {
        return Calendar.getInstance().getTimeZone().getDisplayName();
    }

    public static String getDeviceUptime() {
//        String temp;
        long l1 = SystemClock.elapsedRealtime();
        long l2 = TimeUnit.MILLISECONDS.toDays(l1);
        long l3 = TimeUnit.MILLISECONDS.toHours(l1) - 24L * l2;
        long l4 = TimeUnit.MILLISECONDS.toMinutes(l1) - 60L * TimeUnit.MILLISECONDS.toHours(l1);
        long l5 = TimeUnit.MILLISECONDS.toSeconds(l1) - 60L * TimeUnit.MILLISECONDS.toMinutes(l1);
//        if (l4<10 && l4>0){
//            temp = "0"+l4;
//        }
//        temp = l4+"";
        return l4 > 0 && l4 < 10 ? l2 + "天，" + l3 + ":0" + l4 + ":" + l5 : l2 + "天，" + l3 + ":" + l4 + ":" + l5;
//        return l2 + "天，" + l3 + ":" + l4 + ":" + l5;
    }

    public static String getSecurityPatch(){

        return Build.VERSION.SECURITY_PATCH;
    }
    public static String getVirtualMachine() {
        String str = System.getProperty("java.vm.version");
        if (str.startsWith("2"))
            return "ART" + str;
        return "Dalvik " + str;
    }

    public static String getVirtualMachineHeap() {
        long l = Runtime.getRuntime().maxMemory();
        return Long.toString(l / 1048576L) + " MB";
    }

    public static String getCodename(){
        return Build.DEVICE;
    }
    public static String checkForFingerprint() {
        if (Build.VERSION.SDK_INT >= 23)
        {
            if (fingerprintManager.isHardwareDetected())
                return Hurd.context.getString(R.string.helper_supported);
            return Hurd.context.getString(R.string.helper_unsupported);
        }
        return Hurd.context.getString(R.string.helper_unavailable);
    }

    public static String checkForRoot() {
        if (RootUtils.isRootAvailable())
            return Hurd.context.getString(R.string.helper_available);
        return Hurd.context.getString(R.string.helper_unavailable);
    }

    public static boolean checkSimState() {
        boolean bool = packageManager.hasSystemFeature("android.hardware.telephony");
        int i = telephonyManager.getSimState();
        return (!bool) || (i == 1);
    }

    public static  String checkForBusybox(){
        if (RootUtils.isBusyBoxAvailable())
            return Hurd.context.getString(R.string.helper_available);
        return Hurd.context.getString(R.string.helper_unavailable);
    }


    public static void init(){
        telephonyManager = (TelephonyManager) Hurd.context.getSystemService("phone");
        if (Build.VERSION.SDK_INT >= 23){
            fingerprintManager = (FingerprintManager) Hurd.context.getSystemService("fingerprint");
        }
        packageManager = Hurd.context.getPackageManager();
    }
}
