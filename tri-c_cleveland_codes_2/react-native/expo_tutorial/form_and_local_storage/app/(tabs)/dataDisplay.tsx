import { StyleSheet, Text, View } from "react-native";
import AsyncStorage from "@react-native-async-storage/async-storage";
import { useEffect, useState } from "react";

export default function DataDisplay() {
    const [savedValues, setSavedValues] = useState([] as Object[])

    const getItem = async (key : string) => {
        try {
          const value = await AsyncStorage.getItem(key);
        //   console.log(value)
          return value != null ? JSON.parse(value) : null;
        } catch (error) {
          console.error('Error getting item:', error);
          return null;
        }
      };

    const getAllKeys = async () => {
        let keys: readonly string[] = []
        try {
          keys = await AsyncStorage.getAllKeys()
        } catch(e) {
          // read key error
          console.error(`Error getting all Keys: \n\t${e}`)
        }
        return keys as string[]
    }
    
    useEffect(() => {
        setSavedValues([])
        getAllKeys().then(data => {
            console.log(`PROMISE ALLKEYS: ${data}`)
            let n = -1
            data.forEach(item => {
                getItem(item).then(data => {
                    console.log(data)
                    console.log(`PROMISE ITEM ${n}: ${JSON.stringify(data)}`)
                    return data
                }).then(data => {
                    // values.push(data.toString())
                    setSavedValues(sv => [...sv, data])                   
                })
                ++n
            })
        })
    }, [])

    console.log(savedValues)

    return (
        <View style={styles.displayWrapper}>
            <Text>
                Here will be the data!{"\n"}
            </Text>
                {savedValues ? (
                        <Text>
                            {JSON.stringify(savedValues)}
                        </Text>
                    )
                  : <Text>"No Data!" </Text> }
        </View>
    )
}

const styles = StyleSheet.create({
    displayWrapper: {
        height: "100%",
        marginTop: 25,
        paddingTop: 25,
        backgroundColor: "lightsteelblue",
        alignItems: "center"
    }
})