Platform tools for React Native.

- 申请后台运行白名单 （Android 保活）

- 申请国内厂商后台管理白名单（Android 保活）

- 打开系统设置

- 打开 GPS 设置

## 权限

根据需要，请在 AndroidManifest.xml 中加入如下权限

```xml
<!--申请加入电池优化白名单-->
<uses-permission android:name="android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS" />
<!--申请华为后台管理白名单-->
<uses-permission android:name="com.huawei.systemmanager.permission.ACCESS_INTERFACE" />
```

## 申请加入电池优化白名单

```js
import { isIgnoringBatteryOptimizations, requestIgnoreBatteryOptimizations } from 'react-native-platform'

batteryOptimization = async () => {
  if (Platform.OS === 'android' && Platform.Version >= 23) {
    const ignored = await isIgnoringBatteryOptimizations()
    if (!ignored) {
      requestIgnoreBatteryOptimizations()
    } else {
      Alert.alert('提示', '本 App 已加入电池保护名单')
    }
  } else {
    Alert.alert('提示', '仅支持 Android6 以上系统')
  }
}
```

## 申请国内厂商后台管理白名单

```js
import { showBackgroundSetting, isBackgroundSettingSupported, backgroudSettingTip } from 'react-native-platform'

showBackgroundSetting = () => {
  if (Platform.OS !== 'android') {
    Alert.alert('提示', '仅支持 Android 平台')
    return
  }

  if (!isBackgroundSettingSupported()) {
    Alert.alert('提示', '这款手机不支持该项设置，请联系客服')
    return
  }

  Alert.alert('操作步骤', backgroudSettingTip(), [
    {
      text: '确定',
      onPress: () => {
        showBackgroundSetting()
      },
    },
  ])
}
```

## 感谢

- [QMUI_Android](https://github.com/Tencent/QMUI_Android)

- [Android 后台运行白名单，优雅实现保活](https://juejin.im/post/5dfaeccbf265da33910a441d)
