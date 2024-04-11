package java_17.challenge_questions.arrays_and_strings;

import java.util.Arrays;

public class MaximumSubarrayElements {

    public static void main(String[] args) {

        int[] arr = {5, 6, -3, 7, -13, 8, -2, 5, -6, 7, -11, 3, 10, -10, -6, -10, 7, 10};

        System.out.println(Arrays.toString(maximumSubarrayElements(arr)));
        
        int[] arr2 = {-1, -1, 0, 0, -1};
        
        System.out.println(Arrays.toString(maximumSubarrayElements(arr2)));
        
    }

    public static int[] maximumSubarrayElements(int[] arr) {
        int maxSum = arr[0];
        int currSum = arr[0];
        int startIndex = 0;
        int endIndex = 0;
        int tempStartIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (currSum >= 0) {
                currSum += arr[i];
            } else {
                currSum = arr[i];
            }
            if (currSum >= maxSum) {
                maxSum = currSum;
                endIndex = i + 1;
                if (tempStartIndex != 0) {
                    startIndex = tempStartIndex;
                }
            }

            if (currSum < 0) {
                tempStartIndex = i + 1;
            }
        }   
        int[] maxElements = Arrays.copyOfRange(arr, startIndex, endIndex);
        return maxElements;
    }
}