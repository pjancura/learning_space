package java_17.expressions_statements_methods;

public class CodeBlocksAndIfElse {

    public static void main(String[] args) {
        // boolean gameOver = true;
        int score = 5000;
        int levelComplete = 5;
        // int bonus = 100;

        if (score == 5000) {                                    // from lines 11 - 13 is one code block
            System.out.println(("Your score was 5000"));
        }
        
        if (score < 5000) {
            System.out.println("Your score was less than 5000");
        } else if (levelComplete == 5) {
            System.out.println("Hit else if");
        } else {
            System.out.println("Got here");
        }

        if (score < 5000 && score > 1000) {
            System.out.println("Your score was less than 5000 but greater than 1000");
        } else if (score < 1000) {
            System.out.println("Your score was less than 1000");
        } else {
            System.out.println("Got here");
        }
    }
}