package java_17.practice.guessing_game;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        int randomInt = (int) Math.floor(Math.random() * 101);

        System.out.println("Guess a number between 0 and 100 (inclusive).");

        int guesses = 5;

        Scanner s = new Scanner(System.in);

        while (guesses > 0) {
            int guess = 500;
            try {
                guess = Integer.parseInt(s.nextLine());
            } catch (Exception e) {
                System.out.println("That is not a numeric input. Try again.");
                continue;
            }
            if (guess == randomInt) {
                System.out.println("Congratulations! You guessed the correct number!");
                break;
            } else {
                guesses--;
                guessHigherLower(guess, randomInt);
                System.out.printf("Please enter a number between 0 and 100 (inclusive).\nGuesses Left: %d%n", guesses);
            }
        }

        if (guesses <= 0) {
            System.out.printf("You have used all of your guesses, better luck next time.\nThe number was: %d%n",
                    randomInt);
        }

        s.close();
    }

    public static void guessHigherLower(int guessed, int randomInt) {
        if (guessed < randomInt) {
            System.out.println("Guess HIGHER next time");
        } else {
            System.out.println("Guess LOWER next time");
        }
    }
}