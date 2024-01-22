package java_17.control_flow;

// next time setup a Scanner object to only close at the end of main
// b/c once the System.in is closed, it can't be reopened
import java.util.Scanner;

public class SystemConsole {

    public static void main(String[] args) {
        int currentYear = 2024;
        String usersDateOfBirth = "1999";

        System.out.println("Age = " + (currentYear - Integer.parseInt(usersDateOfBirth)));

        // try {
        //     System.out.println(getInputFromConsole(currentYear));
        // } catch (NullPointerException e) {
        //     System.out.println(getInputFromScanner(currentYear));
        // } 
        // System.out.println(getInputFromScanner(currentYear));
        // printMinMax();
        // sumFiveNumber();
        // inputThenPrintSumAndAverage();
        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(7.32, 6.45, 2.22, 10));
        System.out.println(getBucketCount(3.4, 1.5));
    }

    public static int checkData(int currentYear, String dateOfBirth) {
        int dob = Integer.parseInt(dateOfBirth);
        int minimumYear = currentYear - 125;

        if ((dob < minimumYear) || (dob > currentYear)) {
            return -1;
        }

        return(currentYear - dob);
    }

    public static String getInputFromConsole(int currentYear) {
        String name = System.console().readLine("Hi, What's your Name? \n");
        System.out.println("Hi " + name + ", Thanks for taking the course!");
        int age = 0;
        boolean isYearValid = false;
        do {
            try {
                String dateOfBirth = System.console().readLine("What year were you born? \n");
                age = checkData(currentYear, dateOfBirth);
                if (age > 0) {
                    isYearValid = true;
                }
            } catch (NumberFormatException badUserData) {
                System.out.println("Alpha characters not allowed in string. Use numeric characters only. Try again.");
            }
        } while (!isYearValid);
        return "You are " + String.valueOf(age) + " years old";
    }

    // a simple text scanner which can parse primitive types and strings
    public static String getInputFromScanner(int currentYear) {
        Scanner scanner = new Scanner(System.in);               // instantiates a new instance of scanner
        System.out.println("Hi, What's your Name?");
        String name = scanner.nextLine();                                   
        System.out.println("Hi " + name + ", Thanks for taking the course!");
        int age = 0;
        boolean isYearValid = false;
        do {
            System.out.println("What year were you born?");
            try {
                String dateOfBirth = scanner.nextLine();
                age = checkData(currentYear, dateOfBirth);
                if (age > 0) {
                    isYearValid = true;
                }
            } catch (NumberFormatException badUserData) {
                System.out.println("Characters not allowed, try again.");
            }
        } while (!isYearValid);
        scanner.close();
        return "You are " + String.valueOf(age) + " years old";
    }

    // challenge
    public static boolean checkPositiveNumber(int number) {
        if (number > 0) {
            return true;
        }
        return false;
    }

    public static void sumFiveNumber() {
        int sum = 0;
        int counter = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's add five positive integers together");
        do {
            System.out.println("Enter integer " + counter);
            try {
                String num = scanner.nextLine();
                int numInt = Integer.parseInt(num);
                boolean isValidInput = checkPositiveNumber(numInt);
                if (isValidInput) {
                    sum += numInt;
                    counter++;
                } else {
                    System.out.println("Value must be positive");
                }
            } catch (NumberFormatException badInput) {
                System.out.println("value must be positive integer. Try again");
            }
            System.out.println("Current sum: " + sum);
        } while (counter <= 5);
        scanner.close();
    }
    
    // challenge min max
    public static void printMinMax() {
        int min = 0;
        int max = 0;
        Scanner scanner = new Scanner(System.in);
        boolean game = true;
        do {
            System.out.println("Please enter a new number, or enter -1 to quit.");
            try {
                String numStr = scanner.nextLine();
                int numInt = Integer.parseInt(numStr);
                if (numInt == -1) {
                    game = false;
                    break;
                }
                if (checkPositiveNumber(numInt)) {  
                    if (max == 0 || min == 0) {
                        max = numInt;
                        min = numInt;
                    } else if (numInt > max) {
                        max = numInt;
                    } else if (numInt < min) {
                        min = numInt;
                    }
                } else {
                    System.out.println("Please enter a positive integer");
                }
            } catch (NumberFormatException badInput) {
                System.out.println("Input " + badInput + " is invalid. It must be numerical.  Try again.");
            }
        } while (game);
        System.out.println("Your maximum input was " + max + ", and your minimum input was " + min + ".");
        scanner.close();
    }

    // ex 28
    public static void inputThenPrintSumAndAverage() {
        int sum = 0;
        int counter = 0;
        long average = 0;
        Scanner scanner = new Scanner(System.in);
        boolean averaging = true;
        do {
            try {
                String numStr = scanner.nextLine();
                int numInt = Integer.parseInt(numStr);
                sum += numInt;
                counter++;
            } catch (NumberFormatException badInput) {
                if (sum != 0 && counter != 0) {
                    average = Math.round((double) sum / counter);
                }
                System.out.println("SUM = " + sum + " AVG = " + average);
                averaging = false;
            }
        } while (averaging);
        scanner.close();
    }

    // ex 29
    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        } else {
            double area = width * height;
            double bucketsNeeded = Math.ceil(area / areaPerBucket);
            // System.out.println("bucketsNeeded: " + bucketsNeeded);
            return ((int) bucketsNeeded) - extraBuckets;
        }
    }

        // overloaded ex 29
    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return -1;
        } else {
            double area = width * height;
            double bucketsNeeded = Math.ceil(area / areaPerBucket);
            return ((int) bucketsNeeded);
        }
    }
        // overloaded 2 ex 29
    public static int getBucketCount(double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        } else {
            double bucketsNeeded = Math.ceil(area / areaPerBucket);
            // System.out.println("bucketsNeeded: " + bucketsNeeded);
            return ((int) bucketsNeeded);
        }
    }
}