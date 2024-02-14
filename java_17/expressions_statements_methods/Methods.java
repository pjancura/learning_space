package java_17.expressions_statements_methods;

public class Methods {
    

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelComplete = 5;
        int bonus = 100;
        calculateScore(gameOver, score, levelComplete, bonus);

        calculateScore(true, 10000, 8, 200);

        System.out.println("The high score is " + calculateScoreReturns(gameOver, score, levelComplete, bonus));
        
        
    }

    public static void calculateScore(boolean gameOver, int score, int levelComplete, int bonus) {

        int finalScore = score;

        if (gameOver) {                                    
            finalScore += levelComplete * bonus;
            System.out.println("Your final score was " + finalScore);
        } 
    }

    public static int calculateScoreReturns(boolean gameOver, int score, int levelComplete, int bonus) {

        int finalScore = score;

        if (gameOver) {                                    
            finalScore += levelComplete * bonus;
        }

        return finalScore;
    }
}