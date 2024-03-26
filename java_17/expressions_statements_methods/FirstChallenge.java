package java_17.expressions_statements_methods;

public class FirstChallenge {

    public static void main(String[] args) {
        displayHighScorePosition("Paul", calculateHighScorePosition(1500));
        displayHighScorePosition("Tom", calculateHighScorePosition(1000));
        displayHighScorePosition("Tim", calculateHighScorePosition(500));
        displayHighScorePosition("Tam", calculateHighScorePosition(100));
        displayHighScorePosition("Tum", calculateHighScorePosition(25));
        

        printMegaBytesAndKiloBytes(2500);

        areEqualByThreeDecimalPlaces(3.1256, 3.125);
    }

    public static int calculateHighScorePosition(int score){
        int position = 4;
        if (score >= 1000) {
            position = 1;
        } else if (score >= 500){
            position = 2;
        } else if (score >= 100){
            position = 3;
        }
        return position;
    }

    public static void displayHighScorePosition(String name, int leaderBoardPosition) {
        System.out.println(name + " managed to get into position " + leaderBoardPosition + " on the high score list");
    }

    public static double toMilesPerHour(double kilometersPerHour){
        if (kilometersPerHour < 0) {
            return -1;
        } else {
            double milesPerHour = Math.round(kilometersPerHour / 1.609);
            return (double) milesPerHour;
        }
    }
        
    public static void printConversion(double kilometersPerHour){
        double milesPerHour = toMilesPerHour(kilometersPerHour);
        if (milesPerHour < 0){
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + "km/h = " + milesPerHour + " mi/h");
        }    
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            int kiloBytesRemain = kiloBytes % 1024;
            int megaBytes = (kiloBytes - kiloBytesRemain) / 1024; 
            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + kiloBytesRemain + " KB");
            
        }
    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay){
        if (barking && (hourOfDay >= 0 && hourOfDay <= 23)){
            if (hourOfDay < 8 || hourOfDay > 22) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) {
            if (year % 4 == 0 && year % 100 != 0) {
                return true;
            } else if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean areEqualByThreeDecimalPlaces(double int1, double int2){
        int1 *= 1000;
        int2 *= 1000;
        int newInt1 = (int) int1;
        int newInt2 = (int) int2;
        System.out.println(newInt1 + " " + newInt2);
        if (newInt1 == newInt2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean hasEqualSum(int int1, int int2, int int3) {
        int newSum = int1 + int2;
        if (newSum == int3) {
            return true;
        }
        return false;
    }

    public static boolean hasTeen(int n1, int n2, int n3) {
        boolean boo1 = isTeen(n1);
        if (boo1) {
            return true;
        }
        boolean boo2 = isTeen(n2);
        if (boo2) {
            return true;
        }
        boolean boo3 = isTeen(n3);
        if (boo3) {
            return true;
        }
        return false;
    }

    public static boolean isTeen(int n1) {
        if (n1 >= 13 && n1 <= 19) {
            return true;
        } 
        return false;
    }
}