package java_17.array_notes;

import java.util.Arrays;

public class ArrayReferences {
    
    public static void main(String[] args) {
        

        //both of these arrays point to the same array in memory
        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray;

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("myIntArray = " + Arrays.toString(anotherArray));

        anotherArray[0] = 1;
        modifyArray(anotherArray);
        System.out.println(("after change myIntArray = " + Arrays.toString(myIntArray)));
        System.out.println(("after change anotherArray = " + Arrays.toString(anotherArray)));
    }

    private static void modifyArray(int[] array) {
        array[1] = 2;
    }
}
