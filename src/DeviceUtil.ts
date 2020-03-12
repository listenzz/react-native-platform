import { NativeModules } from 'react-native'
const { RNPlatform } = NativeModules

export const BRAND: string = RNPlatform.BRAND

export function isHuawei() {
  if (!BRAND) {
    return false
  }
  return BRAND.toLocaleLowerCase() === 'huawei' || BRAND.toLocaleLowerCase() === 'honor'
}

export function isXiaomi() {
  if (!BRAND) {
    return false
  }
  return BRAND.toLocaleLowerCase() === 'xiaomi'
}

export function isOPPO() {
  if (!BRAND) {
    return false
  }
  return BRAND.toLocaleLowerCase() === 'oppo'
}

export function isVIVO() {
  if (!BRAND) {
    return false
  }
  return BRAND.toLocaleLowerCase() === 'vivo'
}

export function isMeizu() {
  if (!BRAND) {
    return false
  }
  return BRAND.toLocaleLowerCase() === 'meizu'
}
