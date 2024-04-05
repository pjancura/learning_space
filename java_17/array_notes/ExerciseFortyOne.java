package java_17.array_notes;

import java.util.Arrays;
import java.util.Scanner;

public class ExerciseFortyOne {
    
    public static void main(String[] args) {
    }
}

class SortedArray {
    private int[] intArray;

    public SortedArray(int[] intArray) {
        this.intArray = intArray;
    }

    public static int[] getIntegers(int length) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(str);
        String[] strArray = str.split(" ");
        int[] intArray = new int[length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        s.close();
        return intArray;
    }

    public static void printArray(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.printf("Element %d contents %d%n", i, intArray[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
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
        return sortedArray;
    }
}
