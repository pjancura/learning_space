package java_17.array_notes;

import java.util.Arrays;
import java.util.Random;

public class FindMatch {
    
    public static void main(String[] args) {
        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        if (Arrays.binarySearch(sArray, "Mark") >= 0) {
            System.out.println("Found Mark in the list");
        }

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {1, 2, 3, 4, 5};

        if (Arrays.equals(s1, s2)) {
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }


        int[] intArray = getRandomArray(20);
        System.out.println(Arrays.toString(intArray));
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));
        reverseArray(intArray);
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(sortIntegers(intArray)));

        

    }

    private static int[] getRandomArray(int len) {

        Random random = new Random();
        int[] newInt = new int[len];
        for (int i = 0; i < len; i++) {
            newInt[i] = random.nextInt(100);
        }

        return newInt;
    }

    private static int[] reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp1 = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp1;
        }

        return array;
    }

    private static int[] sortIntegers(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while(flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        reverseArray(sortedArray);
        return sortedArray;
    }

}
