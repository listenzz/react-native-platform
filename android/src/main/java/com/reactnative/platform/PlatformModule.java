package com.reactnative.platform;

import android.app.Activity;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import static com.reactnative.platform.DeviceUtil.isHuaWei;
import static com.reactnative.platform.DeviceUtil.isMeiZu;
import static com.reactnative.platform.DeviceUtil.isOppo;
import static com.reactnative.platform.DeviceUtil.isVivo;
import static com.reactnative.platform.DeviceUtil.isXiaoMi;

public class PlatformModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public PlatformModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return "RNPlatform";
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put("BRAND", Build.BRAND);
        return constants;
    }

    @ReactMethod
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void isIgnoringBatteryOptimizations(Promise promise) {
        Activity context = getCurrentActivity();
        if (context != null) {
            promise.resolve(BatteryOptimizationSettings.isIgnoringBatteryOptimizations(context));
        } else {
            promise.resolve(false);
        }
    }

    @ReactMethod
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void requestIgnoreBatteryOptimizations() {
        Activity context = getCurrentActivity();
        if (context != null) {
            BatteryOptimizationSettings.requestIgnoreBatteryOptimizations(context);
        }
    }

    @ReactMethod
    public void openBatteryStrategySettings() {
        Activity context = getCurrentActivity();
        if (context != null) {
            if (isXiaoMi()) {
                BatteryOptimizationSettings.openBatteryStrategySettings(context);
            } else if (isVivo()) {
                // 打开 vivo 管家
                ManufacturerBackgroundSettings.openVivo(context);
            }
        }
    }

    @ReactMethod
    public void openBackgroundSettings() {
        Activity context = getCurrentActivity();
        if (context != null) {
            try {
                if (isHuaWei()) {
                    ManufacturerBackgroundSettings.openHuaWei(context);
                } else if (isXiaoMi()) {
                    ManufacturerBackgroundSettings.openXiaoMi(context);
                } else if (isOppo()) {
                    ManufacturerBackgroundSettings.openOppo(context);
                } else if (isVivo()) {
                    ManufacturerBackgroundSettings.openVivo(context);
                } else if (isMeiZu()) {
                    ManufacturerBackgroundSettings.openMeiZu(context);
                }
            } catch (Exception e) {
                e.printStackTrace();
                ActivityUtil.openDetailsSettings(context);
            }
        }
    }

    @ReactMethod
    public void openSettings() {
        Activity context = getCurrentActivity();
        if (context != null) {
            ActivityUtil.openDetailsSettings(context);
        }
    }

    @ReactMethod
    public void isGpsOpened(Promise promise) {
        promise.resolve(GpsSettings.isGpsOpened(reactContext));
    }

    @ReactMethod
    public void openGpsSettings() {
        Activity context = getCurrentActivity();
        if (context != null) {
            try {
                GpsSettings.openGps(context);
            } catch (Exception e) {
                e.printStackTrace();
                ActivityUtil.openDetailsSettings(context);
            }
        }
    }

    @ReactMethod
    public void openAuthorizationSettings() {
        Activity context = getCurrentActivity();
        if (context != null) {
            try {
                AuthorizationSettings.open(context);
            } catch (Exception e) {
                e.printStackTrace();
                ActivityUtil.openDetailsSettings(context);
            }
        }
    }

    @ReactMethod
    public void areNotificationsEnabled(Promise promise) {
        promise.resolve(NotificationSettings.areNotificationsEnabled(getReactApplicationContext()));
    }

    @ReactMethod
    public void openNotificationSettings() {
        Activity context = getCurrentActivity();
        if (context != null) {
            try {
                NotificationSettings.openNotificationSettings(context);
            } catch (Exception e) {
                e.printStackTrace();
                ActivityUtil.openDetailsSettings(context);
            }
        }
    }

}
