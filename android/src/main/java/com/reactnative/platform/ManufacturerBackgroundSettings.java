package com.reactnative.platform;

import android.content.Context;

import static com.reactnative.platform.ActivityUtil.openActivity;

// 厂商后台管理，感谢 https://juejin.im/post/5dfaeccbf265da33910a441d
public class ManufacturerBackgroundSettings {


    // 跳转华为手机管家的启动管理页
    // 操作步骤：应用启动管理 -> 关闭应用开关 -> 打开允许自启动
    public static void openHuaWei(Context context) {
        try {
            openActivity(context, "com.huawei.systemmanager",
                    "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
        } catch (Exception e) {
            openActivity(context, "com.huawei.systemmanager",
                    "com.huawei.systemmanager.optimize.bootstart.BootStartActivity");
        }
    }

    // 跳转小米安全中心的自启动管理页面
    // 操作步骤：授权管理 -> 自启动管理 -> 允许应用自启动
    public static void openXiaoMi(Context context) {
        openActivity(context, "com.miui.securitycenter",
                "com.miui.permcenter.autostart.AutoStartManagementActivity");
    }

    // 跳转 OPPO 手机管家
    // 操作步骤：权限隐私 -> 自启动管理 -> 允许应用自启动
    public static void openOppo(Context context) {
        try {
            openActivity(context, "com.coloros.phonemanager");
        } catch (Exception e1) {
            try {
                openActivity(context, "com.oppo.safe");
            } catch (Exception e2) {
                try {
                    openActivity(context, "com.coloros.oppoguardelf");
                } catch (Exception e3) {
                    openActivity(context, "com.coloros.safecenter");
                }
            }
        }
    }

    // 跳转 VIVO 手机管家
    // 操作步骤：权限管理 -> 自启动 -> 允许应用自启动
    public static void openVivo(Context context) {
        openActivity(context, "com.iqoo.secure");
    }


    // 跳转魅族手机管家
    // 操作步骤：权限管理 -> 后台管理 -> 点击应用 -> 允许后台运行
    public static void openMeiZu(Context context) {
        openActivity(context, "com.meizu.safe");
    }

}
