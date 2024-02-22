package java_17.oop_master_challenge;

import java.util.Scanner;

public class MealOrder {
    private Hamburger hamburger;
    private Drink drink;
    private SideItem sideItem;
    private double totalCost;

    public MealOrder() {
        this.hamburger = new Hamburger("Regular Hamburger");
        this.drink = new Drink();
        this.sideItem = new SideItem();
        this.totalCost = this.calculateTotalCost();
    }

    public MealOrder (Hamburger hamburger, Drink drink, SideItem sideItem) {
        this.hamburger = hamburger;
        this.drink = drink;
        this.sideItem = sideItem;
        this.totalCost = this.calculateTotalCost();
    }
    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double calculateTotalCost() {
        double newTotal = 0.0;
        if (hamburger instanceof SuperBurger) {
            newTotal = 15.00;
            drink.setPrice(0.00);
            sideItem.setPrice(0.00);
        } else {
            newTotal = this.hamburger.getCost() + this.drink.getPrice() + this.sideItem.getPrice();
        }
        return newTotal;
    }

    public void printMealOrder() {
        if (this.hamburger.getClass().getSimpleName() == "SuperBurger") {
            System.out.printf("YOUR DELUXE ORDER:\n--------------------\n%s%s%s\n--------------------\n%20s: %6.2f %n", hamburger.describeHamburger(), drink.describeDrink(), sideItem.describeSideItem(), "TOTAL", this.getTotalCost());
        } else {
            System.out.printf("YOUR ORDER:\n--------------------\n%s%s%s\n--------------------\n%20s: %6.2f %n", hamburger.describeHamburger(), drink.describeDrink(), sideItem.describeSideItem(), "TOTAL", this.getTotalCost());
        }
    }

    public static MealOrder createMealOrder() {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Taylor's Burgers!");
        System.out.println("What kind of hamburger would you like? \n\t (R)egular Hamburger, (C)heese Burger, (D)ouble Burger, (B)acon Burger, (S)uper Burger, or (T)ailored Burger");
        Hamburger hamburger = Hamburger.getHamburger(s.nextLine());
        System.out.println("And what to drink? We have coke products.");
        String drinkType = s.nextLine();
        System.out.println("Size: (S)mall, (M)edium, (L)arge, (N)one");
        String drinkSize = s.nextLine();
        Drink drink = new Drink(drinkType, drinkSize);
        System.out.println("What would like as your side? \n\t (F)ries, (O)nion Rings, (S)alad, (N)one");
        SideItem sideItem = new SideItem(s.nextLine());
        return new MealOrder(hamburger, drink, sideItem);
    }
}
