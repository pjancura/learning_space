// the [id]  allows for a dynamic route to be created
// whatever id gets passed to the users route will open up this page

import { router, useLocalSearchParams } from "expo-router"
import { Pressable, StyleSheet, Text, View } from "react-native"

const UserPage = () => {
    // useLocalSearchParams gives you access to variables stored in the URL
    const { id } = useLocalSearchParams<{ id: string }>();

    return (
        <View>
            <Text style={styles.title}>User Page {id}</Text>
            <Pressable onPress={() => router.push("/")}>
                <Text style={styles.subtitle}> Go Home </Text>
            </Pressable>
        </View>
    )
}

export default UserPage

const styles = StyleSheet.create({
    container: {
      flex: 1,
      alignItems: "center",
      padding: 24,
    },
    main: {
      flex: 1,
      justifyContent: "center",
      maxWidth: 960,
      marginHorizontal: "auto",
    },
    title: {
      fontSize: 64,
      fontWeight: "bold",
    },
    subtitle: {
      fontSize: 36,
      color: "#38434D",
    },
  });