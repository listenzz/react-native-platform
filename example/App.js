import React, { Component } from 'react'
import { StyleSheet, TouchableOpacity, Text, View } from 'react-native'

export default class App extends Component {
  static navigationItem = {
    titleItem: {
      title: 'Platform 演示',
    },
  }

  constructor(props) {
    super(props)
    this.handlePress = this.handlePress.bind(this)
  }

  handlePress() {
    console.log('You have pressed me.')
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>Hello World!</Text>

        <TouchableOpacity onPress={this.handlePress} activeOpacity={0.2} style={styles.button}>
          <Text style={styles.buttonText}>press me</Text>
        </TouchableOpacity>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'flex-start',
    alignItems: 'stretch',
    paddingTop: 16,
  },
  button: {
    alignItems: 'center',
    justifyContent: 'center',
    height: 40,
  },

  buttonText: {
    backgroundColor: 'transparent',
    color: 'rgb(34,88,220)',
  },

  welcome: {
    backgroundColor: 'transparent',
    fontSize: 17,
    textAlign: 'center',
    margin: 8,
  },
})
