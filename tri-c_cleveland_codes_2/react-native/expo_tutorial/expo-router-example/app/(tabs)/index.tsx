import { Link, router } from "expo-router";
import { Pressable, StyleSheet, Text, View } from "react-native";

export default function Page() {
  return (
    <View style={styles.container}>
      <View style={styles.main}>
        <Text style={styles.title}>Home Page</Text>
        <Link href={"/users/1"} style={styles.subtitle}>Go to User 1</Link>
        <Pressable onPress={() => router.push("/users/2")}>
          <Text style={styles.subtitle}>Go to User 2</Text>
        </Pressable>
        <Pressable onPress={() => router.push({
          pathname: "/users/[id]",
          params: { id: 3 },
        })}>
          <Text style={styles.subtitle}>Go to User 3</Text>
        </Pressable>
      </View>
    </View>
  );
}

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
