package java_17.array_notes;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {
    
    public static void main(String[] args) {
        System.out.println("Enter a comma separated list of integers:\n");
        int[] intArray = readIntegers();
        System.out.println(Arrays.toString(intArray));
        System.out.println(findMin(intArray));
    }

    public static int[] readIntegers() {
        Scanner s = new Scanner(System.in);
        String[] sArray = s.nextLine().split(",");
        int[] intArray = new int[sArray.length];
        for (int i = 0; i < sArray.length; i++) {
            intArray[i] = Integer.parseInt(sArray[i]);
        }
        s.close();
        return intArray;
    }

    public static int findMin(int[] intArray) {
        Arrays.sort(intArray);
        return intArray[0];
    }
}
