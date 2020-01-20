package com.reactnative.platform;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

public class PlatformModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    private BatteryOptimizationManager batteryOptimizationManager;
    private ManufacturerBackgroundManager backgroundManager;

    public PlatformModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        batteryOptimizationManager = new BatteryOptimizationManager();
        backgroundManager = new ManufacturerBackgroundManager();
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
            promise.resolve(batteryOptimizationManager.isIgnoringBatteryOptimizations(context));
        } else {
            promise.resolve(false);
        }
    }

    @ReactMethod
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void requestIgnoreBatteryOptimizations() {
        Activity context = getCurrentActivity();
        if (context != null) {
            batteryOptimizationManager.requestIgnoreBatteryOptimizations(context);
        }
    }

    @ReactMethod
    public void showHuaweiSetting() {
        Activity context = getCurrentActivity();
        if (context != null) {
            backgroundManager.showHuaweiSetting(context);
        }
    }

    @ReactMethod
    public void showXiaomiSetting() {
        Activity context = getCurrentActivity();
        if (context != null) {
            backgroundManager.showXiaomiSetting(context);
        }
    }

    @ReactMethod
    public void showOPPOSetting() {
        Activity context = getCurrentActivity();
        if (context != null) {
            backgroundManager.showOPPOSetting(context);
        }
    }

    @ReactMethod
    public void showVIVOSetting() {
        Activity context = getCurrentActivity();
        if (context != null) {
            backgroundManager.showVIVOSetting(context);
        }
    }

    @ReactMethod
    public void showMeizuSetting() {
        Activity context = getCurrentActivity();
        if (context != null) {
            backgroundManager.showMeizuSetting(context);
        }
    }

    @ReactMethod
    public void showSamsungSetting() {
        Activity context = getCurrentActivity();
        if (context != null) {
            backgroundManager.showSamsungSetting(context);
        }
    }

    @ReactMethod
    public void showLetvSetting() {
        Activity context = getCurrentActivity();
        if (context != null) {
            backgroundManager.showLetvSetting(context);
        }
    }

    @ReactMethod
    public void showSmartisanSetting() {
        Activity context = getCurrentActivity();
        if (context != null) {
            backgroundManager.showSmartisanSetting(context);
        }
    }

    @ReactMethod
    public void openDetailSettings(Promise promise) {
        try {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setData(Uri.parse("package:" + getReactApplicationContext().getPackageName()));
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.startActivity(intent);
                promise.resolve(true);
            } else {
                promise.resolve(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isGpsOpened(Promise promise) {
        promise.resolve(GpsUtil.isGpsOpened(reactContext));
    }

    @ReactMethod
    public void openGpsSettings(Promise promise) {
        Activity context = getCurrentActivity();
        if (context != null) {
            try {
                GpsUtil.openGps(reactContext);
                promise.resolve(true);
            } catch (Exception e) {
                promise.reject(e);
            }
        } else {
            promise.resolve(false);
        }
    }

}
