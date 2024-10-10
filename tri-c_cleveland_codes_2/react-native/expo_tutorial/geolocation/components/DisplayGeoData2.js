import { useState, useEffect } from 'react';
import { Platform, Text, View, StyleSheet, Linking } from 'react-native';
import * as Device from 'expo-device';
import * as Location from 'expo-location';

export default function DisplayGeoData2() {
  const [location, setLocation] = useState(null);
  const [errorMsg, setErrorMsg] = useState(null);


  useEffect(() => {
    (async () => {
      if (Platform.OS === 'android' && !Device.isDevice) {
        setErrorMsg(
          'Oops, this will not work on Snack in an Android Emulator. Try it on your device!'
        );
        return;
      }
      let { status } = await Location.requestForegroundPermissionsAsync();
      if (status !== 'granted') {
        setErrorMsg('Permission to access location was denied');
        return;
      }

      let location = await Location.getCurrentPositionAsync({});
      setLocation(location);
      const latitude = "0";
      const longitude = "0";
      const label = "Student Services, 2900 Community College Ave, Cleveland, OH 44115";
      
      const url = Platform.select({
        ios: "maps:" + latitude + "," + longitude + "?q=" + label,
        android: "geo:" + latitude + "," + longitude + "?q=" + label
      });
          
          Linking.openURL(url)
    })();
  }, []);

  let text = 'Waiting..';
  if (errorMsg) {
    text = errorMsg;
  } else if (location) {
    text = JSON.stringify(location);
  }

  return (
    <View style={styles.container}>
      <Text style={styles.paragraph}>{text}</Text>

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    padding: 20,
  },
  paragraph: {
    fontSize: 18,
    textAlign: 'center',
  },
});
