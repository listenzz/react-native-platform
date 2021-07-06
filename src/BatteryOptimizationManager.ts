import { NativeModules } from 'react-native'
const { RNPlatform } = NativeModules

/**
 * 判断我们的应用是否在系统白名单中
 */
export function isIgnoringBatteryOptimizations(): Promise<boolean> {
  return RNPlatform.isIgnoringBatteryOptimizations()
}

/**
 * 申请加入系统白名单
 */
export function requestIgnoreBatteryOptimizations(): void {
  RNPlatform.requestIgnoreBatteryOptimizations()
}

/**
 * 打开省电策略设置界面
 */
export function openBatteryStrategySettings(): Promise<boolean> {
  return RNPlatform.openBatteryStrategySettings()
}
