package com.reactnative.platform;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

// 厂商后台管理，感谢 https://juejin.im/post/5dfaeccbf265da33910a441d
public class ManufacturerBackgroundSettings {


    // 跳转华为手机管家的启动管理页
    // 操作步骤：应用启动管理 -> 关闭应用开关 -> 打开允许自启动
    public static void openHuaWei(Context context) throws Exception {
        try {
            openActivity(context, "com.huawei.systemmanager",
                    "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
        } catch (Exception e) {
            openHuaWeiBootStartActivity(context);
        }
    }

    private static void openHuaWeiBootStartActivity(Context context) throws Exception {
        try {
            openActivity(context, "com.huawei.systemmanager",
                    "com.huawei.systemmanager.optimize.bootstart.BootStartActivity");
        } catch (Exception e) {
            openHuaWeiPhoneManagerActivity(context);
        }
    }

    private static void openHuaWeiPhoneManagerActivity(Context context) throws Exception {
        openActivity(context, "com.huawei.systemmanager",
                "com.huawei.systemmanager.mainscreen.MainScreenActivity");
    }

    // 跳转小米安全中心的自启动管理页面
    // 操作步骤：授权管理 -> 自启动管理 -> 允许应用自启动
    public static void openXiaoMi(Context context) throws Exception {
        openActivity(context, "com.miui.securitycenter",
                "com.miui.permcenter.autostart.AutoStartManagementActivity");
    }

    // 跳转 OPPO 手机管家
    // 操作步骤：权限隐私 -> 自启动管理 -> 允许应用自启动
    // 跳转 OPPO 手机管家
    // 操作步骤：权限隐私 -> 自启动管理 -> 允许应用自启动
    public static void openOppo(Context context) throws Exception {
        try {
            openActivity(context, "com.coloros.phonemanager");
        } catch (Exception e) {
            openOppoSafeActivity(context);
        }
    }

    private static void openOppoSafeActivity(Context context) throws Exception  {
        try {
            openActivity(context, "com.oppo.safe");
        } catch (Exception e) {
            openOppoGuardelfActivity(context);
        }
    }

    private static void openOppoGuardelfActivity(Context context) throws Exception {
        try {
            openActivity(context, "com.coloros.oppoguardelf");
        } catch (Exception e) {
            openOppoSafecenterActivity(context);
        }
    }

    private static void openOppoSafecenterActivity(Context context) throws Exception {
        openActivity(context, "com.coloros.safecenter");
    }

    // 跳转 VIVO 手机管家
    // 操作步骤：权限管理 -> 自启动 -> 允许应用自启动
    public static void openVivo(Context context) throws Exception {
        openActivity(context, "com.iqoo.secure");
    }


    // 跳转魅族手机管家
    // 操作步骤：权限管理 -> 后台管理 -> 点击应用 -> 允许后台运行
    public static void openMeiZu(Context context) throws Exception {
        openActivity(context, "com.meizu.safe");
    }

    /**
     * 跳转到指定应用的首页
     */
    public static void openActivity(@NonNull Context context, @NonNull String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    /**
     * 跳转到指定应用的指定页面
     */
    public static void openActivity(@NonNull Context context, @NonNull String packageName, @NonNull String activityName) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setComponent(new ComponentName(packageName, activityName));
        context.startActivity(intent);
    }

}
