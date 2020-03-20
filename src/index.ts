import { NativeModules, Platform } from 'react-native'
const { RNPlatform } = NativeModules

export function openSettings() {
  RNPlatform.openSettings()
}

export function isGpsOpened(): Promise<boolean> {
  return RNPlatform.isGpsOpened()
}

export function openGpsSettings() {
  if (Platform.OS === 'android') {
    RNPlatform.openGpsSettings()
  }
}

export * from './DeviceUtil'
export * from './BatteryOptimizationManager'
export * from './ManufacturerBackgroundManager'
