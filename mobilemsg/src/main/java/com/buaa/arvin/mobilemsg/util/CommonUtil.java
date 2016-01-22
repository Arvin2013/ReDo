package com.buaa.arvin.mobilemsg.util;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.buaa.arvin.mobilemsg.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.TimeZone;


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

    public static void Go2AnotherActivity(Context context, Class cls) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        context.startActivity(intent);
//        mFab.show();
    }

    /**
     * 读取系统手机属性
     *
     * @return
     */
    public static String readFile() {
        //System
        String osVersion = Build.VERSION.RELEASE;//操作系统版本号
        String buildNumber = getProp("ro.build.id", null);//
        String bootLoader = Build.BOOTLOADER;//系统启动加载
        String sdkVersion = Build.VERSION.SDK;
        String fingerprint = Build.FINGERPRINT;
        //显示为shanghai，
        //中国标准时间
        //要实现中国标准时间，放置一个xml文件进行解析，配置<zone id="Asia/Shanghai">中国标准时间</zone>
        String timeZone = TimeZone.getDefault().getID();
        String uptime = android.os.SystemClock.uptimeMillis() + "";//系统运行时间毫秒数
        String time = getIntervalUpdateTime(android.os.SystemClock.uptimeMillis());//uptime由毫秒数转换为几天几小时几分几秒
        //从毫秒数转换为年月日
//        GregorianCalendar gc = new GregorianCalendar();
//        gc.setTimeInMillis(android.os.SystemClock.uptimeMillis());
//        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String time = format.format(gc.getTime());
        //虚拟机实现名称、版本
        String vmVersion = System.getProperties().getProperty("java.vm.name") + " " + System.getProperties().getProperty("java.vm.version");
        String vmHeap = getProp("dalvik.vm.heapsize", null);
        String root = null;//Available
        String busybox = null;//Available
        String radioModule = null;//Unavailable
        String kernelVsersion = getKernelVersion();
        String baseband = getProp("gsm.version.baseband", null);//基带版本
        String innerband = getInnerband();

        //Device
        //1.Device Information
        String model = Build.MODEL;
        String codename = Build.VERSION.CODENAME;
        String manufacturer = Build.MANUFACTURER;
        //2.Identifiers
//        TelephonyManager tm = (TelephonyManager)MyApplication.getInstance().getSystemService(Context.TELEPHONY_SERVICE);
//        String deviceId = tm.getDeviceId();//f2a585f4a5efbee
        //3.display
        String resolution = null;//1920x1080 pixels
        String frameRate = null;//60hz
        String densitySize = null;//xxhdpi
        return osVersion + "\r\n" +
                buildNumber + "\r\n" +
                bootLoader + "\r\n" +
                sdkVersion + "\r\n" +
                fingerprint + "\r\n" +
                timeZone + "\r\n" +
                uptime + "\r\n" +
                time + "\r\n" +
                vmVersion + "\r\n" +
                vmHeap + "\r\n" +
                root + "\r\n" +
                busybox + "\r\n" +
                radioModule + "\r\n" +
                kernelVsersion + "\r\n" +
                baseband + "\r\n" +
                innerband+ "\r\n" +
                model+ "\r\n" +
                codename+ "\r\n" +
                manufacturer+ "\r\n" +
//                deviceId+ "\r\n" +
                resolution+ "\r\n" +
                frameRate+ "\r\n" +
                densitySize;
    }

    /**
     * 利用反射获取系统 android.os.SystemProperties
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getProp(String key, String defaultValue) {
        String value = defaultValue;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            value = (String) get.invoke(c, key, "unknow");
        } catch (Exception e) {
            Log.d("CommonUtil", e.getMessage());
            e.printStackTrace();
        }
        Log.d("", key + "=" + value);
        return value;
    }

    /**
     * 获取Android 内核版本信息
     *
     * @return
     */
    public static String getKernelVersion() {
        Process process = null;
        String mKernel = null;
        try {
            process = Runtime.getRuntime().exec("cat /proc/version");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //get the output line
        InputStream inputStream = process.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 8 * 1024);
        //get the whole standard output string
        String result = "";
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
                //reult += "\n"
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result != "") {
            String keyWord = "version";
            int index = result.indexOf(keyWord);
            Log.d("Mobile", "-----" + result);
            line = result.substring(index + keyWord.length());
            index = line.indexOf("");
            //
            mKernel = line.substring(0, index);
            Log.d("Moblie", "-----" + mKernel);
        }
        return result;
    }

    /**
     * 获取内部版本
     *
     * @return
     */
    public static String getInnerband() {
        String version = "";
        if (Build.DISPLAY.contains(Build.VERSION.INCREMENTAL)) {
            version = Build.DISPLAY;
        } else {
            version = Build.VERSION.INCREMENTAL;
        }
        return version;
    }

    public static String change(Long mills) {

        return null;
    }

    /**
     * 将毫秒数转换为几天几小时几分几秒
     *
     * @param intervalTime
     * @return
     */
    public static String getIntervalUpdateTime(long intervalTime) {
        StringBuilder result = new StringBuilder();
        long interval = intervalTime / 1000;
        final long day = 24 * 60 * 60;
        final long hour = 60 * 60;
        final long minute = 60;
        int detailDay = 0;
        int detailHour = 0;
        int detailMinute = 0;
        int detailSecond = 0;
        if (interval >= day) {
            detailDay = (int) (interval / day);
            interval = interval - detailDay * day;
        }
        if (interval >= hour) {
            detailHour = (int) (interval / hour);
            interval = interval - hour * detailHour;
        }
        if (interval >= minute) {
            detailMinute = (int) (interval / minute);
            interval = interval - detailMinute * minute;
        }
        if (interval > 0) {
            detailSecond = (int) interval;
        }
        result.setLength(0);
        if (detailDay > 0) {
            result.append(detailDay);
            result.append("天");
        }
        if (detailHour > 0) {
            result.append(detailHour);
            result.append("小时");
        }
        if (detailMinute > 0) {
            result.append(detailMinute);
            result.append("分");
        }
        if (detailSecond > 0) {
            result.append(detailSecond);
            result.append("秒");
        }
        return result.toString();
    }

    static class  MyApplication extends Application{
        private static MyApplication instance;

        @Override
        public void onCreate() {
            super.onCreate();
            instance = this;
        }
        public static MyApplication getInstance(){
            return instance;
        }
    }
}
