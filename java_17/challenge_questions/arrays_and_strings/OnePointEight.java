package java_17.challenge_questions.arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;

// if there is a 0 in a matrix, the values in both the row and column all become 0's

public class OnePointEight {
    
    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 0, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};

        zeroMatrix(matrix);

        for(int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //                                                                              MY SOLUTION
    public static int[][] zeroMatrix(int[][] matrix) {
        ArrayList<Integer> locations = findZeroes(matrix);
        System.out.println(locations);

        if (locations.size() == 0) {
            return matrix;
        }

        for (int i = 0; i < locations.size() - 1; i += 2) {
            zeroColumn(matrix, locations.get(i));
            zeroRow(matrix, locations.get(i + 1));
        }

        return matrix;
    }

    public static ArrayList<Integer> findZeroes(int[][] matrix) {
        // returns the points where 0's are located
        ArrayList<Integer> locations = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[j][i];
                if (value == 0) {
                    System.out.println(String.valueOf(i) + " " + String.valueOf(j));
                    locations.add(i);   // adds row coordinate
                    locations.add(j);   // adds column coordinate
                }
            }
        }
        return locations;
    }

    public static int[][] zeroColumn(int[][] matrix, int columnIndex) {
        // performs the Zeroing on the column
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][columnIndex] = 0;
        }

        return matrix;
    }

    public static int[][] zeroRow(int[][] matrix, int rowIndex) {
        // performs the zeroing on the row

        for (int i = 0; i < matrix[0].length; i++) {
            matrix[rowIndex][i] = 0;
        }

        return matrix;
    }
}
