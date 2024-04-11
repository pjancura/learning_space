package java_17.challenge_questions.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

// string compression

public class OnePointSix {
    
    public static void main(String[] args) {
        String[] strings = {"paul", "ppaaaaulll", "paullly"};

        for (String s : strings) {
            System.out.println(compressor(s));
        }

        for (String s : strings) {
            System.out.println(compressorOne(s));
        }


    }

    //                                                                          MY SOLUTION 1
    //                                                                            implements StringBuilder, and counters, with checks for last characters
    public static String compressor(String s) {
        StringBuilder compressed = new StringBuilder();
        char currChar = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != currChar || i == s.length() - 1) {
                if (c == currChar && i == s.length() - 1) {
                    count++;
                }
                compressed.append(String.valueOf(currChar));
                compressed.append(String.valueOf(count));
                currChar = c;
                count = 1;
                if (i == s.length() - 1 && compressed.indexOf(String.valueOf(currChar)) < 0) {
                    compressed.append(String.valueOf(currChar));
                    compressed.append(String.valueOf(count));
                }
            } else {
                count++;
            }
            // System.out.println(currChar);
        }
        return compressed.length() < s.length() ? compressed.toString() : s;
    }

    //                                                                          BOOK SOLUTION 1
    public static String compressorOne(String s) {
        StringBuilder  compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < s.length(); i++) {
            countConsecutive++;

            // if next character is different than current, append this char to result.
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressed.append(s.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < s.length() ? compressed.toString() : s;
    }

    //                                                                           BOOK SOLUTION 2
    public static String compressorTwo(String s) {
        // check final length and return input string if it would be longer
        int finalLength = countCompression(s);
        if (finalLength >= s.length()) return s;

        StringBuilder compressed = new StringBuilder(finalLength);      //initial capacity
        int countConsecutive = 0;
        for (int i = 0; i < s.length(); i++) {
            countConsecutive++;

            // if next character is different than current, append this char to result.
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressed.append(s.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    public static int countCompression(String s) {
        int compressedLength = 0;
        int countConsecutive = 0;

        for (int i = 0; i < s.length(); i++) {
            countConsecutive++;

            // if next character is different than current, increase the length
            if ( i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }
}
