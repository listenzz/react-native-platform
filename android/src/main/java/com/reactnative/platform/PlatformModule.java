package com.reactnative.platform;

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
        promise.resolve(batteryOptimizationManager.isIgnoringBatteryOptimizations(getCurrentActivity()));
    }

    @ReactMethod
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void requestIgnoreBatteryOptimizations() {
        batteryOptimizationManager.requestIgnoreBatteryOptimizations(getCurrentActivity());
    }

    @ReactMethod
    public void showHuaweiSetting() {
        backgroundManager.showHuaweiSetting(getCurrentActivity());
    }

    @ReactMethod
    public void showXiaomiSetting() {
        backgroundManager.showXiaomiSetting(getCurrentActivity());
    }

    @ReactMethod
    public void showOPPOSetting() {
        backgroundManager.showOPPOSetting(getCurrentActivity());
    }

    @ReactMethod
    public void showVIVOSetting() {
        backgroundManager.showVIVOSetting(getCurrentActivity());
    }

    @ReactMethod
    public void showMeizuSetting() {
        backgroundManager.showMeizuSetting(getCurrentActivity());
    }

    @ReactMethod
    public void showSamsungSetting() {
        backgroundManager.showSamsungSetting(getCurrentActivity());
    }

    @ReactMethod
    public void showLetvSetting() {
        backgroundManager.showLetvSetting(getCurrentActivity());
    }

    @ReactMethod
    public void showSmartisanSetting() {
        backgroundManager.showSmartisanSetting(getCurrentActivity());
    }

}
