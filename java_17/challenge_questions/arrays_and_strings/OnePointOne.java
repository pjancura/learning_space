package java_17.challenge_questions.arrays_and_strings;

import java.util.ArrayList;

public class OnePointOne {
    
    public static void main(String[] args) {
        String[] words = {"word", "bath", "theresa", "books"};


       for (String word : words) {
           System.out.println(isUniqueChars(word));
       } 
    }
    // remember to ask what type of symbols are in the string...unicode or ASCII
    // unicode would require a lot bigger array to store the true / false values

    //                                                     my solution
    public static boolean isUniqueChars(String str) {
        if (str.length() == 0 || str.length() > 128) {
            return false;
        }
        ArrayList<Character> arr = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if (arr.contains(s)) {
            return false;
            }
            arr.add(s);
       }
       return true; 
    }

    //                                                      book solution
    //                                                          time O(n) -> the length of the string, space O(c) -> the number of values that are being stored in char_set
    public static boolean isUniqueCharsBook(String str) {
        if (str.length() == 0 || str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];      // 128 represents the number characters ASCII
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);                // converts the char to unicode int value
            if (char_set[val]) {                    // checks if value is true, and returns false if it is
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}
