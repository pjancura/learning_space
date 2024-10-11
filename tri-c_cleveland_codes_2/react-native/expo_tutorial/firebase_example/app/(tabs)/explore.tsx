import Ionicons from '@expo/vector-icons/Ionicons';
import { StyleSheet, Image, Platform, View, Text, Pressable } from 'react-native';

import { Collapsible } from '@/components/Collapsible';
import { ExternalLink } from '@/components/ExternalLink';
import ParallaxScrollView from '@/components/ParallaxScrollView';
import { ThemedText } from '@/components/ThemedText';
import { ThemedView } from '@/components/ThemedView';
import { useEffect, useState } from 'react';

// import the firebaseConfig.js file to connect to remote realtime database
import { db } from "../../firebaseConfig"
import { ref, set, child, get } from "firebase/database"

interface plant {
  "scientificName": string,
  "commonName": string,
  "bloomStart": string,
  "bloomEnd": string,
  "lifespan": string,
  "form": string,
  "sunPreference": string,
  "soilPreference": string,
  "larvalHost": boolean,
  "supportsSpecialistBees": boolean,
  "attractsBeneficialInsects": boolean,
  "bumbleBeePlant": boolean,
  "nestSite": boolean,
  "nestMaterials": boolean,
  "nestThatch": boolean,
  "deerResistant": boolean
}

export default function TabTwoScreen() {
  const [data, setData] = useState([] as plant[])
  const [filteredPlants, setFilteredPlants] = useState([] as plant[])

  useEffect(() => {
    const dbRef = ref(db)
    get(child(dbRef, "plants")).then((snapshot) => {
      if (snapshot.exists()) {
        console.log(snapshot.val())
        setData(() => Object.values(snapshot.val()))
        setFilteredPlants(() => Object.values(snapshot.val()))
      } 
      else {
        console.log("No data available")
      }
    }).catch((error) => {
      console.error(error)
    })
  }, [])

  // useEffect(() => {
  //   const fetchPlants = async () => {
  //     const res = await fetch("https://nativeplantsgreatlakes-58e5b-default-rtdb.firebaseio.com/plants.json")
  //     const data = await res.json()
  //     setData(data)
  //   }

  //   fetchPlants()
  // }, [])

  function getPlants(objObj: {[key: string]: plant})   {
    // let plants: plant[] = []
    // if (objObj) {
    //   Object.entries(objObj).map(value => {
    //     console.log(value[1])
    //     plants.push(value[1])
    //   })
    // }
    // return plants
    return Object.values(objObj)
  }

  function filterPlants(key: string, value: string) {
    let plants = data
    let filteredPlants: plant[] = []
    switch (key) {
      case "bloomStart":
          filteredPlants = plants.filter(plants => plants.bloomStart === value)
          break
      default:
        break
    }
    setFilteredPlants(() => filteredPlants)
    return filteredPlants
  } 
  
  
  return (
    <View style={styles.container}>
      {/* {data ? (<Text>{Object.values(data).map(plant => {
        return plant
      })}</Text>) : null} */}
      {filteredPlants.map((item: plant) => {
        return <Text style={{color: "white"}} key={item.scientificName}>{item.commonName}</Text>
      })}

      <Pressable style={styles.button} onPress={() => filterPlants("bloomStart", "June")}>
        <Text style={styles.text}>Filter Bloom Start</Text>
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    marginTop: 120,
    marginHorizontal: 20,
  },
  headerImage: {
    color: '#808080',
    bottom: -90,
    left: -35,
    position: 'absolute',
  },
  titleContainer: {
    flexDirection: 'row',
    gap: 8,
  },
  button: {
    alignItems: 'center',
    justifyContent: 'center',
    paddingVertical: 12,
    paddingHorizontal: 32,
    borderRadius: 4,
    elevation: 3,
    backgroundColor: 'black',
  },
  text: {
    fontSize: 16,
    lineHeight: 21,
    fontWeight: 'bold',
    letterSpacing: 0.25,
    color: 'white',
  },
});
