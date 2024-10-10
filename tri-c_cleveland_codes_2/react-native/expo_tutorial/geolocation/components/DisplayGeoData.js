// import React, { useState, useEffect, } from 'react';
// import MapView, { Marker } from 'react-native-maps';
// import { View, Text, Platform } from 'react-native'
// import Geolocation from 'react-native-geolocation-service';

// export default function DisplayGeoData() {
//     const [location, setLocation] = useState(null);
  
//     useEffect(() => {
//       Geolocation.requestAuthorization();
//     }, []);
  
//     useEffect(() => {
//         const getCurrentLocation = () => {
//             console.log("started running\n\n\n")
//           Geolocation.getCurrentPosition(
//             (position) => {
//                 console.log(position)
//               setLocation(position);
//             },
//             (error) => {
//               console.log(error.code, error.message);
//             },
//             { enableHighAccuracy: true, timeout: 15000, maximumAge: 10000 }
//           );
//         };
      
//         if (Platform.OS === 'android') {
//           Geolocation.requestAuthorization();
//         }
      
//         getCurrentLocation();
//       }, []);

//       return (
//         <View style={{ flex: 1, marginTop: 50 }}>
//             {/* <Text style={{color: "white"}}>from Geo Data</Text> */}
//           {location && (
//             <MapView
//               style={{ flex: 1 }}
//               initialRegion={{
//                 latitude: location.coords.latitude,
//                 longitude: location.coords.longitude,
//                 latitudeDelta: 0.0922,
//                 longitudeDelta: 0.0421,
//               }}
//             >
//               <Marker
//                 coordinate={{
//                   latitude: location.coords.latitude,
//                   longitude: location.coords.longitude,
//                 }}
//                 title="My Location"
//               />
//             </MapView>
//           )}
//         </View>
//       );
//   }