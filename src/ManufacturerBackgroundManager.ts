import { NativeModules } from 'react-native'
const { RNPlatform } = NativeModules
import { isHuawei, isXiaomi, isVIVO, isOPPO, isMeizu } from './DeviceUtil'

export function isBackgroundSettingSupported() {
  return isHuawei() || isXiaomi() || isVIVO() || isOPPO() || isMeizu()
}

export function openBackgroundSettings() {
  RNPlatform.openBackgroundSettings()
}

export function backgroudSettingTip() {
  if (isHuawei()) {
    return '应用启动管理 -> 关闭应用开关 -> 打开允许自启动'
  } else if (isXiaomi()) {
    return '授权管理 -> 自启动管理 -> 允许应用自启动'
  } else if (isVIVO()) {
    return '权限管理 -> 自启动 -> 允许应用自启动'
  } else if (isOPPO()) {
    return '权限隐私 -> 自启动管理 -> 允许应用自启动'
  } else if (isMeizu()) {
    return '权限管理 -> 后台管理 -> 点击应用 -> 允许后台运行'
  }
  return ''
}
