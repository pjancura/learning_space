package java_17.array_notes;

import java.util.Arrays;

public class PartOne {

    public static void main(String[] args) {

        int[] myIntArray = new int[10];
        myIntArray[5] = 50;

        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 3.5;

        System.out.println(myDoubleArray[2]);

        int[] fivePositives = new int[] { 1, 2, 3, 4, 5 };
        System.out.println("first = " + fivePositives[2]);
        int arrayLength = fivePositives.length;
        System.out.println("length of array = " + arrayLength);
        System.out.println("last = " + fivePositives[arrayLength - 1]);

        int[] newArray = new int[5];
        // newArray = new int[]{5, 4, 3, 2, 1};
        for (int i = 1; i < newArray.length + 1; i++) {
            newArray[i - 1] = i;
        }
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }

        System.out.print("\n");

        // enhanced for loop
        for (int element : newArray) {
            System.out.print(element + " ");
        }

        System.out.println(Arrays.toString(newArray));

        Object objectVariable = newArray;
        if (objectVariable instanceof int[]) {
            System.out.println("objectVariable is really an int array");
        }

        Object[] objectArray = new Object[3];
        objectArray[0] = "Hello";
        objectArray[1] = new StringBuilder("World");
        objectArray[2] = newArray;

        System.out.println(Arrays.toString(objectArray));
        System.out.print("\n");

    }
}
