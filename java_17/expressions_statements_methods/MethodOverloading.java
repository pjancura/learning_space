// Method overloading is when you have a method of the same name,
// but the number and type of arguments differ from one another
// Java can take care of resolving which method is being invoked
// based on the arguments being passed
// a method signature is the name plus the parameters being passed (order and/or number)

package java_17.expressions_statements_methods;

public class MethodOverloading {
    public static void main(String[] args) {
        int newScore = calculateScore("Time", 500);
        System.out.println("New score is " + newScore);
        calculateScore(400);
        calculateScore();

        System.out.println(convertToCentimeters(72));
        System.out.println(convertToCentimeters(6, 0));
        System.out.println(convertToCentimeters(6, 6));

        System.out.println(getDurationString(3600));
        System.out.println(getDurationString(60, 60));
        System.out.println(getDurationString(3945));



    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        return calculateScore("Anonymous", score);
    }

    public static int calculateScore() {
        System.out.println("Unnamed Player " + "scored 300 points");
        return 0;
    }

    // this one is not unique because only the return type has been changed
    // public static void calculateScore() {
    //     System.out.println("Unnamed Player " + "scored 300 points");
    // }

    // challenge 1
    public static double convertToCentimeters(int inches){
        return ((double) inches) * 2.54;
    }

    public static double convertToCentimeters(int feet, int inches){
        int totalInches = (feet * 12) + inches;
        return (convertToCentimeters(totalInches));
    }

    // challenge 2
    public static String getDurationString(int seconds){
        int hours = seconds / 3600;
        int minutes = (seconds - (hours * 3600)) / 60;
        int second = seconds - (hours * 3600) - (minutes * 60);
        return hours + "h " + minutes + "m " + second + "s " ;
    }

    public static String getDurationString(int minutes, int seconds){
        int totalSeconds = (minutes * 60) + seconds;
        return getDurationString(totalSeconds);
    }

    // ex 1
    public static double area(double radius){
        if (radius < 0){
            return -1;
        } else {
            return 3.141592653589 * (radius * radius);
        }
    }

    public static double area(double xDim, double yDim){
        if (xDim < 0 || yDim < 0) {
            return -1;
        } else {
            return xDim * yDim;
        }
    }

    // ex 2

    public static void printYearsAndDays(long minutes){
        if (minutes < 0) {
            System.out.println("Invalid Value");
        } else {
            long years = minutes / (60 * 24 * 365);
            long days = (minutes - (years * (60 * 24 * 365))) / (60 * 24);
            System.out.println(minutes + " min = " + years + " y and " + days + " d");
        }
    }

    // ex 3
    public static void printEqual(int n1, int n2, int n3){
        if (n1 < 0 || n2 < 0 || n3 < 0){
            System.out.println("Invalid Value");
        } else if (n1 != n2 && n2 != n3 && n3 != n1) {
            System.out.println("All numbers are different");
        } else if (n1 == n2 && n2 == n3){
            System.out.println("All numbers are equal");
        } else if (n1 == n2 && n3 != n1){
            System.out.println("Neither all are equal or different");
        } else if (n2 == n3 && n2 != n1){
            System.out.println("Neither all are equal or different");
        } else if (n3 == n1 && n3 != n2){
            System.out.println("Neither all are equal or different");
        }
    }

    // ex 4
    public static boolean isCatPlaying(boolean summer, int temperature){
        if (temperature >= 25 && temperature <= 35){
            return true;
        } else {
            if (summer){
                if (temperature >= 35 && temperature <= 45){
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}