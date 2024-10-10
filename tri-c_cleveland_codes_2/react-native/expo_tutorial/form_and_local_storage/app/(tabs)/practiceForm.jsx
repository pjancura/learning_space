import { Platform, StyleSheet } from 'react-native';
import React, { useState } from 'react';
import { View, TextInput, Button, Text } from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';
import { useFormData } from "@/hooks/useFormData"
import DismissKeyboard from "@/components/DismissKeyboard"

const MyForm = () => {
  const { setSubmittedData } = useFormData()
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [dataKeys, setDataKeys] = useState([])


  // const handleSave = async () => {
  //     let newUUID = Math.random().toString()
  //   try {
  //     await AsyncStorage.setItem(newUUID, JSON.stringify({ name, email }));
  //     let data = await AsyncStorage.getItem(newUUID)
  //     console.log(data)
  //     alert('Data saved successfully!');
  //   } catch (error) {
  //     console.error('Error saving data:', error);
  //   }
  //   setDataKeys(dk => [...dk, newUUID])
  // };

  const handleSave = (data) => {
    setSubmittedData((prevData) => [...prevData, data])
};

  // console.log(dataKeys)

  return (
    <DismissKeyboard>
      <View style={styles.formWrapper}>
        <TextInput
          placeholder="Name"
          value={name}
          onChangeText={setName}
        />
        <TextInput
          placeholder="Email"
          value={email}
          onChangeText={setEmail}
        />
        <Button title="Save" onPress={handleSave} />
      </View>
    </DismissKeyboard>
  );
};

export default MyForm;


const styles = StyleSheet.create({
    formWrapper: {
        height: "100%",
        marginTop: Platform.OS === "android" ? 25 : 50,
        backgroundColor: "lightsteelblue",
    }
})
