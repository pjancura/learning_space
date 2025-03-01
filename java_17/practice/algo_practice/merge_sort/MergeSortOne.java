package java_17.practice.algo_practice.merge_sort;

import java.util.Arrays;

public class MergeSortOne {

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4, 5 }, // [1, 2, 3, 4, 5]
                { 5, 4, 3, 2, 1 }, // [1, 2, 3, 4, 5]
                { 4, 2, 4, 3, 1, 3 }, // [1, 2, 3, 3, 4, 4]
                { 42 }, // [42]
                {} // []
        };

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(mergeSort(arr[i])));
        }

    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = Math.floorDiv(arr.length, 2);
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        int[] mergedLeft = mergeSort(left);
        int[] mergedRight = mergeSort(right);

        return mergeTwoLists(mergedLeft, mergedRight);
    }

    private static int[] mergeTwoLists(int[] a, int[] b) {
        int[] result = new int[(a.length + b.length)];

        int lenA = a.length;
        int lenB = b.length;
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < lenA && j < lenB) {
            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < lenA) {
            result[k] = a[i];
            i++;
            k++;
        }

        while (j < lenB) {
            result[k] = b[j];
            j++;
            k++;
        }

        return result;
    }
}