package com.reactnative.platform;

import android.app.Activity;
import android.content.Context;
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

import static com.reactnative.platform.DeviceUtil.isEmulator;
import static com.reactnative.platform.DeviceUtil.isHuaWei;
import static com.reactnative.platform.DeviceUtil.isMeiZu;
import static com.reactnative.platform.DeviceUtil.isOppo;
import static com.reactnative.platform.DeviceUtil.isVivo;
import static com.reactnative.platform.DeviceUtil.isXiaoMi;

public class PlatformModule extends ReactContextBaseJavaModule {
    private static final String ErrorCode = "PlatformModuleError";

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
    public void openBatteryStrategySettings(Promise promise) {
        try {
            Activity context = getCurrentActivity();
            if (isXiaoMi()) {
                BatteryOptimizationSettings.openBatteryStrategySettings(context);
            } else if (isVivo()) {
                // 打开 vivo 管家
                ManufacturerBackgroundSettings.openVivo(context);
            } else {
                promise.resolve(false);
                return;
            }

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(ErrorCode, e.getMessage());
        }
    }

    @ReactMethod
    public void openBackgroundSettings(Promise promise) {
        try {
            Activity context = getCurrentActivity();
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
            } else {
                promise.resolve(false);
                return;
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(ErrorCode, e.getMessage());
        }
    }

    @ReactMethod
    public void openSettings() {
        Activity context = getCurrentActivity();
        if (context != null) {
            openDetailsSettings(context);
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
            GpsSettings.openGps(context);
        }
    }

    @ReactMethod
    public void isSimulator(Promise promise) {
        promise.resolve(isEmulator());
    }

    public static void openDetailsSettings(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
