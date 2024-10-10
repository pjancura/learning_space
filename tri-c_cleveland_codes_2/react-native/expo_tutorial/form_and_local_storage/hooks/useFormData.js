import React, {
  createContext,
  useContext,
  useState,
  useEffect,
  PropsWithChildren,
} from "react";
import AsyncStorage from "@react-native-async-storage/async-storage";

const FormDataContext = createContext();

export const useFormData = () => {
  return useContext(FormDataContext);
};

export const FormDataProvider = ({ children }) => {
  const [submittedData, setSubmittedData] = useState([]);

  useEffect(() => {
    const loadData = async () => {
      try {
        const storedData = await AsyncStorage.getItem("submittedData");
        if (storedData) {
          setSubmittedData(JSON.parse(storedData));
        }
      } catch (e) {
        console.error("Failed to load data from storage", e);
      }
    };
    loadData();
  }, []);

  useEffect(() => {
    const saveData = async () => {
      try {
        await AsyncStorage.setItem(
          "submittedData",
          JSON.stringify(submittedData)
        );
      } catch (e) {
        console.error("Failed to save data to storage", e);
      }
    };
    saveData();
  }, [submittedData]);

  return (
    <FormDataContext.Provider value={{ submittedData, setSubmittedData }}>
        {children}
    </FormDataContext.Provider>
  )
};
