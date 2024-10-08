import { StyleSheet } from 'react-native';
import React, { useState } from 'react';
import { View, TextInput, Button, Text } from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';

const MyForm = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [dataKeys, setDataKeys] = useState([] as string[])


  const handleSave = async () => {
      let newUUID = Math.random().toString()
    try {
      await AsyncStorage.setItem(newUUID, JSON.stringify({ name, email }));
      let data = await AsyncStorage.getItem(newUUID)
      console.log(data)
      alert('Data saved successfully!');
    } catch (error) {
      console.error('Error saving data:', error);
    }
    setDataKeys(dk => [...dk, newUUID])
  };

  console.log(dataKeys)

  return (
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
  );
};

export default MyForm;


const styles = StyleSheet.create({
    formWrapper: {
        height: "100%",
        marginTop: 25,
        backgroundColor: "lightsteelblue",
    }
})
