package java_17.array_notes;

import java.util.Arrays;

public class MultiDimensional {
    
    public static void main(String[] args) {
        
        int[][] array = {
                        {1, 2},
                        {3, 4},
                        {5, 6}
                        };

        // intArray is initizlied with an outer length of 3 but the inner length has not been defined
        //      this can be read as 3 null elements
        //      the outer length is 3, but the inner length of those 3 can be any length
        int[][] intArray = new int[3][];

        int[][] myDoubleArray = {{1, 2, 3},{4, 5, 6}};
        //   OR
        // int[] myDoubleArray[] = {{}, {}};

        int[][] array2 = new int[4][4];

        System.out.println(Arrays.toString(array2));

        for (int[] outer : array2) {
            System.out.println(Arrays.toString(outer));
        }

        for (int i = 0; i < array2.length; i++) {
            var innerArray = array2[i];
            for (int j = 0; j < innerArray.length; j++) {
                if (i > 0) {
                    innerArray[j] = i + j + array2[i - 1][array2[i - 1].length - i];
                } else {
                    innerArray[j] = i + j;
                }
                System.out.println(innerArray[j]);
            }
        }

        for (int[] outer : array2) {
            System.out.println(Arrays.toString(outer));
        }

        for (var outer : array2) {
            for (var element : outer) {
                System.out.print(element + " ");
            }
        }

        System.out.println();

        System.out.println(Arrays.deepToString(array2));

        System.out.println();

        array2[1] = new int[] {10, 20, 30};
        System.out.println(Arrays.deepToString(array2));

        Object[] multiIntArray = new Object[3];
        multiIntArray[0] = new int[3];
        multiIntArray[1] = new int[3][5];
        multiIntArray[2] = new int[3][3][3];
        System.out.println(Arrays.deepToString(multiIntArray));

        Object[] anyArray = new Object[3];
        System.out.println(Arrays.toString(anyArray));

        anyArray[0] = new String[] { "a", "b", "c"};
        System.out.println(Arrays.toString(anyArray));

        anyArray[1] = new String[][] {
                    {"1", "2"},
                    {"3", "4", "5"},
                    {"6", "7", "8", "9"}
        };
        System.out.println(Arrays.toString(anyArray));

        anyArray[2] = new int[2][2][2];
        System.out.println(Arrays.toString(anyArray));

        for (Object element : anyArray) {
            System.out.println("element type = " + element.getClass().getSimpleName());
            System.out.println("Element toString() = " + element);
            System.out.println(Arrays.deepToString((Object[]) element));

        }
    }
}
