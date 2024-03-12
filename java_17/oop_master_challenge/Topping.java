package java_17.oop_master_challenge;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Topping {
    private String type;
    private double cost;

    public Topping(String type) {
        this.type = type;
        this.cost = costCalculator(type);
    }

    public double costCalculator(String type) {
        double cost = -1;
        switch(type.toUpperCase().charAt(0)) {
            case 'M' -> cost = 0.50;        // Mushrooms
            case 'B' -> cost = 1.5;         // Bacon
            case 'O' -> cost = 1.0;         // Onions
            case 'C' -> cost = 0.75;        // Cheese
            case 'P' -> cost = 1.5;         // extra patty
            default -> cost = -1;
        };
        return cost;
    }

    public double getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public static double toppingCostCalculator(Topping[] toppings) {
        double totalToppingCost = 0.0;
        for (int i = 0; i < Array.getLength(toppings); i += 1){
            if (toppings[i].getCost() != -1) {
                totalToppingCost += toppings[i].getCost();
            }
        }
        return totalToppingCost;
    }

    public static Topping getTopping() {
        Scanner s = new Scanner(System.in);
        System.out.println("Pick from these toppings: \n (M)ushrooms, (O)nions, (B)acon, (C)heese, an extra (P)atty, or (N)one");
        String topping = " ";
        switch(s.nextLine().toUpperCase().charAt(0)) {
            case 'M' -> topping = "Mushrooms";        // Mushrooms
            case 'B' -> topping = "Bacon";         // Bacon
            case 'O' -> topping = "Onions";         // Onions
            case 'C' -> topping = "Cheese (Extra)";        // Cheese
            case 'P' -> topping = "Patty (Extra)";         // extra patty
            default -> topping = "None";
        };
        Topping newTopping = new Topping(topping);
        return newTopping;
    }
}
