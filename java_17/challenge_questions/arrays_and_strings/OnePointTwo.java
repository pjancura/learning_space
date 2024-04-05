package java_17.challenge_questions.arrays_and_strings;

import java.util.Arrays;

// given two strings, check if one is a permutation of the other

// ADDITIONAL DETAILS:
//  - is it case sensitive
//  - do i ignore whitespace

public class OnePointTwo {
    
    public static void main(String[] args) {
        String word1 = "paul";
        String word2 = "luap";
        System.out.println(isPermutation(word1, word2));

        System.out.println(isPermutationBook2(word1, word2));
    }
    

    //                                                              my solution
    public static boolean isPermutation(String str1, String str2) {
        String justChar1 = str1.replace(" ", "");
        String justChar2 = str2.replace(" ", "");
        str2.trim();
        if (justChar1.length() != justChar2.length() || (justChar2.length() == 0 && justChar1.length() == 0)) {
            return false;
        }
        char[] charArr1 = justChar1.toCharArray();
        Arrays.parallelSort(charArr1);
        char[] charArr2 = justChar2.toCharArray();
        Arrays.parallelSort(charArr2);
        for (int i = 0; i < justChar1.length(); i++) {
            if (Character.compare(charArr1[i], charArr2[i]) == 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    //                                                                 book solution
    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static boolean isPermutationBook(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return sort(str1).equals(sort(str2));
    }

    //                                                                 book solution 2
    public static boolean isPermutationBook2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] letters = new int[128];       // represents all chars in ASCII
        char[] arr1 = str1.toCharArray();
        for (char c : arr1) {
            letters[c]++;                   // increments value at the ASCII values index
        }

        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;

    }



}
