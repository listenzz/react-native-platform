import { NativeModules } from 'react-native'
const { RNPlatform } = NativeModules
import {
  isHuawei,
  isXiaomi,
  isVIVO,
  isOPPO,
  isMeizu,
  isLeTV,
  isSamsung,
  isSmartisan,
} from './DeviceUtil'

export function isBackgroundSettingSupported() {
  return (
    isHuawei() ||
    isXiaomi() ||
    isVIVO() ||
    isOPPO() ||
    isMeizu() ||
    isSamsung() ||
    isSmartisan() ||
    isLeTV()
  )
}

export function showBackgroundSetting() {
  if (isHuawei()) {
    showHuaweiSetting()
  } else if (isXiaomi()) {
    showXiaomiSetting()
  } else if (isVIVO()) {
    showVIVOSetting()
  } else if (isOPPO()) {
    showOPPOSetting()
  } else if (isMeizu()) {
    showMeizuSetting()
  } else if (isSamsung()) {
    showSamsungSetting()
  } else if (isSmartisan()) {
    showSmartisanSetting()
  } else if (isLeTV()) {
    showLetvSetting()
  }
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
  } else if (isSamsung()) {
    return '自动运行应用程序 -> 打开应用开关 -> 电池管理 -> 未监视的应用程序 -> 添加应用'
  } else if (isSmartisan()) {
    return '权限管理 -> 自启动权限管理 -> 点击应用 -> 允许被系统启动'
  } else if (isLeTV()) {
    return '自启动管理 -> 允许应用自启动'
  }
  return ''
}

function showHuaweiSetting() {
  RNPlatform.showHuaweiSetting()
}

function showXiaomiSetting() {
  RNPlatform.showXiaomiSetting()
}

function showOPPOSetting() {
  RNPlatform.showOPPOSetting()
}

function showVIVOSetting() {
  RNPlatform.showVIVOSetting()
}

function showMeizuSetting() {
  RNPlatform.showMeizuSetting()
}

function showSamsungSetting() {
  RNPlatform.showSamsungSetting()
}

function showLetvSetting() {
  RNPlatform.showLetvSetting()
}

function showSmartisanSetting() {
  RNPlatform.showSmartisanSetting()
}
