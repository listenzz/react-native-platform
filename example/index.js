import {
  ReactRegistry,
  Navigator,
  Garden,
  BarStyleDarkContent,
} from 'react-native-navigation-hybrid'
import App from './App'

Garden.setStyle({
  screenBackgroundColor: '#F8F8F8',
  topBarStyle: BarStyleDarkContent,
})

ReactRegistry.startRegisterComponent()
ReactRegistry.registerComponent('Platform', () => App)
ReactRegistry.endRegisterComponent()

Navigator.setRoot({
  stack: {
    children: [
      {
        screen: {
          moduleName: 'Platform',
        },
      },
    ],
  },
})
