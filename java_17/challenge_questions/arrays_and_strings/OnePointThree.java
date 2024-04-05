package java_17.challenge_questions.arrays_and_strings;

import java.util.Arrays;

public class OnePointThree {
    
    public static void main(String[] args) {
        String smith = "Mr John Smith    ";

        System.out.println(urlify(smith));

        char[] smithArr = smith.toCharArray();
        urlifyBook(smithArr, 16);
        System.out.println(Arrays.toString(smithArr));
    }

    //                                                                      my solution 
    // i need to pay attention for what the inputs are / input data types
    public static String urlify(String s) {
        if (s.isEmpty()) {
            return "Please input a valid string";
        }
        return s.trim().replace(" ", "%20");
    }

    //                                                                      book solution 
    public static void urlifyBook(char[] s, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (s[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < s.length) {
            s[trueLength] = '\0';    // End array, adding in the null terminator is related to security of your system
            System.out.println(s[trueLength]);
        }
        System.out.println(Arrays.toString(s));
        for (i = trueLength - 1; i >= 0; i--) {
            if (s[i] == ' ') {
                s[index - 1] = '0';
                s[index - 2] = '2';
                s[index - 3] = '%';
                index = index - 3;
            } else {
                s[index - 1] = s[i];
                index--;
            }
        }
    }
}
