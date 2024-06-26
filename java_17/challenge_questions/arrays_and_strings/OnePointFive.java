package java_17.challenge_questions.arrays_and_strings;

import java.util.Arrays;

public class OnePointFive {
    
    public static void main(String[] args) {
        String[] s1 = {"pale", "bake", "llllllloooouy", "aaa", "aab", "a", "theresa", "pale"};
        String[] s2 = {"ple", "pale", "ppppppppppppoooouy", "bbb", "aaa", "bbb", "teresa", "plae"};

        for (int i = 0; i < s1.length; i++) {
            System.out.println(isOneEditAway(s1[i], s2[i]));
        }

        System.out.println("\nBook Solution 1");

        for (int i = 0; i < s1.length; i++) {
            System.out.println(isOneEditAwayOne(s1[i], s2[i]));
        }

    }
    //                                                                  MY SOLUTION
    //                                                                      i think i have accounted for all cases, it uses a lot more memory, but gets the job done in i believe O(n) time
    //                                                                      ****  found out my solution does not work when the words are a permutation of each other ****
    //                                                                          ****   i originally thought that permutations were to be accounted for as well, but that is not the case ****
    public static boolean isOneEditAway(String s1, String s2) {
        StringBuilder sB1 = new StringBuilder(s1);
        StringBuilder sB2 = new StringBuilder(s2);
        int longer = s1.length();
        String longString = s1;

        if (s2.length() > s1.length()) {
            longer = s2.length();
            longString = s2;
        }
        for (int i = 0; i < longer; i++) {
            String currChar = String.valueOf(longString.charAt(i));
            int index1 = sB1.indexOf(currChar);
            int index2 = sB2.indexOf(currChar);
            if (index1 > -1 && index2 > -1) {
                sB1.deleteCharAt(index1);
                sB2.deleteCharAt(index2);
            }
        }
        if (sB1.length() > 1 || sB2.length() > 1) {
            return false;
        }
        return true;
    }

    //                                                                  FIRST BOOK SOLUTION
    //                                                               
    public static boolean isOneEditAwayOne(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() -1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    public static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    public static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        } 
        return true;

    }

    //                                                                  SECOND BOOK SOLUTION
    public static boolean oneEditAway(String first, String second) {
        // length checks
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        // get shorter and longer string
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                // ensure that this is the first difference found
                if (foundDifference) return false;
                foundDifference = true;
                if (s1.length() == s2.length()) {       // on replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++;       // if matching, move shorter pointer
            }
            index2++;       // always move pointer for longer string
        }
        return true; 
    }
}
