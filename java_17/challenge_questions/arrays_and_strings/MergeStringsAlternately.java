package java_17.challenge_questions.arrays_and_strings;

import java.lang.StringBuilder;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        
    }

    public String mergeAlternately(String word1, String word2) {
        if (word1.length() == 0 && word2.length() > 0) {
            return word2;
        } else if (word1.length() > 0 && word2.length() == 0) {
            return word1;
        }
        StringBuilder merged = new StringBuilder();
        int longerWord = word1.length() >= word2.length() ? word1.length() : word2.length();
        String[] array1 = word1.split("");
        String[] array2 = word2.split("");
        for (int i = 0; i < longerWord; i++) {
            if (array1.length > 0) {
                merged.append(array1[i]);
            }
            if (array2.length > 0) {
                merged.append(array2[i]);
            }
        }

        return merged.toString();
    }
}