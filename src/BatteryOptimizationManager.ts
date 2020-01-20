import { NativeModules } from 'react-native'
const { RNPlatform } = NativeModules

/**
 * 判断我们的应用是否在系统白名单中
 */
export function isIgnoringBatteryOptimizations(): Promise<Boolean> {
  return RNPlatform.isIgnoringBatteryOptimizations()
}

/**
 * 申请加入系统白名单
 */
export function requestIgnoreBatteryOptimizations(): void {
  RNPlatform.requestIgnoreBatteryOptimizations()
}
