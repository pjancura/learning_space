package java_17.challenge_questions.arrays_and_strings;

// rotate the matrix in place

import java.util.Arrays;

public class OnePointSeven {
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};

        System.out.println("Before: ");
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }

        int[][] rotatedMatrix = rotateMatrix(matrix);
        System.out.println("\nAfter: ");
        for (int[] arr : rotatedMatrix) {
            System.out.println(Arrays.toString(arr));
        }

        int[][] rotatedMatrix2 = rotateMatrix(rotatedMatrix);
        System.out.println("\nAfter 2: ");
        for (int[] arr : rotatedMatrix2) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //                                                                          MY SOLUTION - USES COPY
    public static int[][] rotateMatrix(int[][] matrix) {
        int[][] rotated = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int point = matrix[i][j];
                rotated[j][matrix.length - 1 - i] = point;
            }
        }
        return rotated;
    }

        //                                                                          MY SOLUTION - INPLACE
                                                                            //        my solution is basically the book solution, except they make the swaps without the intermediary step of all of the variables
        public static int[][] rotateMatrixInPlace(int[][] matrix) {
    
            for (int i = 0; i < Math.floor(matrix.length / 2); i++) {
                for (int j = 0; j < Math.floor(matrix[0].length / 2); j++) {
                    int pointOne = matrix[i][j];
                    int pointTwo = matrix[j][matrix.length - 1 - i];
                    int pointThree = matrix[matrix[0].length - 1 - j][matrix.length - 1 - i];
                    int pointFour = matrix[matrix[0].length - 1 - j][i];
                    int temp = pointOne;
                    matrix[i][j] = pointFour;
                    matrix[matrix[0].length - 1 - j][i] = pointThree;
                    matrix[matrix[0].length - 1 - j][matrix.length - 1 - i] = pointTwo;
                    matrix[j][matrix.length - 1 - i] = temp;
                }
            }
            return matrix;
        }
}
