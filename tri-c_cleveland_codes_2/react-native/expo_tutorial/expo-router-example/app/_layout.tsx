import { Stack } from "expo-router"

// Stack adds an animation and a back button to the header area


const RootLayout = () => {
    return (
        <Stack>
        {/*      <Stack.Screen name="index" options={{
                 headerTitle: "Home Page",
                 headerStyle: {
                     backgroundColor: "slateblue",
                 }
             }}/>
             <Stack.Screen name="users/[id]" options={{
                 headerTitle: "User Page"
             }}/> */}

            {/* the (tabs) folder allows you to next your navigation and change it to fit your needs by grouping it in folders */}
            <Stack.Screen name="(tabs)" options={{
                headerShown: false,
            }}/>
        </Stack>
    )
}

export default RootLayout