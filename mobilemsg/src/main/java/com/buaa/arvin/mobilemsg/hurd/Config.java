package com.buaa.arvin.mobilemsg.hurd;

/**
 * Created by yangmu on 2016/1/11.
 */
public class Config {
    public static final String CPU0_CUR_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
    public static final String CPU1_CUR_FREQ = "/sys/devices/system/cpu/cpu1/cpufreq/scaling_cur_freq";
    public static final String CPU2_CUR_FREQ = "/sys/devices/system/cpu/cpu2/cpufreq/scaling_cur_freq";
    public static final String CPU3_CUR_FREQ = "sys/devices/system/cpu/cpu3/cpufreq/scaling_cur_freq";
    public static final String CPU_INFO = "/proc/cpuinfo";
    public static final String CPU_MAX_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_max_freq";
    public static final String CPU_MIN_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_min_freq";
    public static final String CPU_TEMP_ZONE0 = "/sys/class/thermal/thermal_zone0/temp";
    public static final String CPU_TEMP_ZONE1 = "/sys/class/thermal/thermal_zone1/temp";
    public static final String CPU_USAGE = "/sys/devices/system/cpu/cpu0/cpufreq/cpu_utilization";
    public static final String GOV_AVAILABLE = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_avaliable_governors";
    public static final String GOV_CURRENT = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_governor";
    public static final String[] GPU_CUR_FREQ = {"/sys/class/kgsl/kgsl-3d0/gpuclk", "/sys/devices/platform/omap/pvrsrvkm.0/sgx_fck_rate", "/proc/gpu/cur_rate", "/sys/devices/platform/kgsl-2d0.0/kgsl/kgsl-2d0/gpuclk", "/sys/devices/platform/kgsl-3d0.0/kgsl/kgsl-3d0/gpuclk", "/sys/devices/fdb00000.qcom,kgsl-3d0/kgsl/kgsl-3d0/gpuclk", "/sys/devices/fdc00000.qcom,kgsl-3d0/kgsl/kgsl-3d0/gpuclk", "/sys/devices/platform/omap/pvrsrvkm.0/sgxfreq/frequency"};
    public static final String[] GPU_MAX_FREQ = {"/sys/devices/platform/kgsl-2d0.0/kgsl/kgsl-2d0/max_gpuclk", "/sys/devices/platform/kgsl-3d0.0/kgsl/kgsl-3d0/max_gpuclk", "/sys/devices/fdb00000.qcom,kgsl-3d0/kgsl/kgsl-3d0/max_gpuclk", "/sys/devices/fdc00000.qcom,kgsl-3d0/kgsl/kgsl-3d0/max_gpuclk", "/sys/devices/soc.0/1c00000.qcom,kgsl-3d0/kgsl/kgsl-3d0/max_gpuclk", "/sys/devices/platform/omap/pvrsrvkm.0/sgxfreq/frequency_limit"};
    public static final String[] IO_AVALIABLE = {"/sys/block/mmcblk0/queue/scheduler", "/sys/block/mmcblk1/queue/scheduler", "/sys/block/mmcblk0rpmb/queue/scheduler"};
    public static final String KERNEL_INFO = "/proc/version";
    public static final String MEM_INFO = "/proc/meminfo";
    public static final String[] ROOT_AND_BUSYBOX = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};

    public static String getCorePath(int paramInt) {
        return "/sys/devices/system/cpu/cpu" + paramInt + "/cpufreq/scaling_cur_freq";
    }

}
