package java_17.challenge_questions.arrays_and_strings;

import java.util.Arrays;

// build a palindrome permutation checker
//      ignore case
//      you can input any string and check if it can be turned into a palindrome
//      palindromes can have at most 1 odd count of character 

public class OnePointFour {
    
    public static void main(String[] args) {
        String input = "Tact Coa";

        boolean value = isPalindromePermutation(input);
        System.out.println(value);
    }

    //                                                                      my solution
    public static boolean isPalindromePermutation(String str) {
        if (str.isEmpty()) {
            return false;
        }
        
        String modifiedStr = str.toLowerCase().replace(" ", "");

        int[] charSet = new int[128];

        for (int i = 0; i < modifiedStr.length(); i++) {
            charSet[modifiedStr.charAt(i)]++;
        }
        System.out.println(Arrays.toString(charSet));
        int odd = 0;
        for (int j = 0; j < charSet.length; j++) {
            if (charSet[j] % 2 == 1) {
                odd++;
            }
        }
        System.out.println(odd + " " + modifiedStr.length() + " " + (modifiedStr.length() % 2));
        if (modifiedStr.length() % 2 != 0 && odd == 1) {
            return true;
        } else if (modifiedStr.length() % 2 == 0 && odd == 0) {
            return true;
        } else {
            return false;
        }
    }

    //                                                                  book solution #1
    public static boolean isPalindromePermutationOne(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }


    // this will work for even lengthed strings as well
    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    // this is case insensitive
    // maps each char to its value, this reduces the size of the ASCII charSet that I created
    // non-letter characters map to -1
    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    // count how many times each character appears
    public static int[] buildCharFrequencyTable(String phrase) {
        int [] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

        //                                                                  book solution #2
        // similar to what I came up with but will use less space and is more easily read
        public static boolean isPermutationOfPalindromeTwo(String phrase) {
            int countOdd = 0;
            int [] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
            for (char c : phrase.toCharArray()) {
                int x = getCharNumber(c);
                if (x != -1) {
                    table[x]++;
                    if (table[x] % 2 == 1) {
                        countOdd++;
                    } else {
                        countOdd--;
                    }
                }
            }
            return countOdd <= -1;
        }

        //                                                                  book solution #3
        //  this implements a bit vector to determine the palindrome
        public static boolean isPermutationOfPalindrom(String phrase) {
            int bitVector = createBitVector(phrase);
            return bitVector == 0 || checkExactlyOneBitSet(bitVector);
        }

        // creates a bitvector for the string
        //  for each letter with value i, toggle the i-th bit
        public static int createBitVector(String phrase) {
            int bitVector = 0;
            for (char c : phrase.toCharArray()) {
                int x = getCharNumber(c);
                bitVector = toggle(bitVector, x);
            }
            return bitVector;
        }

        public static int toggle(int bitVector, int index) {
            if (index < 0) return bitVector;

            int mask = 1 << index;
            if ((bitVector & mask) == 0) {
                bitVector |= mask;
            } else {
                bitVector &= ~mask;
            }
            return bitVector;
        }

        public static boolean checkExactlyOneBitSet(int bitVector) {
            return (bitVector & (bitVector - 1)) == 0;
        }
}
