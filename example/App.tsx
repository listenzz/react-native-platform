import React, { Component } from 'react'
import { StyleSheet, TouchableOpacity, Text, View, Alert, Platform } from 'react-native'
import {
  BRAND,
  openBatteryStrategySettings,
  openBackgroundSettings,
  openSettings,
  openGpsSettings,
  requestIgnoreBatteryOptimizations,
} from 'react-native-platform'

export default class App extends Component<any> {
  static navigationItem = {
    titleItem: {
      title: 'Platform 演示',
    },
  }

  constructor(props: any) {
    super(props)
  }

  showSettings = () => {
    openSettings()
  }

  showGpsSettings = () => {
    openGpsSettings()
  }

  batteryOptimization = async () => {
    try {
      await openBatteryStrategySettings()
    } catch (e) {
      console.log('openBatteryStrategySettings failed: ' + e.message)
    }
  }

  showBackgroundSetting = async () => {
    try {
      await openBackgroundSettings()
    } catch (e) {
      console.log('openBackgroundSettings failed: ' + e.message)
    }
  }

  showIgnoreBatteryOptimizations = () => {
    requestIgnoreBatteryOptimizations()
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.tip}>手机品牌:{BRAND}</Text>

        <View style={styles.section}>
          <TouchableOpacity onPress={this.showSettings} activeOpacity={0.8}>
            <Text style={styles.button}> openSettings</Text>
          </TouchableOpacity>
        </View>

        <View style={styles.section}>
          <TouchableOpacity onPress={this.showGpsSettings} activeOpacity={0.8}>
            <Text style={styles.button}> openGpsSettings</Text>
          </TouchableOpacity>
        </View>
        {Platform.OS === 'android' && (
          <>
            <View style={styles.section}>
              <TouchableOpacity onPress={this.batteryOptimization} activeOpacity={0.8}>
                <Text style={styles.button}> openBatteryStrategySettings</Text>
              </TouchableOpacity>
            </View>

            <View style={styles.section}>
              <TouchableOpacity onPress={this.showBackgroundSetting} activeOpacity={0.8}>
                <Text style={styles.button}> openBackgroundSettings </Text>
              </TouchableOpacity>
            </View>

            <View style={styles.section}>
              <TouchableOpacity onPress={this.showIgnoreBatteryOptimizations} activeOpacity={0.8}>
                <Text style={styles.button}> requestIgnoreBatteryOptimizations </Text>
              </TouchableOpacity>
            </View>
          </>
        )}
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
    marginBottom: 8,
  },
  section: {
    height: 40,
    paddingLeft: 8,
    paddingRight: 8,
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'stretch',
  },
  title: {
    color: '#333333',
    fontSize: 16,
  },
  button: {
    fontSize: 14,
    width: 240,
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
