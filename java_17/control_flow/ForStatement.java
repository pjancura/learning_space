package java_17.control_flow;

public class ForStatement {

    public static void main(String[] args) {
        for (int counter = 1; counter <= 5; counter++){
            System.out.println(counter);
        }

        
        for (double rate = 2.00; rate <= 5.0; rate++) {
            System.out.println("10,000 at " + rate + "% interest = $" + calculateInterest(10000.00, rate));
        }
        
        for (double rate = 7.5; rate <= 10.0; rate += 0.25) {
            double interestAmount = calculateInterest(100.00, rate);
            if (interestAmount > 8.5){
                break;
            }
            System.out.println("$100 at " + rate + "% interest = $" + interestAmount);
        }

        for (int i = 0; i <= 25; i++){
            System.out.println(i + " is " + (isPrime(i) ? "" : "NOT ") + "a prime number");
        }

        primeCounter();

        sum3And5();

        System.out.println(sumOdd(1, 11));
    }
    // start class functions

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }

    public static boolean isPrime(int num){
        if (num <= 2) {
            return (num == 2);
        } else {
            for (int i = 2; i <= (num / 2); i++){
                if (num % i == 0){
                    return false;
                }
            } 
            return true;
        }
    }

    // challenge 1
    public static void primeCounter(){
        int counter = 0;
        for (int i = 0; i <= 1000; i++){
            if (counter == 3){
                System.out.println("Found " + counter + " prime numbers after running " + i + " times.");
                break;
            } else {
                if (isPrime(i)) {
                    counter++;
                }
            }
        }
    }

    // challenge 2
    public static void sum3And5(){
        int sum = 0;
        int counter = 0;
        for (int i = 1; i <= 1000 && counter < 5; i++){
            if (i % 3 == 0 && i % 5 == 0){
                System.out.println(i + " is divisible by 3 and 5.");
                sum += i;
                counter += 1;
            }
        }
        System.out.println("The sum of the first 5 numbers that are divisible by 3 and 5 and are between 1 and 1000 (inclusive) is " + sum);
    }

    // ex 1
    public static boolean isOdd(int number){
        if (number < 0){
            return false;
        } else {
            if (number % 2 == 0){
                return false;
            }
        }
        return true;
    }

    public static int sumOdd(int start, int end){
        if (start < 0 || end < 0){
            return -1;
        }
        if (end < start){
            return -1;
        }
        int sum = 0;
        for (int i = start; i <= end; i++){
            if (isOdd(i)){
                sum += i;
            }
        }
        return sum;
    }
}