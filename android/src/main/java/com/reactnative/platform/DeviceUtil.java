package com.reactnative.platform;

import android.os.Build;

public class DeviceUtil {

    public static boolean isHuawei() {
        return Build.BRAND.toLowerCase().equals("huawei") || Build.BRAND.toLowerCase().equals("honor");
    }

    public static boolean isXiaomi() {
        return Build.BRAND.toLowerCase().equals("xiaomi");
    }

    public static boolean isOppo() {
        return Build.BRAND.toLowerCase().equals("oppo");
    }

    public static boolean isVivo() {
        return Build.BRAND.toLowerCase().equals("vivo") || Build.BRAND.contains("bbk");
    }

    public static boolean isMeizu() {
        return Build.BRAND.toLowerCase().equals("meizu");
    }

    public static boolean isSamsung() {
        return Build.BRAND.toLowerCase().equals("samsung");
    }


    public static boolean isLeTV() {
        return Build.BRAND.toLowerCase().equals("letv");
    }

    public static boolean isSmartisan() {
        return Build.BRAND.toLowerCase().equals("smartisan");
    }

    public static boolean isEmulator() {
        return Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT);
    }

}
