package com.reactnative.platform;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;

// 感谢：https://juejin.im/post/5dfaeccbf265da33910a441d
public class BatteryOptimizationSettings {

    // 判断我们的应用是否在系统白名单中
    public static boolean isIgnoringBatteryOptimizations(Context context) {
        boolean isIgnoring = true;
        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (powerManager != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            isIgnoring = powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
        }
        return isIgnoring;
    }

    // 申请加入系统白名单
    public static void requestIgnoreBatteryOptimizations(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Intent intent = new Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 打开小米省电策略配置页面
    public static void openBatteryStrategySettings(Context context) throws Exception {
        Intent intent = new Intent("miui.intent.action.HIDDEN_APPS_CONFIG_ACTIVITY");
//            intent.setComponent(new ComponentName("com.miui.powerkeeper",
//                    "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"));
        intent.putExtra("package_name", context.getPackageName());
        intent.putExtra("package_label", context.getResources().getString(context.getApplicationInfo().labelRes));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
