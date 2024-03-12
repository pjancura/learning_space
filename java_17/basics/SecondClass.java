package java_17.basics;

public class SecondClass {
    public static void main(String[] args) {
        System.out.print("Hello, Paul\n");
        System.out.print("Hello, Theresa\n");

        boolean isAlien = false;
        if (!isAlien){
            System.out.print("It is not an alien!\n");
            System.out.print("I am scared of aliens!\n");
        }

        int topScore = 80;
        if (topScore >= 100){
            System.out.print("You got the high score!");
        }

        int secondTopScore = 95;
        if (topScore > secondTopScore && topScore < 100){
            System.out.print("Greater than second top score and less than 100");
        }

        if ((topScore > 90) || (secondTopScore <= 90)){
            System.out.print("either or both of the conditions are true");
        }

        boolean isCar = false;
        if (!isCar) {
            System.out.print("This is not supposed to happen\n");
        }

        String makeOfCar = "Volkswagon";
        boolean isDomestic = makeOfCar == "VolksWagon" ? false : true;      // ternary operator example
        if (isDomestic) {
            System.out.print("A " + makeOfCar + " is Domestic\n");
        }

        String s = (isDomestic) ? "This car is domestic\n" : "This car is not domestic\n";
        System.out.print(s);

        // operator precedence challenge
        double value1 = 20.00d;
        double value2 = 80.00d;
        double total = (value1 + value2) * 100.00d;
        double remainder = total % 40.00d;
        System.out.println(remainder);
        boolean isRemainder = (remainder == 0.00d) ? true : false;
        System.out.print(isRemainder + "\n");
        if (!isRemainder) {
            System.out.print("got Some Remainder\n");
        }

        System.out.print("\n");
    }
}
