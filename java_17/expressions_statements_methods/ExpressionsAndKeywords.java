package java_17.expressions_statements_methods;

public class ExpressionsAndKeywords {

    public static void main(String[] args) {
        double metersInMile = (1000 * 1.609344);
        System.out.println(metersInMile);

        int highScore = 50;

        if (highScore > 25) {
            highScore = 1000 + highScore;               // add bonus points
        }

        int health = 100;

        if ((health < 25) && (highScore > 1000)) {
            highScore = highScore - 1000;
        }

        
    }
}