import { NativeModules } from 'react-native'
const { RNPlatform } = NativeModules

export function openSettings() {
  RNPlatform.openSettings()
}

export function openAuthorizationSettings() {
  RNPlatform.openAuthorizationSettings()
}

export function areNotificationsEnabled(): Promise<boolean> {
  return RNPlatform.areNotificationsEnabled()
}

export function openNotificationSettings() {
  RNPlatform.openNotificationSettings()
}

export function isGpsOpened(): Promise<boolean> {
  return RNPlatform.isGpsOpened()
}

export function openGpsSettings() {
  RNPlatform.openGpsSettings()
}

export * from './DeviceUtil'
export * from './BatteryOptimizationManager'
export * from './ManufacturerBackgroundManager'
