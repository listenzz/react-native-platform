package com.reactnative.platform;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;

import androidx.core.app.NotificationManagerCompat;

public class NotificationSettings {

    private static final String MARK = Build.MANUFACTURER.toLowerCase();

    public static boolean areNotificationsEnabled(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public static void openNotificationSettings(Context context) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O && (MARK.contains("xiaomi") || MARK.contains("oppo"))) {
            //这种方案适用于 API 26, 即8.0（含8.0）以上可以用
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.getPackageName());
            intent.putExtra(Settings.EXTRA_CHANNEL_ID, context.getApplicationInfo().uid);
            // 如果用户在权限设置界面改动了权限，请求权限 Activity 会被重启，加入这个 Flag 就可以避免
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            ActivityUtil.openDetailsSettings(context);
        }
    }

}
