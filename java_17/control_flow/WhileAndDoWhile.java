package java_17.control_flow;

public class WhileAndDoWhile {

    public static void main(String[] args) {
        // while loop, will only run if the expression is true at the beginning of the loop
        int j = 1;
        while (j <= 5) {
            System.out.println("While " + j);
            j++;
        }

        // do while loop, will run at least once
        do {
            System.out.println("Do/While " + j);
            j++;
        } while (j <= 5);

        int start = 5;
        int end = 21;
        int counter = 0;
        int sumEven = 0;
        while (start <= end) {
            // System.out.println(start);
            if (isEvenNumber(start)) {
                counter++;
                System.out.println(start);
                sumEven += start;
            }
            if (counter == 5) {
                break;
            }
            start++;
        }
        System.out.println(sumEven);

        System.out.println(sumDigits(125));
        System.out.println(sumDigits(225));
        System.out.println(sumDigits(1000));
        System.out.println(sumDigits(1025));

        System.out.println(isPalindrome(111222111));
        System.out.println(isPalindrome(11122211));


        System.out.println(sumFirstAndLastDigit(252));
        System.out.println(sumFirstAndLastDigit(-252));
        System.out.println(sumFirstAndLastDigit(28906));
        System.out.println(sumFirstAndLastDigit(7));

        System.out.println(reverse(-2521));
        numberToWords(10);
        numberToWords(1450);

        System.out.println(getLargestPrime(21));
        System.out.println(getLargestPrime(31));
        System.out.println(getLargestPrime(2));
        System.out.println(getLargestPrime(45));


        printSquareStar(8);
        printSquareStar(5);
        printSquareStar(20);
        printSquareStar(61);
    }

    // class methods
    // challenge 1
    public static boolean isEvenNumber(int num) {
        if (num % 2 == 0) {
            return true;
        } 
        return false;
    }

    // challenge 2
    public static int sumDigits(int number) {
        if (number < 0) {
            return -1;
        } else {
            int sum = 0;
            while ( number > 0 ) {
                int holder = number % 10;
                //System.out.println(holder);
                sum += holder;
                number /= 10;
            }


            return sum;
        }
    }

    // ex 1
    public static boolean isPalindrome(int number) {
        int hold = number;
        int reverse = 0;
        // int counter = 0;
        while (number > 9) {
            reverse *= 10;
            reverse += (number % 10);    
            number /= 10;
            //counter++;
        }
        reverse *= 10;
        reverse += number;
        if (reverse == hold) {
            return true;
        } else {
            return false;
        }
    }

    // ex 2
    public static int sumFirstAndLastDigit(int number) {
        int sum = 0;
        if (number < 0) {
            return -1;
        } else if (number < 10 ) {
            sum = number * 2;
            return sum;
        }
        int counter = 0;
        while (number > 9) {
            if (counter == 0) {
                sum += number % 10;
                number /= 10;
            } else {
                number /= 10;
            }
            counter++;
        }
        sum += number;
        return sum;
    }

    // ex 3
    public static int getEvenDigitSum(int number) {
        int sum = 0;
        if (number < 0) {
            return -1;
        } 
        while (number > 9) {
            int hold = number % 10;
            if (hold % 2 == 0) {
                sum += hold;
            }
            number /= 10;

        }
        if (number % 2 == 0) {
            sum += number;
        }
        return sum;
    }

    // ex 4
    public static boolean hasSharedDigit(int num1, int num2) {
        boolean result = false;
        if (num1 < 10 || num1 > 99) {
            return result;
        } else if (num2 < 10 || num2 > 99) {
            return result;
        }
        while (num1 > 0) {
            int hold = num1 % 10;
            int tempNum2 = num2;
            for (int i = 1; i <= 2; i++) {
                int hold2 = tempNum2 % 10;
                if (hold == hold2) {
                    result = true;
                    break;
                }
                tempNum2 /= 10;               
            }
            num1 /= 10;
        }
        return result; 
    }

    // ex 5
    public static boolean isValid(int n) {
        if (n < 10 || n > 1000) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean hasSameLastDigit(int n1, int n2, int n3) {
        boolean result = false;
        if (!isValid(n1)) {
            return result;
        } else if (!isValid(n2)) {
            return result;
        } else if (!isValid(n3)) {
            return result;
        }
        int hold1 = n1 % 10;
        int hold2 = n2 % 10;
        int hold3 = n3 % 10;
        if (hold1 == hold2 || hold2 == hold3 || hold3 == hold1) {
            result = true;
        } 
        return result;
    }

    // ex 21
    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
        }
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }

    // ex 22
    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }
        int greatestCommonDivisor = 0;
        int smallerNum = first;
        if (first >= second) {
            smallerNum = second;
        }        
        for (int i = 1; i <= smallerNum; i++) {
            int remainderFirst = first % i;
            int remainderSecond = second % i;
            if ((remainderFirst == 0) && (remainderSecond == 0)) {
                greatestCommonDivisor = i;
            }
        }
        return greatestCommonDivisor;
    }

    // ex 23
    public static boolean isPerfectNumber(int number) {
        boolean result = false;
        if (number < 1) {
            return result;
        }
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        if (sum == number) {
            result = true;
        }
        return result;
    }

    // ex 24
    public static int getDigitCount(int number) {
        int counter = 0;
        if (number < 0) {
            return -1;
        }
        while (number > 9) {
            number /= 10;
            counter++;
        }
        number /= 10;
        counter++;
        return counter;
    }

    public static int reverse(int number) {
        int posNum = number;
        // if (posNum < 0) {
        //     posNum *= -1;
        // }
        int reversed = 0;
        while (posNum != 0) {
            reversed *= 10;
            reversed += posNum % 10;
            posNum /= 10;
        }
        // reversed *= 10;
        // reversed += posNum;
        // if (number < 0) {
        //     reversed *= -1;
        // }
        return reversed;
    }

    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        } else {
            int numberOfDigits = getDigitCount(number);
            int reversed = reverse(number);
            int reversedNumberOfDigits = 0;

            String strNum = "";
            while (reversed > 9) {
                int currentNum = reversed % 10;
                switch (currentNum) {
                    case 0 -> strNum = "Zero";
                    case 1 -> strNum = "One";
                    case 2 -> strNum = "Two";
                    case 3 -> strNum = "Three";
                    case 4 -> strNum = "Four";
                    case 5 -> strNum = "Five";
                    case 6 -> strNum = "Six";
                    case 7 -> strNum = "Seven";
                    case 8 -> strNum = "Eight";
                    case 9 -> strNum = "Nine";
                    default -> strNum = "";
                };
                System.out.println(strNum);
                reversed /= 10;
                reversedNumberOfDigits++;
            }
            int currentNum = reversed % 10;
            switch (currentNum) {
                case 0 -> strNum = "Zero";
                case 1 -> strNum = "One";
                case 2 -> strNum = "Two";
                case 3 -> strNum = "Three";
                case 4 -> strNum = "Four";
                case 5 -> strNum = "Five";
                case 6 -> strNum = "Six";
                case 7 -> strNum = "Seven";
                case 8 -> strNum = "Eight";
                case 9 -> strNum = "Nine";
                default -> strNum = "";
            };
            reversedNumberOfDigits++;
            System.out.println(strNum);
            // System.out.println(reversedNumberOfDigits + " " + numberOfDigits);
            if (reversedNumberOfDigits < numberOfDigits) {
                for (int i = reversedNumberOfDigits; i < numberOfDigits; i++) {
                    System.out.println("Zero");
                }
            }
        }
    }

    // ex 25
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        int packed = 0;
        if (bigCount > 0) {
            for (int i = 1; i <= bigCount; i++) {
                if (packed != goal && (packed + 5) <= goal) {
                    packed += 5;
                }
                if (packed == goal) {
                    break;
                } 
            }
        }
        if (smallCount > 0 && packed != goal) {
            for (int i = 1; i <= smallCount; i++) {
                if (packed != goal && (packed + 1) <= goal) {
                    packed += 1;
                }
                if (packed == goal) {
                    break;
                } 
            }
        }
        if (packed == goal) {
            return true;
        } else {
            return false;
        }
    }

    // ex 26
    public static int getLargestPrime(int number) {
        if (number < 2) {
            return -1;
        }
        int largestPrime = 0;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                if (i == 2 || i == 3) {
                    largestPrime = i;
                } else {
                    boolean primeFlag = true;
                    for (int j = 2; j <= i / 2; j++) {
                        if (i % j == 0) {
                            primeFlag = false;
                            break;
                        }
                    }
                    if (primeFlag) {
                        largestPrime = i;
                    }
                }
            }
        }
        return largestPrime;
    }

    // ex 27
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        } else {
            for (int i = 1; i <= number; i++) {
                String output = "";
                for (int j = 1; j <= number; j++) {
                    if (i == 1 || i == number) {
                        output += "*";
                    } else if (j == 1 || j == number) {
                        output += "*";
                    } else if (j == (number - i + 1)) {
                        output += "*";
                    } else if (j == i) {
                        output += "*";
                    } else {
                        output += " ";
                    }
                }
                System.out.println(output);
            }
        }
    }
}