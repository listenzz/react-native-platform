package com.reactnative.platform;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

// 厂商后台管理，感谢 https://juejin.im/post/5dfaeccbf265da33910a441d
public class ManufacturerBackgroundManager {

    /**
     * 跳转到指定应用的首页
     */
    private void showActivity(@NonNull Context context, @NonNull String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        context.startActivity(intent);
    }

    /**
     * 跳转到指定应用的指定页面
     */
    private void showActivity(@NonNull Context context, @NonNull String packageName, @NonNull String activityName) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    // 跳转华为手机管家的启动管理页
    // 操作步骤：应用启动管理 -> 关闭应用开关 -> 打开允许自启动
    public void showHuaweiSetting(Context context) {
        try {
            showActivity(context, "com.huawei.systemmanager",
                    "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
        } catch (Exception e) {
            showActivity(context, "com.huawei.systemmanager",
                    "com.huawei.systemmanager.optimize.bootstart.BootStartActivity");
        }
    }

    // 跳转小米安全中心的自启动管理页面
    // 操作步骤：授权管理 -> 自启动管理 -> 允许应用自启动
    public void showXiaomiSetting(Context context) {
        showActivity(context, "com.miui.securitycenter",
                "com.miui.permcenter.autostart.AutoStartManagementActivity");
    }

    // 跳转 OPPO 手机管家
    // 操作步骤：权限隐私 -> 自启动管理 -> 允许应用自启动
    public void showOPPOSetting(Context context) {
        try {
            showActivity(context, "com.coloros.phonemanager");
        } catch (Exception e1) {
            try {
                showActivity(context, "com.oppo.safe");
            } catch (Exception e2) {
                try {
                    showActivity(context, "com.coloros.oppoguardelf");
                } catch (Exception e3) {
                    showActivity(context, "com.coloros.safecenter");
                }
            }
        }
    }

    // 跳转 VIVO 手机管家
    // 操作步骤：权限管理 -> 自启动 -> 允许应用自启动
    public void showVIVOSetting(Context context) {
        showActivity(context, "com.iqoo.secure");
    }


    // 跳转魅族手机管家
    // 操作步骤：权限管理 -> 后台管理 -> 点击应用 -> 允许后台运行
    public void showMeizuSetting(Context context) {
        showActivity(context, "com.meizu.safe");
    }

    // 跳转三星智能管理器
    // 操作步骤：自动运行应用程序 -> 打开应用开关 -> 电池管理 -> 未监视的应用程序 -> 添加应用
    public void showSamsungSetting(Context context) {
        try {
            showActivity(context, "com.samsung.android.sm_cn");
        } catch (Exception e) {
            showActivity(context, "com.samsung.android.sm");
        }
    }

    // 跳转乐视手机管家
    // 操作步骤：自启动管理 -> 允许应用自启动
    public void showLetvSetting(Context context) {
        showActivity(context, "com.letv.android.letvsafe",
                "com.letv.android.letvsafe.AutobootManageActivity");
    }

    // 跳转锤子手机管理
    // 操作步骤：权限管理 -> 自启动权限管理 -> 点击应用 -> 允许被系统启动
    public void showSmartisanSetting(Context context) {
        showActivity(context, "com.smartisanos.security");
    }

}
