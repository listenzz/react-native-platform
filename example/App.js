import React, { Component } from 'react'
import { StyleSheet, TouchableOpacity, Text, View, Alert, Platform } from 'react-native'
import {
  BRAND,
  isIgnoringBatteryOptimizations,
  requestIgnoreBatteryOptimizations,
  showBackgroundSetting,
  isBackgroundSettingSupported,
  backgroudSettingTip,
} from 'react-native-platform'
export default class App extends Component {
  static navigationItem = {
    titleItem: {
      title: 'Platform 演示',
    },
  }

  constructor(props) {
    super(props)
  }

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

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.tip}>手机品牌:{BRAND}</Text>
        <Text style={styles.tip}>为保证本 App 处于后台时能正常运行，建议您进行如下设置</Text>
        <View style={styles.section}>
          <Text style={styles.title}>请勿开启省电模式</Text>
        </View>
        <Text style={styles.description}>
          为了能让本 App 处于后台时，也能及时接收到服务器发送的消息，建议您在使用本 App
          过程中关闭省电模式。
        </Text>
        <View style={styles.section}>
          <Text style={styles.title}>电池优化设置</Text>
          <TouchableOpacity onPress={this.batteryOptimization} activeOpacity={0.8}>
            <Text style={styles.button}> 快速设置</Text>
          </TouchableOpacity>
        </View>
        <Text style={styles.description}>
          为了能让本 App 处于后台时，不被系统误杀，建议您将本 App 加入电池保护名单中。
        </Text>
        <View style={styles.section}>
          <Text style={styles.title}>后台运行设置</Text>
          <TouchableOpacity onPress={this.showBackgroundSetting} activeOpacity={0.8}>
            <Text style={styles.button}> 快速设置</Text>
          </TouchableOpacity>
        </View>
        <Text style={styles.description}>
          为了能让本 App 处于后台时，也能及时接收到服务器发送的消息，建议您为本 App
          开启后台运行权限。
        </Text>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'flex-start',
    alignItems: 'stretch',
  },

  tip: {
    color: '#666666',
    fontSize: 14,
    textAlign: 'center',
    lineHeight: 40,
    backgroundColor: '#EEEEEE',
  },
  section: {
    height: 40,
    paddingLeft: 8,
    paddingRight: 8,
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  title: {
    color: '#333333',
    fontSize: 16,
  },
  button: {
    fontSize: 14,
    width: 80,
    textAlign: 'center',
    borderRadius: 15,
    backgroundColor: '#FF4444',
    color: '#FFFFFF',
    lineHeight: 30,
  },
  description: {
    paddingLeft: 8,
    paddingRight: 8,
    color: '#999999',
    fontSize: 14,
  },
})
