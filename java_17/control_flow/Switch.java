package java_17.control_flow;

public class Switch {

    public static void main(String[] args) {
        int value = 1;
        if (value ==1) {
            System.out.println("Value was 1");
        } else if (value == 2) {
            System.out.println("Value was 2");
        } else {
            System.out.println("Was not 1 or 2");
        }

        // new way with a switch statement
        value = 4;
        // switch types can only be 
        // primitives: byte, short, int, char (and their corresponding wrappers)
        // can also use String or enum's
        switch(value){
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:                         // this groups cases wish similar functions
                System.out.println("was 3, 4, or 5");
                System.out.println("It was " + value);
                break;
            default:
                System.out.println("Was not 1 or 2");
                break;
        }

        // improved "enhanced" switch statement
        switch (value) {
            case 1 -> System.out.println("Value was 1");
            case 2 -> System.out.println("Value was 2");
            case 3, 4, 5 -> {                         // this groups cases wish similar functions
                System.out.println("was 3, 4, or 5");
                System.out.println("It was " + value);
            }
            default -> System.out.println("Was not 1 or 2");
        }

        System.out.println((getQuarter("May")));
        System.out.println((getQuarter("mug")));

        System.out.println("CAR is " + natoAlphaReplacement('c') + ", " + natoAlphaReplacement('a') + ", " + natoAlphaReplacement('r') + ".");
     
        printDayOfWeek(0);
        printDayOfWeek(4);
        printDayOfWeek(15);
        

    }

    public static String getQuarter(String month) {
        return switch (month) {
            case "January", "February", "March" -> { yield "1st"; }     // the yield is implied normally, but can be used to return something that has been calculated like in the default case
            case "April", "May", "June" -> "2nd";
            case "July", "August", "September" -> "3rd";
            case "October", "November", "December" -> "4th";
            default -> {
                String badInput = "Invalid Month: " + month;
                yield badInput;
            }
        };
    }

    // switch challenge 1
    public static String natoAlphaReplacement(char c) {
        // only go through "e"
        return switch (c) {
            case 'a' -> "Alpha";
            case 'b' -> "Bravo";
            case 'c' -> "Charlie";
            case 'd' -> "Delta";
            case 'e' -> "Echo";
            default -> "Letter " + c + " Invalid";
        };
    }

    // switch challenge 2
    public static void printDayOfWeek(int day) {
        String dayOfWeek = switch (day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid entry " + day + ". Number must be 0 - 6.";
        };
        System.out.println("The day is " + dayOfWeek);
    }

    // ex 13
    public static void printNumberInWord(int num) {
        String word = switch (num) {
            case 0 -> "ZERO";
            case 1 -> "ONE";
            case 2 -> "TWO";
            case 3 -> "THREE";
            case 4 -> "FOUR";
            case 5 -> "FIVE";
            case 6 -> "SIX";
            case 7 -> "SEVEN";
            case 8 -> "EIGHT";
            case 9 -> "NINE";
            default -> "OTHER";
        };
        System.out.println(word);
    }

    // ex 14
    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 10000){
            return false;
        } else {
            if (year % 4 == 0) {
                if (year > 99) {
                    if (year % 100 == 0) {
                        if (year % 400 == 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return true;                        
                    }
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    public static int getDaysInMonth(int month, int year){
        if (year < 1 || year > 9999){
            if (isLeapYear(year) && month == 2){
                return 29;
            } else {
                return switch (month) {
                    case 1 -> 31;
                    case 2 -> 28;
                    case 3 -> 31;
                    case 4 -> 30;
                    case 5 -> 31;
                    case 6 -> 30;
                    case 7 -> 31;
                    case 8 -> 31;
                    case 9 -> 30;
                    case 10 -> 31;
                    case 11 -> 30;
                    case 12 -> 31;
                    default -> -1;
                };
            }
        } else {
            return -1;
        }
    }

}