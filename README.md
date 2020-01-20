Platform tools for React Native.

## 电池优化设置

```js
import {
  isIgnoringBatteryOptimizations,
  requestIgnoreBatteryOptimizations,
} from 'react-native-platform'

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

## 后台运行设置

```js
import {
  showBackgroundSetting,
  isBackgroundSettingSupported,
  backgroudSettingTip,
} from 'react-native-platform'

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
